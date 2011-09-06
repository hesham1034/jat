
package com.sc.jat.ss.security;   

import java.util.Collection;

import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**   
 * ClassName:AccessDecisionManager   
 * Function: 决策类   
 * 当请求访问时，判断用户是否具有访问所需的所有权限
 * @author   sux   
 * @version  1.0, 2011-8-17   
 * @since    ss31.0   
 */
@Component("accessDecisionManager")
public class AccessDecisionManager implements org.springframework.security.access.AccessDecisionManager{
	org.apache.commons.logging.Log log = LogFactory.getLog(AccessDecisionManager.class);
	/**
	 * authentication用户认证后 存有用户的所有权限
	 * configAttributes访问所需要的权限
	 * 若无权则抛出异常
	 */
	public void decide(Authentication authentication, Object arg1, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		//若访问所需权限为空，则说明可以随意访问
		if(null == configAttributes){
			return;
		}
		//若无所需的某一种权限就拒绝访问
		boolean flag = false;
		for(ConfigAttribute configAttribute : configAttributes){
			for(GrantedAuthority gAuthority : authentication.getAuthorities()){
				log.info("conf="+configAttribute.getAttribute()+" auth="+gAuthority.getAuthority());
				if(configAttribute.getAttribute().trim().equals(gAuthority.getAuthority().trim())){
					flag = true;
					break;
				}
			}
			if(!flag){
				throw new AccessDeniedException("");//无权限抛出拒绝异常
			}
			flag = false;
		}
	}

	public boolean supports(ConfigAttribute arg0) {
		return true;   
	}

	public boolean supports(Class<?> arg0) {
		return true;   
	}

}
   
