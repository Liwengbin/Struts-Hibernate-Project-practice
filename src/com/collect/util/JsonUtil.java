package com.collect.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 处理json类型的工具类，将json转为java对象
 * @author 李文兵
 *
 */
public class JsonUtil {
	/**
	 * 从一个JSON对象字符格式中得到一个java对象 
	 @param jsonString
	 @param pojoCalss
	 @return
	 */
	public static Object getObje4JsonString(String jsonString,Class<?> pojoClass)
	{
		Object pojo;
		
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		pojo = JSONObject.toBean(jsonObject, pojoClass);
		return pojo;
	}
	
	/**
	 * 从json数据中获取java数组
	 * @param jsonString
	 * @return
	 */
	public static Object[] getObjectArray4Json(String jsonString) {
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		return jsonArray.toArray();
	}
	
	/**
	 * 从json数据中解析java字符串数组
	 * @param jsonString
	 * @return
	 */
	public static String[] getStringArray4Json(String jsonString)
	{
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		String[] stringArray = new String[jsonArray.size()];
		
		for(int i=0;i<jsonArray.size();i++)
		{
			stringArray[i] = jsonArray.getString(i);
		}
		
		return stringArray;
	}
	
	/**
	 * java对象转为json字符串
	 * @param javaObj
	 * @return
	 */
	public static String getJsonString4JavaPOJO(Object javaObj)
	{
		JSONObject json;
		json = JSONObject.fromObject(javaObj);
		return json.toString();
	}
	
/*	*//**
	 * 从json对象中得到一个java
	 *//*

	/**
	 * 从json对象中得到一个java对象数组
	 
	public static List getList4Json(String jsonString, Class<?> pojoClass)
	{
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject jsonObject;
		Object pojoValue;
		
		List list = new ArrayList();
		for(int i=0;i<jsonArray.size();i++)
		{
			jsonObject = jsonArray.getJSONObject(i);
			pojoValue = JSONObject.toBean(jsonObject, pojoClass);
			list.add(pojoValue);
		}
		return list;
	}
	
	*//**
	 * 将List对象转为json 
	 * @param list
	 * @return
	 *//*
	public static String getJsonString4List(List list)
	{
		JSONArray jsonArray;
		jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}
 * */
/*	public static void main(String[] args) {
		String testString="{\"url\":\"123456\",\"state\":\"yc\"}";
		UrlCollect url_collect=(UrlCollect)JsonUtil.getObje4JsonString(testString, UrlCollect.class);
		System.out.println(url_collect.toString());
	}*/
}
