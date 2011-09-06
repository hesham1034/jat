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
		});
	}
});

jat.authority.UserQueryForm = Ext.extend(Ext.form.FormPanel, {
	id: 'userQueryFormId',
	height: 30,
	constructor: function(){
		jat.authority.UserQueryForm.superclass.constructor.call(this,{
			layout: 'table',
			layoutConfig: {
				columns: 4
			},
			defaults: {
				labelWidth: '60',
				labelAlign: 'right'
			},
			items: [{
				layout: 'form',
				items: [{
					xtype: 'textfield',
					fieldLabel: '用户名',
					width: 100
				}]
			},{
				layout: 'form',
				items: [{
					xtype: 'textfield',
					fieldLabel: '角色名',
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

jat.authority.UserList = Ext.extend(Ext.grid.GridPanel,{
	id: 'userListId',
	height: 500,
	constructor: function(){
		var _sm = new Ext.grid.CheckboxSelectionModel();
		var _num = new Ext.grid.RowNumberer();
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
					header: '职位',
					dataIndex: 'position',
					align: 'center'
				},{
					header: '是否禁用',
					dataIndex: 'enabled',
					align: 'center',
					renderer: function(value){
						if(value == 1){ return "是";}
						else{return "否";}
					}
				}
			]);
		var _userStore = new Ext.data.JsonStore({
			url: 'users_list.action',
			root: 'root',
			totalProperty: 'totalProperty',
			fields: ['username', {name: 'role', convert: function(v){return v.name;}}, 'position', 'enabled']
		});
		var _tbar = new Ext.Toolbar({
			items: [{}]
		});
		var _paging = new jat.scommon.gridUtils.PagingToolbar("userListPage", _userStore, 20);
		
		jat.authority.UserList.superclass.constructor.call(this,{
			//随浏览器大小变动的自适应代码
			monitorResize: true, 
			doLayout: function() { 
				this.setWidth(document.body.clientWidth-205);
				this.setHeight(document.body.clientHeight-190);
				Ext.grid.GridPanel.prototype.doLayout.call(this); 
			},
			sm: _sm,
			cm: _cm,
			store: _userStore,
			tbar: _tbar,
			bbar: _paging
		});
		
		_userStore.load({
			params: {
				start: 0,
				limit: 20
			}
		});
	}
});