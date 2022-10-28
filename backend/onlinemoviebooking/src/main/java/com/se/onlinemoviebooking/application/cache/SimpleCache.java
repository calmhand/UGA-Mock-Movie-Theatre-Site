package com.se.onlinemoviebooking.application.cache;

import java.util.HashMap;

public class SimpleCache {

	private HashMap<String, String> cacheMap;

	private static SimpleCache simpleCache = null;

	// let this be singleton for now
	public static SimpleCache getInstance() {
		if (simpleCache == null) {
			try {
				simpleCache = new SimpleCache();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return simpleCache;
	}

	public SimpleCache() {
		cacheMap = new HashMap<String, String>(500);
	}

	public void add(String key, String value) {
		if (key == null) {
			return;
		}
		if (value == null) {
			cacheMap.remove(key);
		} else {

			cacheMap.put(key, value);
		}
	}

	public void remove(String key) {
		cacheMap.remove(key);
	}

	public String get(String key) {
		return cacheMap.get(key);
	}

	public void clear() {
		cacheMap.clear();
	}

	public long size() {
		return cacheMap.size();
	}

}
