package com.jinznet.transit.util;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IPAccessCache {
	public static Map<Integer,Map<String,Date>> cache = new ConcurrentHashMap<Integer,Map<String,Date>>();
}
