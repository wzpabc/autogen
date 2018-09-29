package com.tupperware.auto.commons.utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;  
  
/**  
 * Created by phshy on 2017/1/19.  
 */  
public class JSONUtils {    
    private static final ObjectMapper mapper = new ObjectMapper();  
  
    private JSONUtils() {  
    }  
  
    public static Map<String, Object> json2Map(String json) throws IOException {  
        Map map = (Map) mapper.readValue(json, Map.class);  
        return map;  
    }  
  
    public static String object2Json(Object object) throws IOException {  
        return mapper.writeValueAsString(object);  
    }  
  
    public static <T> T json2Object(String json, Class<T> clazz) throws IOException {  
        return mapper.readValue(json, clazz);  
    }  
  
    public static List<?> json2List(String json, TypeReference<?> typeRef) throws IOException {  
        List list = (List) mapper.readValue(json, typeRef);  
        return list;  
    }  
       
//    public static void main(String[] args) throws IOException {  
//        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();  
//          
//        Map<String,Object> dataMap = new HashMap<String,Object>();  
//        dataMap.put("tag", "data");  
//        dataMap.put("hospitalName", "宜都市妇幼保健院");  
//        dataMap.put("name", "欧阳夏凡");  
//        dataMap.put("gender", "女");  
//        dataMap.put("age", "28");  
//        dataMap.put("code", "420502042");  
//        dataMap.put("examineDoc", "杨林");  
//        dataMap.put("examineDate", "2016-05-10");  
//        dataMap.put("verifyDoc", "王菲");  
//          
//  
//        Map<String,Object> dataMap2 = new HashMap<String,Object>();  
//        dataMap2.put("no", "340812");  
//        dataMap2.put("name", "古夕旸");  
//           
////        
//        String jsonString=JSON.toJSONString(dataMap);  
//        list.add(dataMap);  
//        list.add(dataMap2);  
////      String jsonString2=mapper.writeValueAsString(list);  
//        String jsonString2=JSON.toJSONString(list);  
//        System.out.println(jsonString2);  
//          
//          
//        List<Map<String,Object>> json2List = (List<Map<String, Object>>) json2List(jsonString2,new TypeReference<List<Map<String,Object>>>(){});  
//        for (Map<String,Object> s:json2List) {  
//            System.out.println(s.get("name"));  
//        }  
//          
//          
//    }  
}  