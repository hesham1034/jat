Ext.namespace("jat.jbpm.leaveForm");

jat.jbpm.leaveForm.LeaveWin = Ext.extend(Ext.Window,{
	id: 'leaveWinId',
	constructor: function(){
		jat.jbpm.leaveForm.LeaveWin.superclass.constructor.call(this, {
			
		});
	}
});

jat.jbpm.leaveForm.LeaveForm = Ext.extend(Ext.form.FormPanel, {
	id: 'leaveFormId',
	constructor: function(){
		jat.jbpm.leaveForm.LeaveForm.superclass.constructor.call(this, {
			layout: 'table',
			layoutConfig: {
				columns: 4
			},
			defaults: {
				labelWidth: 60,
				labelAlign: 'right'
			},
			items: [{
				xtype: 'textfield',
				fieldLabel: '天数'
			}]
		});
	}
});