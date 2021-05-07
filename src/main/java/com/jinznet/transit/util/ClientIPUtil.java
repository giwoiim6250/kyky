package com.jinznet.transit.util;

import javax.servlet.http.HttpServletRequest;

public class ClientIPUtil {

	/** 
     * 获取访问者IP 
     *  
     * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。 
     *  
     * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)， 
     * 如果还不存在则调用Request .getRemoteAddr()。 
     *  
     * @param request 
     * @return 
     */
	public static String getIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for"); 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_CLIENT_IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getRemoteAddr(); 
	    }else{
	    	 // 多次反向代理后会有多个IP值，第一个为真实IP。  
            int index = ip.indexOf(',');  
            if (index != -1) {  
                ip = ip.substring(0, index);  
            } 
	    }
	    return ip; 
	}
}
