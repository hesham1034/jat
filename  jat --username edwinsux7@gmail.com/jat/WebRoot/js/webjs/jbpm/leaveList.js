Ext.namespace("jat.jbpm.leaveList");
jat.jbpm.leaveList.LeaveTaskPanel = Ext.extend(Ext.Panel, {
	id: 'leaveTaskPanelId',
	constructor: function(){
		Ext.QuickTips.init();
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
		var _nextTaskPanel = new jat.jbpm.leaveList.NextTaskPanel();
		jat.jbpm.leaveList.LeavePanel.superclass.constructor.call(this,{
			items: [_leaveQueryForm,{
				layout: 'column',
				items: [_leaveGrid ,_nextTaskPanel]
			}]
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
		Ext.QuickTips.init();
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
		    	align: 'center',
		    	renderer: function(value){
		    		return jat.scommon.gridUtils.QTip(value, 10);
		    	}
		    },{
		    	header: '开始时间',
		    	dataIndex: 'startTime',
		    	align: 'center'
		    },{
		    	header: '结束时间',
		    	dataIndex: 'endTime',
		    	align: 'center'
		    },{
		    	header: '状态',
		    	dataIndex: 'status',
		    	align: 'center',
		    	renderer: jat.jbpm.leaveList.returnStatus
		    },{
		    	header: '填写时间',
		    	dataIndex: 'addTime',
		    	align: 'center'
		    },{
		    	header: '操作',
		    	dataIndex: 'id',
		    	align: 'center',
		    	renderer: function(_value,  _cellMeta, _record, _rowIndex, _columnIndex, _store){
		    		var _status = _record.data['status'];
		    		var _str = '';
		    		if(_status == 0 || _status == 7 || _status == 8){
		    			_str += '<a href="javascript:void(0)">编辑</a>&nbsp;&nbsp;';
		    		}
		    		if(_status == 0){
		    			_str += '<a href="javascript:void(0)" onclick="jat.jbpm.leaveList.leaveSingleApplyFn(\''+_value+'\')">申请</a>';
		    			_str += '&nbsp;&nbsp;';
		    		}
		    		_str += '<a href="">查看</a>';
		    		return _str;
		    	}
		    }
		]);
		var _leaveStore = new Ext.data.JsonStore({
			url: 'leave_listLeave.action',
			totalProperty: 'totalProperty',
			root: 'root',
			fields: ['day','content','status','addTime','startTime','endTime','id']
		});
		var _tbar = new Ext.Toolbar({
			items: [{
		    	text: '添加',
		    	iconCls: '',
		    	tooltip: '添加请假信息',
		    	handler: jat.jbpm.leaveList.leaveAddFn
		    },{
		    	text: '申请',
		    	iconCls: '',
		    	handler: jat.jbpm.leaveList.leaveApplyFn
		    },{
		    	text: '删除',
		    	iconCls: '',
		    	handler: ''
		    }]
		});
		var _paging = new jat.scommon.gridUtils.PagingToolbar("leaveListPage", _leaveStore, 8);
		jat.jbpm.leaveList.LeaveGrid.superclass.constructor.call(this,{
			columnWidth: .89,
			//充满整行
			viewConfig : {
				forceFit : true
			},
			stripeRows : true, //行颜色交替效果
			monitorResize: true, 
			doLayout: function() { 
				this.setWidth(document.body.clientWidth-410);
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
				limit: 8
			}
		});
	}
});
/**
 * 下一任务
 */
