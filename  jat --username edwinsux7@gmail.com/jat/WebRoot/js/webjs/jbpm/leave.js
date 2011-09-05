Ext.namespace("jat.jbpm.leave");
/**
 * 整个请假面板
 */
jat.jbpm.leave.LeavePanel = Ext.extend(Ext.panel, {
	id: 'leavePanelId',
	constructor: function(){
		var _leaveGrid = new jat.jbpm.leave.LeaveGrid();
		var _taskGrid = new jat.jbpm.leave.TaskGrid();
		jat.jbpm.leave.LeavePanel.superclass.constructor.call(this,{
			items: [_leaveGrid, _taskGrid]
		});
	}
});
/**
 * 
 */
jat.jbpm.leave.LeaveGrid = Ext.extend(Ext.data.grid, {
	id: 'leaveGridId',
	constructor: function(){
		var _sm = Ext.grid.CheckboxSelectionModel();
		var _num = Ext.grid.RowNubmerer();
		var _cm = Ext.grid.ColumnModel([
		    _num, _sm,
		    {
		    	header: '请假天数',
		    	dataIndex: 'day',
		    	align: 'center'
		    }
		]);
		var _leaveStore = Ext.data.JsonStore({
			
		});
		jat.jbpm.leave.LeaveGrid.superclass.constructor.call(this,{
			
		});
	}
	
});

jat.jbpm.leave.TaskGrid = Ext.extend(Ext.data.grid, {
	
});