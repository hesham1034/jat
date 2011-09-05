Ext.namespace("jat.authority");
/**
 * @author sux
 * @date 2011-09-03
 * @desc 用户信息面板
 */

jat.authority.UserPanel = Ext.extend(Ext.Panel, {
	id: 'userPanelId',
	constructor: function(){
		var _userQueryForm = new jat.authority.UserQueryForm();
		var _userList = new jat.authority.UserList();
		jat.authority.UserPanel.superclass.constructor.call(this,{
			items: [_userQueryForm,_userList]
		})
	}
})

jat.authority.UserQueryForm = Ext.extend(Ext.FormPanel, {
	id: 'userQueryFormId',
	height: 70,
	construtctor: function(){
		jat.authority.UserQueryForm.superclass.constructor.call(this,{
			
		})		
	}
})

jat.authority.UserList = Ext.extend(Ext.grid.GridPanel,{
	id: 'userListId',
	constructor: function(){
		var _sm = new Ext.grid.CheckboxSelectionModel();
		var _num = new Ext.grid.NumberColumn();
		var _cm = new Ext.grid.ColumnModel([
				_num, _sm,
				{
					header: '用户名',
					dataIndex: 'username',
					align: 'center'
				},{
					header: '角色名',
					dataIndex: 'role',
					align: 'center'
				},{
					header: '是否禁用',
					dataIndex: 'enabled',
					align: 'center'
				}
			]);
		var _userStore = new Ext.data.JsonStore({
			url: 'user_list.action',
			root: 'root',
			totalProperty: 'totalProperty',
			fields: ['username', 'role', 'enabled']
		});
		var _paging = new jat.scommon.gridUtils.PagingToolbar(_userStore, 20);
		
		jat.authority.UserList.superclass.constructor.call(this,{
			sm: _sm,
			cm: _cm,
			tbar: new Ext.Toolbar({
				items: [{}]
			}),
			bbar: _paging
		});
		
		_userStore.load({
			params: {
				start: 0,
				limit: 20
			}
		})
	}
})