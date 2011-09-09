Ext.namespace("jat.authority.resourceList");
/**
 * @author sux
 * @date 2011-09-03
 * @desc 用户信息面板
 */

jat.authority.resourceList.ResourceListPanel = Ext.extend(Ext.Panel, {
	id: 'resourceListPanelId',
	constructor: function(){
		var _resourceQueryForm = new jat.authority.resourceList.ResourceQueryForm();
		var _resourceList = new jat.authority.resourceList.ResourceList();
		jat.authority.resourceList.ResourceListPanel.superclass.constructor.call(this,{
			items: [_resourceQueryForm,_resourceList]
		});
	}
});

jat.authority.resourceList.ResourceQueryForm = Ext.extend(Ext.form.FormPanel, {
	id: 'resourceQueryFormId',
	height: 30,
	constructor: function(){
		jat.authority.resourceList.ResourceQueryForm.superclass.constructor.call(this,{
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
					fieldLabel: '名称'
				}]
			},{
				layout: 'form',
				items: [{
					xtype: 'textfield',
					fieldLabel: '请求URL',
					width: 100
				}]
			},{
				layout: 'form',
				items: [{
					xtype: 'textfield',
					fieldLabel: '是否禁用',
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

jat.authority.resourceList.ResourceList = Ext.extend(Ext.grid.GridPanel,{
	id: 'resourceListId',
	constructor: function(){
		var _sm = new Ext.grid.CheckboxSelectionModel();
		var _num = new Ext.grid.RowNumberer();
		var _cm = new Ext.grid.ColumnModel([
				_num, _sm,{
					header: '名称',
					dataIndex: 'name',
					align: 'center'
				},{
					header: '请求URL',
					dataIndex: 'url',
					align: 'center'
				},{
					header: '是否禁用',
					dataIndex: 'enabled',
					align: 'center',
					renderer: function(value){
						if(value == 1){ return "是";}
						else{return "否";}
					}
				},{
					header: '描述',
					dataIndex: 'describle',
					align: 'center'
				}
			]);
		var _store = new Ext.data.JsonStore({
			url: 'users_list.action',
			root: 'root',
			totalProperty: 'totalProperty',
			fields: ['name', 'url', 'describle', 'enabled']
		});
		var _tbar = new Ext.Toolbar({
			items: [{}]
		});
		var _paging = new jat.scommon.gridUtils.PagingToolbar("resourceListPage", _store, 20);
		
		jat.authority.resourceList.ResourceList.superclass.constructor.call(this,{
			viewConfig : {
				forceFit : true
			},
			stripeRows : true,
			//随浏览器大小变动的自适应代码
			monitorResize: true, 
			doLayout: function() { 
				this.setWidth(document.body.clientWidth-205);
				this.setHeight(document.body.clientHeight-190);
				Ext.grid.GridPanel.prototype.doLayout.call(this); 
			},
			sm: _sm,
			cm: _cm,
			store: _store,
			tbar: _tbar,
			bbar: _paging
		});
		
		_store.load({
			params: {
				start: 0,
				limit: 20
			}
		});
	}
});