/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 */
package com.jinznet.transit.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图片压缩处理
 * 
 */
@SuppressWarnings("restriction")
public class ImageUtil {

	public static void compress(File src, File dest) throws IOException {
		Image img = ImageIO.read(src);
		int width = img.getWidth(null);
		int height = img.getHeight(null);
		
		BufferedImage image = new BufferedImage(width, height,BufferedImage.SCALE_SMOOTH);
		image.getGraphics().drawImage(img, 0, 0, width, height, null); // 绘制缩小后的图
		FileOutputStream out = new FileOutputStream(dest); // 输出到文件流
		//可以正常实现bmp、png、gif转jpg
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image); // JPEG编码
		out.close();
	}
}
