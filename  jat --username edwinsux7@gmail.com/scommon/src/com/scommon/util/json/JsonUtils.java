package com.scommon.util.json;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.PropertyFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.scommon.emnus.CommonStaticValues;

public class JsonUtils {
	Log log = LogFactory.getLog(JsonUtils.class);
	
	/**
	 * filter property and return json string
	 * @param obj  entity
	 * @param props
	 * @return json
	 */
	public static String getJsonAndFilterPropertys(Object obj, Set<String> props){
		JSONObject json = null;
		try{
		JsonConfig jsonConfig = new JsonConfig();
		setJsonFilter(jsonConfig, props);
		json = JSONObject.fromObject(obj, jsonConfig);}catch(Exception e){e.printStackTrace();}
		return json.toString();
	}
	
	/**
	 * convert date format and return json string
	 * @param obj
	 * @param props
	 * @param dateFormat
	 * @return
	 */
	public static <T> String getJsonAndConvertDateFormats(Object obj, Set<String> props, Class<T> typeClazz, String dateFormat){
		JsonConfig jsonConfig = new JsonConfig();
		new JsonUtils().setConvertDateFormat(jsonConfig, props, typeClazz, dateFormat);
		JSONObject json = JSONObject.fromObject(obj, jsonConfig);
		return json.toString();
	}
	
	/**
	 * convert date format,filter property and return json string
	 * @param <T>
	 * @param obj
	 * @param cProps
	 * @param typeClazz
	 * @param dateFormat
	 * @param fProps
	 * @return
	 */
	public static <T> String getJsonAndConvertFilter(Object obj, Set<String> cProps, Class<T> typeClazz, String dateFormat, Set<String> fProps){
		JsonConfig jsonConfig = new JsonConfig();
		new JsonUtils().setConvertDateFormat(jsonConfig, cProps, typeClazz, dateFormat);
		setJsonFilter(jsonConfig, fProps);
		JSONObject json = JSONObject.fromObject(obj, jsonConfig);
		return json.toString();
	}
	
	
	/***********************config jsonConfig*********************************/
	/**
	 * config jsonConfig to filter property
	 * @param jsonConfig
	 * @param props  need filter property collection
	 */
	public static void setJsonFilter(JsonConfig jsonConfig, final Set<String> props){
		if(props.size() != 0 && null != props){
			PropertyFilter filter = new PropertyFilter(){
				@Override
				public boolean apply(Object source, String name, Object value) {
					return props.contains(name);
				}
			};
			jsonConfig.setJsonPropertyFilter(filter);
		}
	}
	
	/**
	 * config jsonConfig to convert date format
	 * @param jsonConfig
	 * @param props   need change property collection
	 * @param dateFormat  date format
	 * @param typeClazz  property's type
	 */
	public <T> void setConvertDateFormat(JsonConfig jsonConfig, final Set<String> props, 
			final Class<T> typeClazz, final String dateFormat){
		jsonConfig.registerJsonValueProcessor(typeClazz, new JsonValueProcessorImpl(){
			@SuppressWarnings("deprecation")
			@Override
			public Object process(String key, Object value) {
				SimpleDateFormat sdf = null;
				if(props.contains(key)){ //contain key property
					try{
						sdf = new SimpleDateFormat(dateFormat);
					}catch(Exception e){
						sdf = new SimpleDateFormat(CommonStaticValues.SYS_DATE_FORMAT);
					}
					try {
						if(typeClazz.equals(Date.class)){//Date type
							return sdf.format(value);
						}else if(typeClazz.equals(Long.class)){// Long type
							return sdf.format(new Date((Long) value));
						}else if(typeClazz.equals(String.class)){ // String type
							return sdf.format(new Date((String) value));
						}
					} catch (Exception e) {
						log.error(JsonUtils.class + ": convert date format is error of convertDateFormat method.");
					}
				}
				return value;
			}
		});
	}
	
	/**
	 * Inner class, implements JsonValueProcessor
	 * @author Administrator
	 *
	 */
	abstract class JsonValueProcessorImpl implements JsonValueProcessor{

		@Override
		public Object processArrayValue(Object arg0, JsonConfig arg1) {
			return null;
		}

		@Override
		public Object processObjectValue(String key, Object value,
				JsonConfig jsonConfig) {
			return process(key, value);
		}
		public abstract Object process(String key, Object value); 
	}
	
	public static void main(String[] args){
//		Post post = new Post();
//		post.setId(111L);
//		post.setContent("aaaa");
//		post.setIpAddr("bbbb");
//		post.setTitle("ccc");
//		post.setPostTime(new Date());
//		Set<String> set = new HashSet<String>();
//		set.add("postTime");
//		//System.out.println(new JsonUtils().getJsonAndConvertDateFormats(post, set, Date.class, null));
//		//System.out.println(new JsonUtils().getJsonAndFilterPropertys(post, set));
//		Set<String> set2 = new HashSet<String>();
//		set2.add("title");
//		set2.add("content");
//		System.out.println(new JsonUtils().getJsonAndConvertFilter(post, set, Date.class, null, set2));
	}
}
