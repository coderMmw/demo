package com.demo.utils;


import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EntityUtils {
    private static final ObjectMapper OBJECT_MAPPER=new ObjectMapper();
    public static List<Map<String,Object>> toMapList(Iterable<?> entityList,String... props){
        if(entityList!=null){
            List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
            for(Object entity:entityList){
                list.add(toMap(entity,props));
            }
            return list;
        }
        return null;
    }
    public static String toJson(Object entity){
        try {
            return OBJECT_MAPPER.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public static String toJson(Object entity,String... props){
        try {
            return OBJECT_MAPPER.writeValueAsString(toMap(entity,props));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public static Map<String,Object> toMap(Object entity,String... props){
        Set<Property> propSet=new HashSet<Property>();
        for(String prop:props){
            fillPropSet(propSet,prop);
        }
        return toMap(entity,propSet);
    }
    public static void fillMap(Map<String,Object> map,Object entity,String... props){
        Set<Property> propSet=new HashSet<Property>();
        for(String prop:props){
            fillPropSet(propSet,prop);
        }
        map.putAll(toMap(entity,propSet));
    }
    private static void fillPropSet(Set<Property> propSet,String prop){
        int pos=prop.indexOf('.');
        if(pos==-1){
            propSet.add(new Property(prop));
        }else{
            String parentProp=prop.substring(0, pos);
            Set<Property> subPropSet=null;
            for(Property p:propSet){
                //已存在中间属性
                if(p.getName().equals(parentProp)){
                    subPropSet=p.getSubProps();
                    break;
                }
            }

            //新的中间属性
            if(subPropSet==null){
                subPropSet=new HashSet<Property>();
                propSet.add(new Property(parentProp,subPropSet));
            }


            //填充子属性
            fillPropSet(subPropSet,prop.substring(pos+1));

        }

    }
    public static Map<String,Object> toMap(Object entity,Set<Property> props){
        Map<String,Object> map=new HashMap<String,Object>();
        for(Property p : props){
            try {
                PropertyDescriptor pd=new PropertyDescriptor(p.getName(),entity.getClass());
                Object propValue=pd.getReadMethod().invoke(entity);
                if(!p.hasSubProps() || propValue==null){
                    map.put(p.getName(),propValue);
                }else{
                    map.put(p.getName(), toMap(propValue,p.getSubProps()));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("invalid props",e);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("invalid props",e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException("invalid props",e);
            } catch (IntrospectionException e) {
                throw new RuntimeException("invalid props",e);
            }
        }
        return map;
    }


}

class Property{
    private String name=null;
    private Set<Property> subProps=null;

    public Property(String name, Set<Property> subProps) {
        super();
        this.name = name;
        this.subProps = subProps;
    }
    public Property(String name) {
        super();
        this.name = name;
    }
    public boolean hasSubProps(){
        return this.subProps!=null;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Property> getSubProps() {
        return subProps;
    }
    public void setSubProps(Set<Property> subProps) {
        this.subProps = subProps;
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }


}

