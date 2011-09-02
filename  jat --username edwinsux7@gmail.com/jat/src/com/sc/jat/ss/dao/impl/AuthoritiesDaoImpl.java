package com.sc.jat.ss.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sc.jat.ss.dao.AuthoritiesDao;
import com.sc.jat.ss.model.Authorities;
import com.scommon.dao.BaseDao;

/**   
 * ClassName:AuthoritiesDaoImpl   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-16   
 * @since    ss31.0   
 */
@Repository("authoritiesDao")
public class AuthoritiesDaoImpl extends BaseDao<Authorities> implements AuthoritiesDao {

	public List<String> findNameByUsername(String username) {
		String sql = "SELECT a.name FROM users u, roles r, role_authorities ra, authorities a WHERE u.username = ? AND r.id = u.role AND r.id = ra.role AND a.id = ra.authorities";
		List<String> authoritiesNames = super.findBySQL(sql, username);
		return authoritiesNames;
	}

	public List<String> findNameByUrl(String url) {
		String sql = "select a.name from authorities a, authorities_resources ar, resources r "
				+ "where r.url = ? and r.id = ar.resource and a.id = ar.authorities";
		return super.findBySQL(sql, url);
	}

}
