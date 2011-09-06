////统一的对loadexception的错误处理，主要针对grid
//if (Ext.data.Store) {
//	var _constructorFn = Ext.data.Store.prototype.constructor;
//	Ext.data.Store.prototype.constructor = function(A) {
//		_constructorFn.call(this, A);
//		if (!this.hasListener('loadexception')) {
//			this.on('loadexception', showExtLoadException);
//		}
//	}
//}
//
////统一的对loadexception的错误处理，主要针对tree
//if (Ext.tree.TreeLoader) {
//	var _constructorL = Ext.tree.TreeLoader.prototype.constructor;
//	Ext.tree.TreeLoader.prototype.constructor = function(A) {
//		_constructorL.call(this, A);
//		if (!this.hasListener('loadexception')) {
//			this.on('loadexception', showExtLoadException);
//		}
//	}
//}
//
////对应的处理函数
//
//var debug = false;
//
//function showExtLoadException(This, options, response, error) {
//	console.log('ok');
//	if (debug) {
//		if (error) {
//			top.Ext.Msg.alert("错误", "解析数据时发生错误:" + error.message);
//			return;
//		}
//	}
//
//	var status = response.status;
//	var text = response.responseText;
//
//	switch (status) {
//	case 404:
//		top.Ext.MessageBox.alert("错误", "加载数据时发生错误:请求url不可用");
//		break;
//	case 200:
//		if (text.length > 0) {
//			var data = Ext.decode(text);
//			if (data && data.error) {
//				top.Ext.MessageBox.alert("错误", "加载数据时发生错误:<br/>" + data.error);
//			} else {
//				top.Ext.MessageBox.alert("错误", "加载数据时发生错误:<br/>" + text);
//			}
//		}
//		break;
//	case 0:
//		top.Ext.MessageBox.alert("错误", "加载数据时发生错误:<br/>" + "远程服务器无响应");
//		break;
//	default:
//		var data = Ext.decode(text);
//		if (data && data.error) {
//			top.Ext.MessageBox.alert("错误", "加载数据时发生错误<br/>错误码:" + status
//					+ "<br/>错误信息:" + data.error);
//		} else {
//			top.Ext.MessageBox.alert("错误", "加载数据时发生错误<br/>错误码:" + status
//					+ "<br/>错误信息:" + text);
//		}
//
//		break;
//	}
//
//}
//
//Ext.Ajax.handleFailure = Ext.Ajax.handleFailure.createInterceptor(function(response) {
//var r = response.responseText;
//cosole.log(r);
//})

/**
 * 请求完成后根据返回信息处理异常
 * 还可对requestexception根据返回的状态进行处理
 * 注意：在菜单中点击节点时进行了ajax查询，返回的并不是json数据而是请求的jsp页面，这就导致每次
 * 点击菜单时出问题。当传入的json格式不正确将报错，故进行异常捕获。
 * @param {Object} conn
 * @param {Object} response
 * @param {Object} options
 */
Ext.Ajax.on('requestcomplete',function(conn, response, options){
	//console.log(response.responseText);
	var data;
	try{
		data = Ext.util.JSON.decode(response.responseText); //转为js对象
	}catch(e){
		console.log(e.message);
	}
	if(null != data && data.exception == true){
		Ext.Msg.alert("系统异常",data.msg);
	}
}, this);