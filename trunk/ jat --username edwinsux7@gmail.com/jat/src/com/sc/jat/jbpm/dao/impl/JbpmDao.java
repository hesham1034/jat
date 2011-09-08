package com.sc.jat.jbpm.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.IdentityService;
import org.jbpm.api.ManagementService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskQuery;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Repository;

import com.scommon.util.PagingBean;

/**   
 * ClassName:JbpmDao   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-29   
 * @since    myLeave1.0   
 */
@Repository("jbpmDao")
public class JbpmDao {
	private ProcessEngine processEngine;
	private RepositoryService repositoryService;
	private TaskService taskService;
	private ExecutionService executionService;
	private HistoryService historyService;
	private ManagementService managementService;
	private IdentityService identityService;

	/**
	 * 
	 * deploy:发布流程 
	 *   
	 * @param  @param path jpdl.xml文件的位置
	 * @param  @return    设定文件   
	 * @return String    返回流程定义ID(key-value)  
	 * @throws    
	 * @since  myLeave1.0
	 */
	public String deploy(String path) {
		return repositoryService.createDeployment().addResourceFromClasspath(path).deploy();
	}

	/**
	 * 
	 * findByUserName:按用户名从task表中查询出任务   
	 *   
	 * @param  @param userName
	 * @param  @return    设定文件   
	 * @return List<Task>    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public List<Task> findByUserName(String userName) {
		return taskService.findPersonalTasks(userName);
	}

	/**
	 * 
	 * findByTaskIdAndProperty:根所任务ID和变量名称从variable表中查询出变量值  
	 *   
	 * @param  @param taskId
	 * @param  @param property
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public Object findByTaskIdAndProperty(String taskId, String property) {
		return taskService.getVariable(taskId, property);
	}
	
	/**
	 * 
	 * startProcessInstance:开始一流程实例
	 *   
	 * @param  @param processDefinitionKey(jpdl.xml文件中process的key)
	 * @param  @param Map(此流程的存入的变量，保存在variable表中)
	 * @param  @param ProcessInstanceKey(为流程实例定义的key)
	 * @param  @return    设定文件   
	 * @return ProcessInstance    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public ProcessInstance startProcessInstance(String processDefinitionKey, Map<String, ?> Map,
			String ProcessInstanceKey) {
		return executionService.startProcessInstanceByKey(processDefinitionKey, Map, ProcessInstanceKey);
	}
	/**
	 * 
	 * completeTask:完成任务
	 *   
	 * @param  @param taskId    设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public void completeTask(String taskId) {
		taskService.completeTask(taskId);
	}
	
	/**
	 * 
	 * completeTask:任务传入指定部分  
	 *   
	 * @param  @param taskId
	 * @param  @param string    设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public void completeTask(String taskId, String task) {
		taskService.completeTask(taskId, task);
	}
	/**
	 * findTaskById:按ID查询出任务
	 *   
	 * @param  @param taskId
	 * @param  @return    设定文件   
	 * @return Task    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public Task findByTaskId(String taskId) {
		return taskService.getTask(taskId);
	}
	
	public ProcessEngine getProcessEngine() {
		return processEngine;
	}

	@Resource
	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = processEngine;
		this.repositoryService = processEngine.getRepositoryService();
		this.taskService = processEngine.getTaskService();
		this.executionService = processEngine.getExecutionService();
		this.historyService = processEngine.getHistoryService();
		this.managementService = processEngine.getManagementService();
		this.identityService = processEngine.getIdentityService();
	}

	/**
	 * 
	 * findByUserName:分页查询任务列表   
	 *   
	 * @param  @param username
	 * @param  @param start
	 * @param  @param limit
	 * @param  @return    设定文件   
	 * @return PagingBean    DOM对象   
	 * @throws    
	 * @since  jat1.0
	 */
	public PagingBean findByUserName(String username, Integer start, Integer limit) {
		TaskQuery query = taskService.createTaskQuery();
		query.assignee(username);
		query.orderDesc(TaskQuery.PROPERTY_CREATEDATE);
		int total = (int) query.count();
		List<Task> tasks = query.page(start, limit).list();
		PagingBean taskBean = new PagingBean(total, tasks);
		return taskBean;   
		
	}

}
