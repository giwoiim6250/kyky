package com.jinznet.transit.log4j;

import java.lang.reflect.Field;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;

import com.test.car.log4j.LogObject;

public class Log4jUtil {
	private static Logger logger = null;

	static{
//		basicConfig();
		propertyConfig();
		logger = LoggerFactory.getLogger(Log4jUtil.class);
	}
	
	//�����Ѿ�������setFile,�����Ǳ�����Ĵ�����Ϣ����˼�������
	//log4j:ERROR No output stream or file set for the appender named [Daily_Rolling_File].
	static void basicConfig(){
		DailyRollingFileAppender appender = new DailyRollingFileAppender();
		PatternLayout layout = new PatternLayout("[%d{yyyy-MM-dd HH:mm:ss\\} %-5p] [%t] {%c:%L}-%m%n");
		appender.setLayout(layout);
		appender.setFile("E:\\workspace\\Root\\log.log");
		appender.setName("Daily_Rolling_File");
		appender.setThreshold(Level.DEBUG);
		BasicConfigurator.configure(appender);
	}
	
	static void propertyConfig(){
		//���Բ鿴һ��configure��Դ�룬Ŀǰ֧��Property�ķ�ʽ���ݲ�֧��xml��ʽ
		//�����classpath�´���log4j.xml�Ļ�����2�������ļ�����Ч
		//��ʹʹ���˸��ǣ�����log4j��root��Ч֮ǰ��ִ���ļ���ɵĲ���
		//Ҳ����˵���ջ����2���ļ�dailyRollingFileTest.log��log.log
		//����ֻ��log.log�ļ����¼��־��dailyRollingFileTest.logΪ��
		PropertyConfigurator.configure("E:\\workspace\\Root\\src\\test\\resources\\log.properties");
	}
	
	static void print(Level priority){
		System.out.println(logger.isDebugEnabled());
		//����ȫ�ֹ�����
		System.out.println(LoggerFactory.getLogger(Log4jUtil.class).isDebugEnabled());
		if(logger instanceof Log4jLoggerAdapter){
			Log4jLoggerAdapter adapter = ((Log4jLoggerAdapter)logger);
			try {
				Field field = Log4jLoggerAdapter.class.getDeclaredField("logger");
				field.setAccessible(true);
				Object object = field.get(adapter);
				org.apache.log4j.Logger innerLogger = (org.apache.log4j.Logger) object;
				innerLogger.setLevel(priority);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(logger.isDebugEnabled());
		//����ȫ�ֹ�����
		System.out.println(LoggerFactory.getLogger(Log4jUtil.class).isDebugEnabled());
		logger.debug("test debug");
		logger.info("test info");
		logger.error("test error");
	}
	
	//���root��ϸ���ȵ�loggerͬʱ����level����ϸ���ȵ�level���ȼ����
	static void isDebugTest(){
		Logger logger = LoggerFactory.getLogger(LogObject.class);
		System.out.println(logger.isDebugEnabled());
	}
	
	public static void main(String[] args) {
//		print(Level.ERROR);
		isDebugTest();
	}
}
