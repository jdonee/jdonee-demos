package com.jdonee.cooking.jsons;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.jdonee.cooking.User;
import com.jdonee.cooking.utils.Monitoring;

/**
 * 使用最新的fastjson和jackson比较处理速度
 * 
 * @author ZengAihui
 * 
 */
public class JsonComparator {

	private static ObjectMapper jsonMapper = new ObjectMapper();

	public static void main(String[] args) throws JsonProcessingException {
		clacTime(1000);
		clacTime(5000);
		clacTime(10000);
		clacTime(15000);
		clacTime(20000);
		clacTime(50000);
		clacTime(100000);
		clacTime(500000);
		clacTime(1000000);
		clacTime(2000000);
		clacTime(5000000);
	}

	/**
	 * 计算耗时
	 * 
	 * @param clacSize
	 * @throws JsonProcessingException
	 */
	public static void clacTime(int clacSize) throws JsonProcessingException {
		Monitoring.begin();
		List<User> list = Lists.newArrayList();
		for (int i = 0; i < clacSize; i++) {
			list.add(fullObject(User.class));
		}
		Monitoring.end("生成" + clacSize + "条数据耗时:");

		Monitoring.begin();
		jackson(list);
		Monitoring.end("Jackson");

		Monitoring.begin();
		fastjson(list);
		Monitoring.end("fastjson");
	}

	public static void fastjson(List<User> list) {
		for (User User : list) {
			JSON.toJSONString(User);
		}
	}

	public static void jackson(List<User> list) throws JsonProcessingException {
		// 设置输出时包含属性的风格
		// jsonMapper.setSerializationInclusion(Include.NON_DEFAULT);
		// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		// jsonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		for (User User : list) {
			jsonMapper.writeValueAsString(User);
		}
	}

	/**
	 * 填充一个对象（一般用于测试）
	 */
	public static <T> T fullObject(Class<T> cl) {
		T t = null;
		try {
			t = cl.newInstance();
			Method methods[] = cl.getMethods();
			for (Method method : methods) {
				// 如果是set方法,进行随机数据的填充
				if (method.getName().indexOf("set") == 0) {
					Class param = method.getParameterTypes()[0];
					if (param.equals(String.class)) {
						method.invoke(t, "jdonee" + new Random().nextInt(5));
					} else if (param.equals(Short.class)) {
						method.invoke(t, (short) new Random().nextInt(5));
					} else if (param.equals(Float.class)) {
						method.invoke(t, new Random().nextFloat());
					} else if (param.equals(Double.class)) {
						method.invoke(t, new Random().nextDouble());
					} else if (param.equals(Integer.class)) {
						method.invoke(t, new Random().nextInt(10));
					} else if (param.equals(Long.class)) {
						method.invoke(t, new Random().nextLong());
					} else if (param.equals(Date.class)) {
						method.invoke(t, new Date());
					}
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return t;
	}
}
