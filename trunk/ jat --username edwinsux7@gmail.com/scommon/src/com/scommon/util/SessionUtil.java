package com.scommon.util;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.scommon.memcached.MemcachedSession;
import com.scommon.util.properties.PropertiesHelper;
/**
 * 
 * ClassName:SessionUtil   
 * Function: 缓存处理工具类   
 *   
 * @author   sux   
 * @version     
 * @since    scommon 1.0   
 * @Date     2011    2011-7-3     下午03:06:21   
 *
 */
public class SessionUtil {
	private static SessionUtil sessionUtil = null;
	private static String id;
	private static String useMem;
	private static MemcachedSession memSession;
	
	static{
		Properties properties = PropertiesHelper.getInstance("memcached.properties");
		useMem = properties.getProperty("useMemcache");
	}
	/**
	 * 
	 * setAttribute:存入session或memcache
	 *   
	 * @param  @param key
	 * @param  @param value    设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public static void setAttribute(HttpServletRequest request, String key, Object value){
		id = request.getSession().getId();
		memSession = MemcachedSession.getSession(id);
		if("true".equals(useMem)){
			memSession.setAttribute(key, value);
		}else{
			request.getSession().setAttribute(key, value);
		}
	}
	/**
	 * 
	 * getAttribute:根据key取得value
	 *   
	 * @param  @param key
	 * @param  @return    设定文件   
	 * @return Object    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public static Object getAttribute(HttpServletRequest request, String key){
		id = request.getSession().getId();
		memSession = MemcachedSession.getSession(id);
		Object value = null;
		if("true".equals(useMem)){
			value = memSession.getAttribute(key);
			if(null == value){
				value = request.getSession().getAttribute(key);
			}
			return value;
		}else{
			value = request.getSession().getAttribute(key);
		}
		return value;
	}
	/**
	 * 
	 * removeAttribute:根据key移除缓存内容
	 *   
	 * @param  @param key    设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public static void removeAttribute(HttpServletRequest request, String key){
		id = request.getSession().getId();
		memSession = MemcachedSession.getSession(id);
		memSession.removeAttribute(key);
		request.getSession().removeAttribute(key);
	}
	/**
	 * 
	 * invalid:设置缓存无效
	 *   
	 * @param      设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public static void invalid(HttpServletRequest request){
		id = request.getSession().getId();
		memSession = MemcachedSession.getSession(id);
		memSession.invalid();
		request.getSession().invalidate();
	}
	/**
	 * 
	 * refresh:刷新memcache   
	 *   
	 * @param      设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public static void refresh(HttpServletRequest request){
		id = request.getSession().getId();
		memSession = MemcachedSession.getSession(id);
		memSession.refresh();
	}
}
