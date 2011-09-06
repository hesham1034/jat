Ext.namespace("scommon");

/**
 * Form提交时的Failure处理,若后台业务处理产生异常则输出错误信息，其它则输出超时提示
 */
scommon.failure = function(form, action){
	try{
		Ext.Msg.alert('系统异常',action.result.msg);
	}catch(e){
		Ext.Msg.alert('提示','连接超时');
	}
};
/**
 * Ajax提交时Failure处理
 */
scommon.ajax.failure = function(response, options){
	var data;
	try{
		data = Ext.util.JSON.decode(response.responseText); //转为js对象
	}catch(e){
		console.log("返回的JSON格不正确："+e.message);
		Ext.Msg.alert('提示','连接超时');
	}
	if(null != data && data.exception == true){
		Ext.Msg.alert("系统异常",data.msg);
	}else{
		Ext.Msg.alert('提示','连接超时');
	}
};

/**
 * 获取项目路径
 * @return {TypeName} 
 */
scommon.basePath = function(){
	//console.log($("#basePath").val());加了jquery便可
	return document.getElementById("basePath").value;
}
/**
 * 按字节截取长度
 */
scommon.substring = function(str, len){
   if(!str || !len){return'';}
   //预期计数：中文2字节，英文1字节
   var a =0;
   //循环计数
   var i =0;
   //临时字串
   var temp ='';
   for(i=0;i<str.length;i++){
       if(str.charCodeAt(i)>255){
           //按照预期计数增加2
            a+=2;
       }else{
            a++;
       }
       //如果增加计数后长度大于限定长度，就直接返回临时字符串
       if(a > len){return temp + "...";}
       //将当前内容加到临时字符串
        temp += str.charAt(i);
   }
   //如果全部是单字节字符，就直接返回源字符串
   return str;
}  
/**
 * 获取现在的时间
 */
scommon.time = function(){
	var _now = new Date();
	var _hour = _now.getHours();
	if(_hour < 10) _hour = '0' + _hour;
	var _minute = _now.getMinutes();
	if(_minute < 10) _minute = '0' + _minute;
	var _second = _now.getSeconds();
	if(_second < 10) _second = '0' + _second;
	var _time = _hour+":"+_minute+":"+_second;
	return _time;
} 

/**
 * 关闭窗口
 * windId: 窗口id
 */
scommon.close = function(winId){
	if(typeof Ext.getCmp(winId) != "undefined"){
		Ext.getCmp(winId).destroy();
	}
}