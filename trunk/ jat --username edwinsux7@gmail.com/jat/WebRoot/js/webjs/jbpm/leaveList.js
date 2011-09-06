Ext.namespace("jat.jbpm.leaveList");
jat.jbpm.leaveList.LeaveTaskPanel = Ext.extend(Ext.Panel, {
	id: 'leaveTaskPanelId',
	constructor: function(){
		var _leavePanel = new jat.jbpm.leaveList.LeavePanel();
		var _taskPanel = new jat.jbpm.leaveList.TaskPanel();
		jat.jbpm.leaveList.LeaveTaskPanel.superclass.constructor.call(this, {
			items: [_leavePanel, _taskPanel]
		});
	}
});
/**
 *请假面板
 */
jat.jbpm.leaveList.LeavePanel = Ext.extend(Ext.Panel, {
	id: 'leavePanelId',
	title: '请假栏',
	constructor: function(){
		var _leaveGrid = new jat.jbpm.leaveList.LeaveGrid();
		var _leaveQueryForm = new jat.jbpm.leaveList.LeaveQueryForm();
		jat.jbpm.leaveList.LeavePanel.superclass.constructor.call(this,{
			items: [_leaveQueryForm, _leaveGrid]
		});
	}
});
/**
 * 请假查询面板
 */
jat.jbpm.leaveList.LeaveQueryForm = Ext.extend(Ext.form.FormPanel, {
	height: 30,
	width: '100%',
	constructor: function(){
		jat.jbpm.leaveList.LeaveQueryForm.superclass.constructor.call(this, {
			layout: 'table',
			layoutConfig: {
				columns: 5
			},
			defaults: {
				labelWidth: 60,
				labelAlign: 'right'
			},
			items: [{
				layout: 'form',
				items: [{
					xtype:'datetimefield',  
					format:'H:i',  
					fieldLabel: '查询日期',
					width: 150
				}]
			},{
				layout: 'form',
				items: [{
					xtype:'datetimefield',  
					format:'H:i',  
					fieldLabel: '至',
					width: 150
				}]
			},{
				layout: 'form',
				items: [{
					xtype: 'textfield',
					fieldLabel: '状态',
					width: 100
				}]
			},{
				style: 'margin: 0px 0px 0px 20px;',
				xtype: 'button',
				text: '查询'
			},{
				style: 'margin: 0px 0px 0px 10px;',
				xtype: 'button',
				text: '重置'
			}]
		});
	}
});
/**
 * 请假列表
 */
jat.jbpm.leaveList.LeaveGrid = Ext.extend(Ext.grid.GridPanel, {
	id: 'leaveGridId',
	constructor: function(){
		var _sm = new Ext.grid.CheckboxSelectionModel();
		var _num = new Ext.grid.RowNumberer();
		var _cm = new Ext.grid.ColumnModel([
		    _num, _sm,
		    {
		    	header: '请假天数',
		    	dataIndex: 'day',
		    	align: 'center'
		    },{
		    	header: '事理',
		    	dataIndex: 'content',
		    	align: 'center'
		    },{
		    	header: '状态',
		    	dataIndex: 'status',
		    	align: 'center'
		    },{
		    	header: '申请时间',
		    	dataIndex: 'applyTime',
		    	align: 'center'
		    }
		]);
		var _leaveStore = new Ext.data.JsonStore({
			url: 'leave_listLeave.action',
			Field: ['day','content','status','applyTime']
		});
		var _tbar = new Ext.Toolbar({
			items: [{
		    	text: '添加',
		    	iconCls: '',
		    	handler: jat.jbpm.leaveList.leaveAddFn
		    },{
		    	text: '申请',
		    	iconCls: '',
		    	handler: ''
		    },{
		    	text: '删除',
		    	iconCls: '',
		    	handler: ''
		    }]
		});
		var _paging = new jat.scommon.gridUtils.PagingToolbar("leaveListPage", _leaveStore, 20);
		jat.jbpm.leaveList.LeaveGrid.superclass.constructor.call(this,{
			monitorResize: true, 
			doLayout: function() { 
				this.setWidth(document.body.clientWidth-205);
				this.setHeight((document.body.clientHeight-270)/2);
				Ext.grid.GridPanel.prototype.doLayout.call(this); 
			}, 
			border: false,
			sm: _sm,
			cm: _cm,
			store: _leaveStore,
			tbar: _tbar,
			bbar: _paging
		});
		_leaveStore.load({
			params: {
				start: 0,
				limit: 20
			}
		});
	}
});

/**
 * 任务面板
 */
jat.jbpm.leaveList.TaskPanel = Ext.extend(Ext.Panel, {
	id: 'taskPanelId',
	title: '任务栏',
	constructor: function(){
		var _leaveQueryForm = new jat.jbpm.leaveList.LeaveQueryForm();
		var _taskGrid = new jat.jbpm.leaveList.TaskGrid();
		jat.jbpm.leaveList.TaskPanel.superclass.constructor.call(this,{
			items: [_leaveQueryForm, _taskGrid]
		});
	}
});

/**
 * 任务列表
 */
jat.jbpm.leaveList.TaskGrid = Ext.extend(Ext.grid.GridPanel, {
	id: 'taskGridId',
	constructor: function(){
		var _sm = new Ext.grid.CheckboxSelectionModel();
		var _num = new Ext.grid.RowNumberer();
		var _cm = new Ext.grid.ColumnModel([
		    _num, _sm,
		    {
		    	header: '请假天数',
		    	dataIndex: 'day',
		    	align: 'center'
		    },{
		    	header: '事理',
		    	dataIndex: 'content',
		    	align: 'center'
		    },{
		    	header: '状态',
		    	dataIndex: 'status',
		    	align: 'center'
		    },{
		    	header: '申请时间',
		    	dataIndex: 'applyTime',
		    	align: 'center'
		    }
		]);
		var _taskStore = new Ext.data.JsonStore({
			url: 'leave_listTask.action',
			Field: ['day','content','status','applyTime']
		});
		var _tbar = new Ext.Toolbar({
			items: [{
		    	text: '审批',
		    	iconCls: '',
		    	handler: ''
		    },{
		    	text: '驳回',
		    	iconCls: '',
		    	handler: ''
		    }]
		});
		var _paging = new jat.scommon.gridUtils.PagingToolbar("taskListPage", _taskStore, 20);
		jat.jbpm.leaveList.TaskGrid.superclass.constructor.call(this,{
			monitorResize: true, 
			doLayout: function() { 
				this.setWidth(document.body.clientWidth-205);
				this.setHeight((document.body.clientHeight-270)/2);
				Ext.grid.GridPanel.prototype.doLayout.call(this); 
			},
			border: false,
			sm: _sm,
			cm: _cm,
			store: _taskStore,
			tbar: _tbar,
			bbar: _paging
		});
		_taskStore.load({
			params: {
				start: 0,
				limit: 20
			}
		});
	}
});

/*********************处理理函数******************************/
/**
 * 请假信息添加
 */
jat.jbpm.leaveList.leaveAddFn = function(){
	var leaveWin = new jat.jbpm.leaveForm.LeaveWin();
	leaveWin.show();
}