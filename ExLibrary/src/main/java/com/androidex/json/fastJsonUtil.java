package com.androidex.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Tom  <br>
 */
public class FastJsonUtil {

    /**
     * 将Json字符串解析成对应的Java对象
     *
     * @param jsonStr 需要解析的Json字符串
     * @param mClass  需要解析成的Java对象类型
     * @return 解析后的Java对象实例
     */
    public static <T> T fastJsonToObject(String jsonStr, Class<T> mClass) {
        T mt = JSON.parseObject(jsonStr, mClass);
        return mt;
    }

    /**
     * 将Json字符串解析成对应的ArrayList<T>集合
     *
     * @param jsonStr 需要解析的Json字符串
     * @param mClass   需要解析成的Java对象类型
     * @return mlList 解析后的ArrayList<T>集合
     */
    public static <T> ArrayList<T> fastJsonToListObjectOrString(String jsonStr, Class<T> mClass) {
        ArrayList<T> mList = (ArrayList<T>) JSON.parseArray(jsonStr, mClass);
        return mList;
    }

    /**
     * 将Json字符串解析成对应的ArrayList<Map<String,T>>集合
     *
     * @param jsonStr 需要解析的Json字符串
     * @param mTypeReference   需要解析成的Java对象类型
     * @return mapsList 解析后的ArrayList<Map<String,T>>集合
     */
    public static <T> ArrayList<Map<String, T>> fastJsonGetListMapObject(String jsonStr, TypeReference<T> mTypeReference) {
        ArrayList<Map<String, T>> mapsList = (ArrayList<Map<String, T>>) JSON.parseObject(jsonStr, mTypeReference);
        return mapsList;
    }

    /**
     * 获取需要转换的List<Map<String,T>>类型
     *
     * @param mClass
     * @return mType
     */
    public static <T> TypeReference fastJsonGetetListMapTypeReference(Class<T> mClass) {
        TypeReference mTypeReference = null;
//        if (mClass == Person.class) {
//            mTypeReference = new TypeReference<ArrayList<Map<String, Person>>>() {
//            };
//        } else if (mClass == String.class) {
//            mTypeReference = new TypeReference<ArrayList<Map<String, String>>>() {
//            };
//        }
        return mTypeReference;
    }


}
