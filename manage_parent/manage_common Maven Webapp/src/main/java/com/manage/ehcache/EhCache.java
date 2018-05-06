package com.manage.ehcache;

import javax.annotation.Resource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;

@Component
public class EhCache {

	private static final String cache_store = "manage";
	
	public static final String permiss = "permiss";
	
	private static  EhCacheCacheManager cacheManager;
	
	public static EhCacheCacheManager getCacheManager() {
		return cacheManager;
	}
	

	@Resource(name="ehCacheManager")
	public  void setCacheManager(EhCacheCacheManager cacheManager) {
		EhCache.cacheManager = cacheManager;
	}


	/**
	 * 添加缓存
	 * @param key
	 * @param value
	 */
	public static void putDefault(Object key,Object value){
		CacheManager  cm = cacheManager.getCacheManager();
		Cache cache = cm.getCache(cache_store);
		Element element = new Element(key, value);
		cache.put(element);
	}
	
	/**
	 * 添加缓存
	 * @param key
	 * @param value
	 */
	public static void put(String store,Object key,Object value){
		CacheManager  cm = cacheManager.getCacheManager();
		Cache cache = cm.getCache(store);
		Element element = new Element(key, value);
		cache.put(element);
	}
	
	
	/**
	 * 得到key的值
	 * @param key
	 * @return
	 */
	public static Object getDefault(Object key){
		CacheManager  cm = cacheManager.getCacheManager();
		Cache cache = cm.getCache(cache_store);
		Element element  = cache.get(key);
		if(element != null){
			return element.getObjectValue();
		}
		return null;
	}
	
	/**
	 * 得到key的值
	 * @param key
	 * @return
	 */
	public static Object get(String store,Object key){
		CacheManager  cm = cacheManager.getCacheManager();
		Cache cache = cm.getCache(store);
		Element element  = cache.get(key);
		if(element != null){
			return element.getObjectValue();
		}
		return null;
	}
	
	
	/**
	 * 是否存在
	 * @param key
	 * @return
	 */
	public static  boolean isExistsDefault(Object key){
	
		boolean flag = false;
		try {
			CacheManager  cm = cacheManager.getCacheManager();
			Cache cache = cm.getCache(cache_store);
			Element element = cache.get(key);
			if(null!= element){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 是否存在
	 * @param key
	 * @return
	 */
	public static  boolean isExists(String store,Object key){
	
		boolean flag = false;
		try {
			CacheManager  cm = cacheManager.getCacheManager();
			Cache cache = cm.getCache(store);
			Element element = cache.get(key);
			if(null!= element){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public static boolean delDefault(Object key){
		boolean flag = false;
		if(isExistsDefault(key)){
			CacheManager  cm = cacheManager.getCacheManager();
			Cache cache = cm.getCache(cache_store);
		    flag = cache.remove(key);
		}
		return flag;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public static boolean del(String store,Object key){
		boolean flag = false;
		if(isExists(store,key)){
			CacheManager  cm = cacheManager.getCacheManager();
			Cache cache = cm.getCache(store);
		    flag = cache.remove(key);
		}
		return flag;
	}

	
	/**
	 * 得到整个缓存
	 * @param key
	 * @param value
	 */
	public static Cache getCacheDefault(){
		CacheManager  cm = cacheManager.getCacheManager();
		Cache cache = cm.getCache(cache_store);
		return cache;
	}
	
	/**
	 * 得到整个缓存
	 * @param key
	 * @param value
	 */
	public static Cache getCache(String store){
		CacheManager  cm = cacheManager.getCacheManager();
		Cache cache = cm.getCache(store);
		return cache;
	}
	
}
