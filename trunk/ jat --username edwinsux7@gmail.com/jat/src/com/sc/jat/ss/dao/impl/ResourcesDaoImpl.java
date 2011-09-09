
package com.sc.jat.ss.dao.impl;   

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sc.jat.ss.dao.ResourcesDao;
import com.sc.jat.ss.model.Resources;
import com.scommon.dao.BaseDao;
import com.scommon.util.PagingBean;

/**   
 * ClassName:ResourcesDaoImpl   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-16   
 * @since    ss31.0   
 */
@Repository("resourcesDao")
public class ResourcesDaoImpl extends BaseDao<Resources> implements ResourcesDao{

	public List<String> findAllUrl() {
		String hql = "SELECT url FROM Resources";  
		return this.findByHQL(hql);   
	}

	public PagingBean findByPage(int start, int limit) {
		String hql = "FROM Resources";  
		return this.findStringByPage(hql, start, limit);   
	}

}
   
