Ext.namespace("jat.scommon.gridUtils");
/**
 * 删除表格中选中的内容
 * @param {Object} panelId 表单面板的Id
 * @param {Object} delId   数据库的删除时依据的属性
 * @param {Object} url  提交的URL
 * @return {TypeName} 
 */

function gridDel(panelId, delId, url){
	var oSelMode = Ext.getCmp(panelId).getSelectionModel();
	var oRecords = oSelMode.getSelections();
	var ids = "";
	for(var i=0;i<oRecords.length;i++){
		ids += oRecords[i].get(delId);
		if(i != oRecords.length-1) ids += ",";
	};
if(ids != null && ids != ""){
		Ext.Msg.confirm("提示","确定删除",function(button, text){
			if(button == "yes"){
				Ext.Ajax.request({
				url: url,
				success: function(response, options){
							var datas = Ext.util.JSON.decode(response.responseText);
							Ext.Msg.alert("提示", datas.msg, function(){
								Ext.getCmp(panelId).getStore().reload();
							})
						},
				failure: function(response, options){
							Ext.Msg.alert("提示", '连接失败', function(){})
						},
				params: {
					ids: ids
				}
				});
			}
		});
	}else{
		Ext.Msg.alert("提示","请先选择",function(){});
	}
};
/**
 * 分页栏类
 * @param {Object} store 表格存储store
 * @param {Object} pageSize 页面大小
 * @memberOf {TypeName} 
 */
jat.scommon.gridUtils.PagingToolbar = Ext.extend(Ext.PagingToolbar, {
	constructor: function(_id, _store, _pageSize){
		jat.scommon.gridUtils.PagingToolbar.superclass.constructor.call(this, {
			id: _id,
			store: _store,
			pageSize: _pageSize, //页面大小 
			displayInfo: true,
			displayMsg : '共<font color="red"> {2} </font>条记录,当前页记录索引<font color="red"> {0} - {1}</font>&nbsp;&nbsp;&nbsp;',
			emptyMsg: '没有数据',
			refreshText: '刷新',
			firstText: '第一页',
			prevText: '前一页',
			nextText: '下一页',
			lastText: '最后一页'
		});
	}
});

/**
 * 信息提示功能
 * _value: 字符串
 * _len: 显示的长度
 */
jat.scommon.gridUtils.QTip = function(_value, _len){
	return "<span ext:qtip=" + _value + ">" + scommon.substring(_value, _len) + "</span>";
};
