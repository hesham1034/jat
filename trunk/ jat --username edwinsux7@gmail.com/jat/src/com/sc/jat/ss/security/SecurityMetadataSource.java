
package com.sc.jat.ss.security;   

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;
import org.springframework.stereotype.Component;

import com.sc.jat.ss.dao.AuthoritiesDao;
import com.sc.jat.ss.dao.ResourcesDao;

/**   
 * ClassName:SecurityMetadataSource   
 * Function: 资源与权限建立管理   
 * 在服务器启动时就加载所有访问URL所需的权限，存入resourceMap集合中。
 *   Spring在设置完一个bean所有的合作者后，会检查bean是否实现了InitializingBean接口，
 *   如果实现就调用bean的afterPropertiesSet方法。  但这样便造成bean和spring的耦合，
 *   最好用init-method
 * @author   sux   
 * @version  1.0, 2011-8-17   
 * @since    ss31.0   
 */
@Component("securityMetadataSource")
public class SecurityMetadataSource  implements FilterInvocationSecurityMetadataSource, InitializingBean{
	org.apache.commons.logging.Log log = LogFactory.getLog(SecurityMetadataSource.class);
	
	private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	
	private Map<String, Collection<ConfigAttribute>> resourceMap = null;
	
	private AuthoritiesDao authoritiesDao;
	
	private ResourcesDao resourcesDao;
	
	/**
	 * 构造方法中建立请求url(key)与权限(value)的关系集合
	 */
	public void afterPropertiesSet() throws Exception {
		
		//查询出所有资源
		List<String> urls = resourcesDao.findAllUrl();
		Collection<ConfigAttribute> cAttributes = null;
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		for(String url : urls){
			List<String> auths =  authoritiesDao.findNameByUrl(url);
			if(resourceMap.containsKey(url)){
				cAttributes = resourceMap.get(url);
			}else{
				cAttributes = new ArrayList<ConfigAttribute>();
			}
			for(String auth : auths){
				ConfigAttribute ca = new SecurityConfig(auth);
				cAttributes.add(ca);
			}
			resourceMap.put(url, cAttributes);
		}
		log.info(resourceMap);
	}
	
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;   
		
	}
	/**
	 * 根据请求的url从集合中查询出所需权限 
	 */
	public Collection<ConfigAttribute> getAttributes(Object arg0) throws IllegalArgumentException {
		String url = ((FilterInvocation) arg0).getRequestUrl();
		log.info("request url is "+url);
		int position = url.indexOf("?");
		if(-1 != position){
			url = url.substring(0, position);
		}
		Iterator<String> it = resourceMap.keySet().iterator();
		while(it.hasNext()){
			//判断两地址是否相同
			if(urlMatcher.pathMatchesUrl(url, it.next())){
				log.info(resourceMap.get(url));
				return resourceMap.get(url);
			}
		}
		return null;   
	}
	/**
	 * 返回false则报错 
	 * SecurityMetadataSource does not support secure object class: 
	 * class org.springframework.security.web.FilterInvocation
	 */
	public boolean supports(Class<?> arg0) {
		return true;   
	}

	public AuthoritiesDao getAuthoritiesDao() {
		return authoritiesDao;
	}
	@Resource
	public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
		this.authoritiesDao = authoritiesDao;
	}

	public ResourcesDao getResourcesDao() {
		return resourcesDao;
	}
	@Resource
	public void setResourcesDao(ResourcesDao resourcesDao) {
		this.resourcesDao = resourcesDao;
	}

}
   
