Ext.namespace("jat.main");
/**
 * @author sux
 * @date 2011-09-02
 * @desc main page
 */
 
 jat.main.MainPage = Ext.extend(Ext.Viewport,{
 	/**
 	 * 构造方法中进行整体布局
 	 */
 	constructor: function(username){
 		jat.main.MainPage.superclass.constructor.call(this,{
 			layout: 'border',
 			items: [{
 				region: 'north',
 				frame: true,
 				xtype: 'panel',
 				bodyStyle: 'height: 60px;',
 				layout: 'absolute',
 				html: '',
 				collapsible: true,
 				titleCollapse: true
 			},{
 				region: 'west',
 				frame: 'true',
 				width: '200',
 				xtype: 'panel',
 				title: 'JAT系统',
 				split: true,
 				collapsible: true,
 				items: [{
 					xtype: 'treepanel',
 					title: '',
 					autoScroll: true,
 					border: false,
 					id: 'tree',
 					rootVisible:false,//隐藏根节点
 					tools: [{
 						id: 'refresh',
 						handler: '',
 						scope: this
 					}],
 					loader: new Ext.tree.TreeLoader({
 						dataUrl: 'menu_load.action'
 					}),
 					//每加入进来的节点，若为非叶子节点则做为根节点继续进行查找
 					root: new Ext.tree.AsyncTreeNode({
 						text: 'JAT系统',
 						expanded :true,
 						id: '1' //加载数据时每次以变量node传入id的值如: node=1
 						//leaf: false //数据库中存储的为1/0
 					}),
 					listeners: {
 						'click': {
 							fn: this.clickNode,
 							scope: this
 						}
 					}
 				}]
 			},this.center]
 		});
 	},
 	
 	center: new Ext.TabPanel({
 		id: 'mainTab',
 		frame: true,
 		region: 'center',
 		activeTab: 0,
 		autoScroll: true,
 		split: true,
 		//TabCloseMenu一个显示右键菜单的插件
 		plugins: new Ext.ux.TabCloseMenu(),
 		items: [{
 			closable: true,
 			title: '首页',
 			iconCls: 'main'
 		}]
 	}),
 	
 	/**
 	 * 在中间区域添加新的面板
 	 */
 	 addTab : function(nodeId, nodeUrl, nodeText, nodeIcon){
 	 	var tabId = 'tab_'+nodeId; //tabId为新建面板的id
 	 	var tabTitle = nodeText;
 	 	var tabUrl = nodeUrl;
 	 	var centerPanel = Ext.getCmp('mainTab');
 	 	var tab = centerPanel.getComponent(tabId);
 	 	//如果已存在此面板则只需要激活便可
 	 	if(!tab){
 	 	var newTab = centerPanel.add(
 	 		new Ext.Panel({
 	 			//bodyStyle: 'background-color:#dfe8f6;',
 	 			frame: true,
 	 			title: tabTitle,
 	 			iconCls: nodeIcon,
 	 			id: tabId,
 	 			closable: true
// 	 			listeners: {//监听激活事件设置页面大小
// 	 				active: this.activeTabSize,
// 	 				scope: this
// 	 			}
 	 		})
 	 	);
 	 	//激活新面板
 	 	centerPanel.setActiveTab(newTab); 
 	 	//加载页面数据
 	 	newTab.load({
 	 		url: tabUrl,
 	 		method: 'post',
 	 		scope: this,
 	 		nocache : true, // 不缓存
 	 		timeout: 3000,
 	 		scripts : true //设置允许加载的页面执行js,很重要
 	 	});   
 	 	}else{
 	 		centerPanel.setActiveTab(tab);
 	 	};
 	 	//this.juage(nodeId);
 	 },
 	
 	/**
 	 * 树结点的单击事件
 	 * 若为叶子节点则弹出一个窗口
 	 */
 	 clickNode : function(node, e){
 	 	if(node.attributes.leaf){
 	 		var nodeId = node.attributes.id;
 	 		var nodeUrl = node.attributes.url;
 	 		var nodeText = node.attributes.text;
 	 		var nodeIcon = node.attributes.icon;
 	 		this.addTab(nodeId, nodeUrl, nodeText, nodeIcon);
 	 	};
 	 }

 	 /**
 	  * 激活页面时设置页面大小
 	  */
// 	  activeTabSize : function(){
// 		 console.log('jin ru');
// 	  		var w = Ext.getCmp('mainTab').getActiveTab().getInnerWidth();
// 	  		var h = Ext.getCmp('mainTab').getActiveTab().getInnerHeight();
// 	  		var activeTabId = Ext.getCmp('mainTab').getActiveTab().id;
// 	  		var activeTab = Ext.getCmp('activeTabId');
// 	  		if(activeTab){
// 	  			activeTab.setHeight(h);
// 	  			activeTab.setWidth(w);
// 	  		}
// 	  }
 });
 
