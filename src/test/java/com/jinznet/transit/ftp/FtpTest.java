package com.jinznet.transit.ftp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FtpTest {

	private static String FTP_IP = "transit.jinznet.com";
	
	private static int FTP_PORT = 22;
	
	private static String USERNAME = "root";
	
	private static String PASSWORD = "Qazxswcde!4321";
	
	public static void mavenPackageTest(){
		
	}
	
	public static void uplaodTest() throws Exception{
		ChannelSftp sftp = null;
		JSch jsch = new JSch();
		Session sshSession = jsch.getSession(USERNAME, FTP_IP, FTP_PORT);
		sshSession.setPassword(PASSWORD);
		sshSession.setConfig("StrictHostKeyChecking", "no");
		sshSession.connect();
		Channel channel = sshSession.openChannel("sftp");
		channel.connect();
		sftp = (ChannelSftp) channel;
		/*InputStream is = sftp.get("/root/.mysql_history");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String line = "";
		while((line = reader.readLine()) != null){
			System.out.println(line);
		}
		reader.close();*/
		sftp.put(System.getProperty("user.dir") + "/target/ROOT.war","/home/tss/tomcat8080/webapps/ROOT.war");
		sshSession.disconnect();
	}
	
	public static void runCommandTest() throws Exception{
//		String[] cmd = { "cmd.exe", "-c", "cd " + currentPath + "; mvn package;"};
		Process process = Runtime.getRuntime().exec("batch.bat");
		String line = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(),"UTF-8"));
		while((line = reader.readLine()) != null){
			System.out.println(line);
		}
		process.waitFor();
		process.destroy();
	}
	
	public static void main(String[] args) {
		try {
			runCommandTest();
			uplaodTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
