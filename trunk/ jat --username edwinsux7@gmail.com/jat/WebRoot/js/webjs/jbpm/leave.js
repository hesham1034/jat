Ext.namespace("jat.jbpm.leave");
jat.jbpm.leave.LeaveTaskPanel = Ext.extend(Ext.Panel, {
	id: 'leaveTaskPanelId',
	constructor: function(){
		//var _leavePanel = new jat.jbpm.leave.LeavePanel();
		//var _taskPanel = new jat.jbpm.leave.TaskPanel();
		jat.jbpm.leave.LeaveTaskPanel.superclass.constructor.call(this, {
			items: []
		});
	}
});
/**
 *请假面板
 */
jat.jbpm.leave.LeavePanel = Ext.extend(Ext.Panel, {
	id: 'leavePanelId',
	title: '请假栏',
	constructor: function(){
		var _leaveGrid = new jat.jbpm.leave.LeaveGrid();
		var _leaveQueryForm = new jat.jbpm.leave.LeaveQueryForm();
		jat.jbpm.leave.LeavePanel.superclass.constructor.call(this,{
			items: [_leaveQueryForm, _leaveGrid]
		});
	}
});
/**
 * 请假查询面板
 */
jat.jbpm.leave.LeaveQueryForm = Ext.extend(Ext.form.FormPanel, {
	height: '100%',
	width: '100%',
	constructor: function(){
		jat.jbpm.leave.LeaveQueryForm.superclass.constructor.call(this, {
			layout: 'table',
			layoutConfig: {
				columns: 4
			},
			defaults: {
				labelWidth: 60,
				labelAlign: 'right'
			},
			items: [{
				layout: 'form',
				items: [{
					xtype: 'datefield',
					fieldLabel: '查询日期',
					format: 'Y-m-d',
					width: 100
				}]
			},{
				layout: 'form',
				items: [{
					xtype: 'datefield',
					fieldLabel: '至',
					format: 'Y-m-d',
					width: 100
				}]
			},{
				layout: 'form',
				items: [{
					xtype: 'textfield',
					fieldLabel: '状态',
					width: 100
				}]
			},{
				buttons:[{
					text: '查询',
					handler: ''	
				},{
					text: '重置',
					handler: ''
				}]
			}]
		});
	}
});
/**
 * 请假列表
 */
jat.jbpm.leave.LeaveGrid = Ext.extend(Ext.grid.GridPanel, {
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
		    	handler: ''
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
		var _paging = new jat.scommon.gridUtils.PagingToolbar(_leaveStore, 20);
		jat.jbpm.leave.LeaveGrid.superclass.constructor.call(this,{
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
jat.jbpm.leave.TaskPanel = Ext.extend(Ext.Panel, {
	id: 'taskPanelId',
	title: '任务栏',
	constructor: function(){
		var _leaveQueryForm = new jat.jbpm.leave.LeaveQueryForm();
		var _taskGrid = new jat.jbpm.leave.TaskGrid();
		jat.jbpm.leave.TaskPanel.superclass.constructor.call(this,{
			items: [_leaveQueryForm, _taskGrid]
		});
	}
});

/**
 * 任务列表
 */
jat.jbpm.leave.TaskGrid = Ext.extend(Ext.grid.GridPanel, {
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
		var _leaveStore = new Ext.data.JsonStore({
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
		var _paging = new jat.scommon.gridUtils.PagingToolbar(_leaveStore, 20);
		jat.jbpm.leave.TaskGrid.superclass.constructor.call(this,{
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
