package com.jinznet.transit.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jinznet.transit.util.ImageUtil;

@RestController
@RequestMapping("/upload")
public class FileUploadController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/index",method={RequestMethod.GET})
	public ModelAndView index(@RequestParam(value="id",required=false)int id){
		ModelAndView view = new ModelAndView("upload.ftl").addObject("id", id);
		return view;
	}
	
	@RequestMapping(value = "/submit")
	public Object submit(@RequestParam(value = "file", required = false) MultipartFile file,HttpSession session){
//		System.out.println(System.getProperty("catalina.base"));
		long timestamp = System.currentTimeMillis();
		String fileName = "/images/" + timestamp + "_" + file.getOriginalFilename();
		String minFileName = "/images/min/" + timestamp + "_" + file.getOriginalFilename();
		File saveFile = new File(System.getProperty("catalina.base") + fileName);
		File minFile = new File(System.getProperty("catalina.base") + minFileName);
		logger.info("文件路径" + saveFile.getAbsolutePath());
		try {
			if(!minFile.getParentFile().exists()){
				minFile.getParentFile().mkdir();
			}
			FileUtils.writeByteArrayToFile(saveFile, file.getBytes());
			ImageUtil.compress(saveFile, minFile);
		} catch (IOException e) {
			logger.error("保存文件失败",e);
			return false;
		}
		return minFileName;
	}
	
}
