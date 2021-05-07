/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 */
package com.jinznet.transit.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.jinznet.transit.controller.entity.BuyingInfo;
import com.jinznet.transit.excel.ExportExcel;
import com.jinznet.transit.excel.annotation.ExportTitle;
import com.jinznet.transit.service.BuyingInfoService;

/**
 * @author hejian
 *
 */
@RestController
public class DownloadController {
	
	@Autowired
	private BuyingInfoService buyingInfoService;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 

	@RequestMapping("/download")
	public void download(HttpServletResponse response) throws IOException{
		String[] headers = null; 
        Field[] fields = BuyingInfo.class.getDeclaredFields();
		List<String> headerList = Lists.newArrayList();
		for (Field f : fields) {
			String title = "";
			ExportTitle annotation = f.getAnnotation(ExportTitle.class);
			if (annotation != null && annotation.value() != null
					&& annotation.value().length() > 0) {
				title = annotation.value();
			} else {
				title = f.getName();
			}
			headerList.add(title);
		}
        headers = headerList.toArray(new String[0]);
        
        File saveFile = new File(System.getProperty("catalina.base") + "/data.xls");
        FileOutputStream out = new FileOutputStream(saveFile);
        List<BuyingInfo> list = buyingInfoService.queryAll();
		new ExportExcel<BuyingInfo>().exportExcel("Sheet1", headers, list, out, "yyyy-MM-dd"); 
		out.close();
		
		InputStream fileInputStream = new BufferedInputStream(new FileInputStream(saveFile));
		byte[] buffer = new byte[fileInputStream.available()];
		fileInputStream.read(buffer);
		fileInputStream.close();
		
		//清空response  
        response.reset();  
        //设置response的Header  
        response.addHeader("Content-Disposition", "attachment;filename=data.xls");  
        response.addHeader("Content-Length", "" + saveFile.length());
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());  
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
        toClient.write(buffer);  
        toClient.flush();  
        toClient.close();  
        
        if(saveFile.exists()){
        }
	}
	
	@RequestMapping("/images")
	public void downloadImages(HttpServletResponse response) throws IOException {
		File file = new File(System.getProperty("catalina.base") + "/images");
		File[] files = null;
		if(!file.exists()){
			return;
		}
		if(file.isDirectory()){
			files = file.listFiles();
		}else{
			files = new File[1];
			files[0] = file;
		}
		
		InputStream inputStream = null;
		File zipFile = new File(System.getProperty("catalina.base") + "/images_" + dateFormat.format(new Date()) + ".zip");
		ZipOutputStream gzipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
		gzipOutputStream.setLevel(9);
		gzipOutputStream.setComment(new String("comment".getBytes(),"UTF-8"));
		for(File f : files){
			if(f.isDirectory()){
				continue;
			}
			inputStream = new BufferedInputStream(new FileInputStream(f));
			gzipOutputStream.putNextEntry(new ZipEntry(f.getName()));
			byte[] buffer = new byte[2048];
			while((inputStream.read(buffer) != -1)){
				gzipOutputStream.write(buffer);
			}
			IOUtils.closeQuietly(inputStream);
		}
		
		gzipOutputStream.finish();
		gzipOutputStream.flush();
		IOUtils.closeQuietly(gzipOutputStream);
		OutputStream writer = null;
		try{
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition", "attachment;filename=images.zip");
			response.addHeader("Content-Length", "" + zipFile.length());
			writer = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream;charset=UTF-8");
			byte[] buffer = new byte[2048];
			inputStream = new BufferedInputStream(new FileInputStream(zipFile));
			while((inputStream.read(buffer) != -1)){
				writer.write(buffer);
			}
			writer.flush();
			IOUtils.closeQuietly(writer);
		}finally{
			IOUtils.closeQuietly(inputStream);
			if (zipFile.exists()) {
				zipFile.delete();
			}
		}

	}
}
