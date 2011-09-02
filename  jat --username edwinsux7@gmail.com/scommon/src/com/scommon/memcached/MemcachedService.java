package com.scommon.memcached;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.scommon.util.properties.PropertiesHelper;
/**
 * memcached创建及对Map的基本操作
 * @author Administrator
 *
 */
public class MemcachedService {
	
	private static MemcachedService memcachedService = null;
	private static String serverList = "127.0.0.1:11211";
	private static String poolName = "memcachedPool";
	private static SockIOPool sockIOPool = null;
	private static String timeOut = "15";
	
	static{
		Properties properties = PropertiesHelper.getInstance("memcached.properties");
		serverList = properties.getProperty("serverList", serverList);
		poolName = properties.getProperty("poolName", poolName);
		timeOut = properties.getProperty("outTime", timeOut);
		sockIOPool = SockIOPool.getInstance();
	}
	public MemcachedService(){
		//服务器列表和其权重
		String[] servers = serverList.split(",");
		//Integer[] weights = {3,4};
		
		//获取socke连接池的实例对象
		sockIOPool = SockIOPool.getInstance(poolName);
		
		//设置服务器信息
		sockIOPool.setServers(servers);
		//pool.setWeights(weights);
		
		//设置初始连接数、最小和最大连接数以及最大处理时间
		sockIOPool.setInitConn(5);
		sockIOPool.setMinConn(5);
		sockIOPool.setMaxConn(250);
		//pool.setMaxIdle(1000*60*60*6);
		
		//设置主线程的睡眠时间
		sockIOPool.setMaintSleep(30);
		
		//设置TCP的参数，连接超时等
		sockIOPool.setNagle(false);
		sockIOPool.setSocketTO(3000);
		//pool.setSocketConnectTO(0);
		
		sockIOPool.setFailover(true);
		sockIOPool.setFailback(true);
		sockIOPool.setAliveCheck(true);
		sockIOPool.initialize();
	}
	private MemCachedClient getMemCachedClient() {
		MemCachedClient mcc = new MemCachedClient(poolName);
		//mcc.setPoolName(poolName);
		//mcc.setCompressEnable(false);
		//mcc.setCompressThreshold(0);
		return mcc;
	}
	
	/**
	 * return outtime date
	 * @return
	 */
	public Date getTimeOut(){
		Calendar calendar = Calendar.getInstance();
		long time = calendar.getTimeInMillis();
		time += Integer.parseInt(timeOut)*60*1000;
		calendar.setTimeInMillis(time);
		return calendar.getTime();
	}
	
	public void saveSession(String id, Map session){
		MemCachedClient mcc = getMemCachedClient();
		if(mcc.keyExists(id)){
			if(null != session){
				mcc.replace(id, session, getTimeOut());
			}
		}else{
			if(null == session){
				session = new HashMap(5);
			}
			mcc.add(id, session, getTimeOut());
		}
	}
	
	public Map getSession(String id){
		MemCachedClient mcc = getMemCachedClient();
		Map session = null;
		if(mcc.keyExists(id)){
			session = (Map)mcc.get(id);
			mcc.replace(id, session, getTimeOut());
		}
		if(null == session){
			session = new HashMap(5);
			mcc.add(id, session, getTimeOut());
		}
		return session;
	}
	
	public void removeSession(String id){
		MemCachedClient mcc = getMemCachedClient();
		mcc.delete(id);
	}
	
	public void UpdateTimeOut(String id){
		MemCachedClient mcc = getMemCachedClient();
		if(mcc.keyExists(id)){
			Map session = (Map)mcc.get(id);
			mcc.replace(id, session, getTimeOut());
		}
	}
	
	public static MemcachedService getInstance(){
		if(null == memcachedService){
			memcachedService = new MemcachedService();
		}
		return memcachedService;
	}
	public static void main(String[] args){
		Map map = new HashMap();
		map.put("key", "value");
		MemcachedService ms = getInstance();
		ms.saveSession("id", map);
		Map map2 = ms.getSession("id");
		System.out.println(map2.get("key"));
	}
}
