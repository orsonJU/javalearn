package org.orson.reflect.pd;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class Main {


    public static void main(String[] args) throws Exception {
        //使用JDK自省工具获取类信息
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        //获取类的属性描述符
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor pd : pds) {
            Method readMethod = pd.getReadMethod();
            Method writeMethod = pd.getWriteMethod();
        }
    }
}
