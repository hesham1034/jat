package com.scommon.memcached;

import java.util.Map;
/**
 * 通过一个全局的Map对本会话进行操作
 * 操作Map中key-value的增删
 * 将Map保存到memcached中
 * @author Administrator
 *
 */
public class MemcachedSession {
	//session's id
	private String id;
	//store all infomation of session
	private Map session;
	
	private MemcachedSession(String id){
		this.id = id;
		this.session =  MemcachedService.getInstance().getSession(id);
	}
	public MemcachedSession(){}
	
	public static MemcachedSession getSession(String id){
		MemcachedSession memcachedSession = null;
		memcachedSession = new MemcachedSession(id);
		return memcachedSession;
	}
	
	public void setAttribute(String key, Object value){
		if(null == key || key.trim().length() <= 0){
			return;
		}
		session.put(key, value);
		MemcachedService.getInstance().saveSession(id, session);
	}
	
	public Object getAttribute(String key){
		if(null == key || key.trim().length() <= 0){
			return null;
		} 
		return session.get(key);
	}
	
	public void removeAttribute(String key){
		if(null == key || key.trim().length() <= 0){
			return;
		}
		session.remove(key);
		MemcachedService.getInstance().saveSession(id, session);
	}
	
	public void refresh(){
		MemcachedService.getInstance().UpdateTimeOut(id);
	}
	
	public void invalid(){
		session.clear();
		MemcachedService.getInstance().removeSession(id);
	}
}