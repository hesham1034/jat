package com.sc.jat.ss.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sc.jat.ss.dao.AuthoritiesDao;
import com.sc.jat.ss.dao.UsersDao;
import com.sc.jat.ss.model.Users;
import com.sc.jat.ss.vo.CustomUserDetails;

/**   
 * ClassName:UserDetailManager   
 * Function: 查询出用户所具有的权限等信息并进行封装得到UserDetails   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-16   
 * @since    ss31.0   
 */
@Component("userDetailManager")
public class UserDetailManager implements UserDetailsService {
	org.apache.commons.logging.Log log = LogFactory.getLog(UserDetailManager.class);
	private UsersDao usersDao;
	private AuthoritiesDao authoritiesDao;

	/**
	 * 根据用户名取得及权限等信息
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		Users user = usersDao.findByUsername(username);
		if(null == user) return null;
		List<String> authoritiesNames = authoritiesDao.findNameByUsername(username);
		log.info(authoritiesNames);
		List<GrantedAuthority> gAuthoritys = new ArrayList<GrantedAuthority>();
		for (String authoritiesName : authoritiesNames) {
			GrantedAuthorityImpl gai = new GrantedAuthorityImpl(authoritiesName);
			gAuthoritys.add(gai);
		}
		return new CustomUserDetails(user.getId(), user.getPassword(), user.getUsername(), true, true, true, true, gAuthoritys);
	}

	public UsersDao getUsersDao() {
		return usersDao;
	}

	@Resource
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public AuthoritiesDao getAuthoritiesDao() {
		return authoritiesDao;
	}

	@Resource
	public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
		this.authoritiesDao = authoritiesDao;
	}
}
