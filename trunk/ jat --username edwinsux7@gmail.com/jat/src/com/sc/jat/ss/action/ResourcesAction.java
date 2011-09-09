package com.sc.jat.ss.action;   

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sc.jat.ss.service.ResourcesService;
import com.scommon.action.BaseAction;

/**   
 * ClassName:ResourceAction   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-9-9   
 * @since    jat1.0   
 */
@Controller("resourcesAction")
@Scope("prototype")
public class ResourcesAction extends BaseAction{
	private ResourcesService resourcesService;
	private Integer start;
	private Integer limit;
	
	public void list(){
		String resources = resourcesService.list(start, limit);
		this.out(resources);
	}

	public ResourcesService getResourcesService() {
		return resourcesService;
	}
	@Resource
	public void setResourcesService(ResourcesService resourcesService) {
		this.resourcesService = resourcesService;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
   
