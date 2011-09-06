Ext.namespace("jat.jbpm.leaveForm");

jat.jbpm.leaveForm.LeaveWin = Ext.extend(Ext.Window,{
	id: 'leaveWinId',
	width: 300,
	height: 300,
	constructor: function(){
		var _leaveForm = new jat.jbpm.leaveForm.LeaveForm();
		jat.jbpm.leaveForm.LeaveWin.superclass.constructor.call(this, {
			items: [_leaveForm]
		});
	}
});

jat.jbpm.leaveForm.LeaveForm = Ext.extend(Ext.form.FormPanel, {
	id: 'leaveFormId',
	constructor: function(){
		jat.jbpm.leaveForm.LeaveForm.superclass.constructor.call(this, {
			layout: 'form',
			frame: true,
			labelWidth: 60,
			labelAlign: 'right',
			items: [{
				xtype: 'textfield',
				fieldLabel: '天数',
				width: 150,
				name: 'leave.day'
			},{
				xtype:'datetimefield',  
				format:'H:i',
				fieldLabel: '开始时间',
				width: 150,
				name: 'startTime'
			},{
				xtype: 'datetimefield',
				format: 'H:i',
				fieldLabel: '结束时间',
				width: 150,
				name: 'endTime'
			},{
				xtype: 'textarea',
				fieldLabel: '原因',
				width: 150,
				height: 100,
				name: 'leave.content'
			}],
			buttonAlign: 'center',
			buttons: [{
				text: '确定',
				handler: jat.jbpm.leaveForm.leaveSaveFn
			},{
				text: '取消'
			}]
		});
	}
});
/************************处理函数*********************/
//leave保存函数
jat.jbpm.leaveForm.leaveSaveFn = function(){
	Ext.getCmp('leaveFormId').getForm().submit({
		url: 'leave_save.action',
		success: function(form, action){
			Ext.Msg.confirm('提示',action.result.msg, function(button, text){
				if(button == "yes"){
					form.reset();
					Ext.getCmp('leaveFormId').destroy();
					Ext.getCmp('leaveGridId').getStore().reload({
						params: {
							start: 0,
							limit: 20
						}
					});
				}
			});
		},
		failure: scommon.failure
	});
}