
package com.sc.jat.ss.service.impl;   

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.sc.jat.ss.dao.ResourcesDao;
import com.sc.jat.ss.model.Resources;
import com.sc.jat.ss.service.ResourcesService;
import com.scommon.util.PagingBean;

/**   
 * ClassName:ResourceServiceImpl   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-9-9   
 * @since    jat1.0   
 */
@Service("resourcesService")
public class ResourcesServiceImpl implements ResourcesService {
	private ResourcesDao resourcesDao;

	public String list(int start, int limit) {
		PagingBean resources = resourcesDao.findByPage(start, limit);
		return JSONObject.fromObject(resources).toString();   
	}
	
	public ResourcesDao getResourcesDao() {
		return resourcesDao;
	}

	public void setResourcesDao(ResourcesDao resourcesDao) {
		this.resourcesDao = resourcesDao;
	}

}
   