jat.jbpm.leaveList.NextTaskPanel = Ext.extend(Ext.Panel,{
	title: '下一任务',
	constructor: function(){
		var _nextTaskStore = new Ext.data.JsonStore({
			url: 'leave_listNextPerson.action',
			fields: ['username'],
			listeners: {'load': function(){
				Ext.Ajax.request({
					url: 'leave_listNextTask.action',
					success: function(response, options){
						var _data = Ext.util.JSON.decode(response.responseText);
						Ext.getCmp('nextTaskName').setValue(_data.msg);
					},
					failure: scommon.ajaxFailure
				});
			}}
		});
		jat.jbpm.leaveList.NextTaskPanel.superclass.constructor.call(this,{
			defaults: {
				labelWidth: 60,
				labelAlign: 'right'
			},
			columnWidth: .15,
			border: false,
			items: [{
				layout: 'form',
				style: 'padding-top: 10px;',
				items: [{
					xtype: 'textfield',
					fieldLabel: '下一任务',
					width: 110,
					readOnly: true,
					id: 'nextTaskName'
				}]
			},{
				layout: 'form',
				items: [{
					xtype: 'combo',
					fieldLabel: '执行人',
					editable: false,
					mode: 'local',
					triggerAction: 'all',
					store: _nextTaskStore,
					displayField: 'username',
					valueField: 'username',
					width: 110,
					id: 'nextTaskPerson'
				}]
			}]
		});
		_nextTaskStore.load();
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
		var _nextTaskPanel2 = new jat.jbpm.leaveList.NextTaskPanel2();
		jat.jbpm.leaveList.TaskPanel.superclass.constructor.call(this,{
			items: [_leaveQueryForm,{
				layout: 'column',
				items: [_taskGrid ,_nextTaskPanel2]
			}]
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
		    	header: '事由',
		    	dataIndex: 'content',
		    	align: 'center',
		    	renderer: function(_value){
		    		return jat.scommon.gridUtils.QTip(_value, 10);
		    	}
		    },{
		    	header: '开始时间',
		    	dataIndex: 'startTime',
		    	align: 'center'
		    },{
		    	header: '结束时间',
		    	dataIndex: 'endTime',
		    	align: 'center'
		    },{
		    	header: '状态',
		    	dataIndex: 'status',
		    	align: 'center',
		    	renderer: jat.jbpm.leaveList.returnStatus
		    },{
		    	header: '申请时间',
		    	dataIndex: 'applyTime',
		    	align: 'center'
		    },{
		    	header: '申请人',
		    	dataIndex: 'users',
		    	align: 'center',
		    	renderer: function(_value){
		    		return _value.username;
		    	}
		    },{
		    	header: '操作',
		    	dataIndex: 'taskId',
		    	align: 'center',
		    	renderer: function(_value,  _cellMeta, _record, _rowIndex, _columnIndex, _store){
		    		var _str = '';
		    		var _status = _record.data['status'];
		    		var _id = _record.data['id'];
		    		if(_status == 1 || _status == 2){
		    			_str += '<a href="javascript:void(0)" onclick="jat.jbpm.leaveList.leaveAuditFn(\''+_value+'\', \''+_id+'\')">审核</a>&nbsp;&nbsp;';
		    		}
		    		_str += '<a href="javascript:void(0)">查看</a>';
		    		return _str;
		    	}
		    }
		]);
		var _taskStore = new Ext.data.JsonStore({
			url: 'leave_listTask.action',
			totalProperty: 'totalProperty',
			root: 'root',
			fields: ['day','content','status','applyTime', 'startTime', 'endTime', 'taskId', 'id', 'users']
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
		var _paging = new jat.scommon.gridUtils.PagingToolbar("taskListPage", _taskStore, 8);
		jat.jbpm.leaveList.TaskGrid.superclass.constructor.call(this,{
			columnWidth: .89,
			//充满整行
			viewConfig : {
				forceFit : true
			},
			stripeRows : true, //行颜色交替效果
			monitorResize: true, 
			doLayout: function() { 
				this.setWidth(document.body.clientWidth-410);
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
				limit: 8
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
};
/**
 * 单个请假申请 
 */
jat.jbpm.leaveList.leaveSingleApplyFn = function(_id){
	var _nextTaskPerson = Ext.getCmp('nextTaskPerson').getValue();
	Ext.Ajax.request({
		url: 'leave_apply.action',
		method: 'post',
		params: {
			ids: _id,
			nextTaskPerson:  _nextTaskPerson
		},
		success: function(response, options){
			var _data = Ext.util.JSON.decode(response.responseText);
			Ext.Msg.alert("提示",_data.msg);
			Ext.getCmp('leaveGridId').getStore().reload({
				params: {
					start: 0,
					limit: 8
				}
			});
		},
		failure: scommon.ajaxFailure
	});
};
/**
 * 审核
 */
jat.jbpm.leaveList.leaveAuditFn = function(_taskId, _id){
	var _leaveViewForm = new jat.jbpm.leaveFormView.LeaveFormViewWin(_taskId);
	Ext.getCmp('leaveFormViewId').getForm().load({
		url: 'leave_edit.action',
		params: {
			ids : _id
		}
	});
	_leaveViewForm.show();
};

/**
 * 下一任务
 */
var _nextTaskStore2 = new Ext.data.JsonStore({
	url: '',
	fields: ['username']
});
jat.jbpm.leaveList.NextTaskPanel2 = Ext.extend(Ext.Panel,{
	title: '下一任务',
	constructor: function(){
		jat.jbpm.leaveList.NextTaskPanel2.superclass.constructor.call(this,{
			defaults: {
				labelWidth: 60,
				labelAlign: 'right'
			},
			columnWidth: .15,
			border: false,
			items: [{
				layout: 'form',
				style: 'padding-top: 10px;',
				items: [{
					xtype: 'textfield',
					fieldLabel: '下一任务',
					width: 110,
					id: 'nextTaskName2'
				}]
			},{
				layout: 'form',
				items: [{
					xtype: 'combo',
					fieldLabel: '执行人',
					mode: 'local',
					store: _nextTaskStore2,
					displayField: 'username',
					valueField: 'username',
					width: 110,
					id: 'nextTaskPerson2'
				}]
			}]
		}); 
	}
});

/**
 * 状态值判断返回
 */
jat.jbpm.leaveList.returnStatus =  function(value){
	if(value == 0){
		return "未申请";
	}else if(value == 1){
		return "待经理审核";
	}else if(value == 2){
		return "待老板审核";
	}else if(value == 3){
		return "经理审核通过";
	}else if(value == 4){
		return "老板审核通过";
	}else if(value == 5){
		return "经理审核不通过";
	}else if(value == 6){
		return "老板审核不通过";
	}else if(value == 7){
		return "经理驳回";
	}else if(value == 8){
		return "老板驳回";
	}
};
//http://code.google.com/p/quicklaud-rbac/