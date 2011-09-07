Ext.namespace("jat.jbpm.leaveFormView");

jat.jbpm.leaveFormView.LeaveFormViewWin = Ext.extend(Ext.Window,{
	id: 'leaveFormViewWinId',
	title: '审核',
	width: 400,
	height: 440,
	constructor: function(_taskId){
		var _leaveViewForm = new jat.jbpm.leaveFormView.LeaveFormView(_taskId);
		jat.jbpm.leaveFormView.LeaveFormViewWin.superclass.constructor.call(this, {
			items: [_leaveViewForm]
		});
	}
});

jat.jbpm.leaveFormView.LeaveFormView = Ext.extend(Ext.form.FormPanel, {
	id: 'leaveFormViewId',
	constructor: function(_taskId){
		var _reader = new Ext.data.JsonReader({},['day','startTime','endTime','applyTime','content',
		    {name: 'username', mapping: 'users.username'},
		    {name: 'leave.id', mapping: 'id'}
		]); 
		jat.jbpm.leaveFormView.LeaveFormView.superclass.constructor.call(this, {
			reader: _reader,
			layout: 'form',
			border: false,
			frame: true,
			labelWidth: 60,
			labelAlign: 'right',
			items: [{
				xtype: 'textfield',
				fieldLabel: '天数',
				width: 150,
				name: 'day'
			},{
				xtype:'textfield',  
				fieldLabel: '开始时间',
				width: 150,
				name: 'startTime'
			},{
				xtype: 'textfield',
				fieldLabel: '结束时间',
				width: 150,
				name: 'endTime'
			},{
				xtype: 'textarea',
				fieldLabel: '原因',
				width: 150,
				height: 100,
				name: 'content'
			},{
				xtype: 'textfield',
				fieldLabel: '申请时间',
				width: 150,
				name: 'applyTime'
			},{
				xtype: 'textfield',
				fieldLabel: '申请人',
				width: 150,
				name: 'username'
			},{
				xtype: 'combo',
				fieldLabel: '审核',
				editable: false,
				mode: 'local',
				triggerAction: 'all',
				store: new Ext.data.SimpleStore({
					fields: ['name', 'value'],
					data: [['通过',0],['驳回',1]]
				}),
				width: 150,
				displayField: 'name',
				valueField: 'value',
				hiddenName: 'leave.status'
			},{
				xtype: 'textarea',
				fieldLabel: '审核意见',
				name: 'leave.auditContent',
				width: 150,
				height: 100
			},{
				xtype: 'hidden',
				name: 'leave.id'
			}],
			buttonAlign: 'center',
			buttons: [{
				text: '确定',
				handler: function(){
					Ext.getCmp('leaveFormViewId').getForm().submit({
						url: 'leave_audit.action',
						params: {
							taskId: _taskId
						},
						success: function(_form, _action){
							Ext.Msg.alert("提示",_action.result.msg);
							Ext.getCmp('taskGridId').getStore().reload({
								params: {
									start: 0,
									limit: 8
								}
							});
						},
						failure: scommon.failure
					});
				}
			},{
				text: '取消'
			}]
		});
	}
});

/****************处理函数*******************/
//jat.jbpm.leaveFormView.leaveAuditFn = 