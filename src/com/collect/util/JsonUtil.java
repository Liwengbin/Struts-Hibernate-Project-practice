package com.collect.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ����json���͵Ĺ����࣬��jsonתΪjava����
 * @author ���ı�
 *
 */
public class JsonUtil {
	/**
	 * ��һ��JSON�����ַ���ʽ�еõ�һ��java���� 
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
	 * ��json�����л�ȡjava����
	 * @param jsonString
	 * @return
	 */
	public static Object[] getObjectArray4Json(String jsonString) {
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		return jsonArray.toArray();
	}
	
	/**
	 * ��json�����н���java�ַ�������
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
	 * java����תΪjson�ַ���
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
	 * ��json�����еõ�һ��java
	 *//*

	/**
	 * ��json�����еõ�һ��java��������
	 
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
	 * ��List����תΪjson 
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
