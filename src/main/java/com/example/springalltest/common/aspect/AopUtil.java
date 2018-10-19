package com.example.springalltest.common.aspect;

import com.example.springalltest.common.util.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Pattern;


/**
 * 
 * AOP工具类
 */
public class AopUtil {
	public static final String ADD = "添加";
	public static final String UPDATE = "修改";
	public static final String DELETE = "删除";
	public static final String IMPORT = "导入";
	public static final String BATCH = "批量增加";
	public static final String QUERY = "查询";
	public static final String OTHER = "未知";
	public static final String SUCCESS = "成功";
	public static final String FAIL = "失败";
	public static final String DEFALUT_NAME = "名称";
	private static final String ADD_REGX = "(add|append)[\\S]*";
	private static final String UPDATE_REGX = "(update|modify|edit)[\\S]*";
	private static final String DELETE_REGX = "(delete|del|remove)[\\S]*";
	private static final String IMPORT_REGX = "(import)[\\S]*";
	private static final String QUERY_REGX = "(get|find|load|search|datagrid)[\\S]*";

	/**
	 * 描述 获取目标方法类型
	 * @param methodName
	 * @return
	 */
	public static String getMethodType(String methodName) {
		if (Pattern.matches(ADD_REGX, methodName)) {
			return ADD;
		}
		if (Pattern.matches(UPDATE_REGX, methodName)) {
			return UPDATE;
		}
		if (Pattern.matches(DELETE_REGX, methodName)) {
			return DELETE;
		}
		if (Pattern.matches(IMPORT_REGX, methodName)) {
			return IMPORT;
		}
		if (Pattern.matches(QUERY_REGX, methodName)) {
			return QUERY;
		}
		return OTHER;
	}

	/**
	 * 比较两个对象差异数据
	 * 
	 * @param beforeobj
	 * @param afterobj
	 * @param cols
	 * @param different
	 * @return
	 * @throws Exception
	 */
	public static List<Comparison> compareobj(Object beforeobj,
			Object afterobj, Map<String, String> cols, boolean different)
			throws Exception {
		List<Comparison> sames = new ArrayList<Comparison>();
		List<Comparison> differents = new ArrayList<Comparison>();
		if (beforeobj == null) {
			throw new Exception("beforeobj不能为空!");
		}
		if (afterobj == null) {
			throw new Exception("afterobj不能为空!");
		}
		if (!beforeobj.getClass().isAssignableFrom(afterobj.getClass())) {
			throw new Exception("两个对象不相同，无法比较");
		}
		// 去除对象所有字段
		PropertyDescriptor[] descriptors = Introspector.getBeanInfo(
				beforeobj.getClass()).getPropertyDescriptors();
		Set<String> keys = cols.keySet();
		for (String col : keys) {
			for (PropertyDescriptor descriptor : descriptors) {
				String proname = descriptor.getName();
				if (StringUtil.isNotEmpty(proname)
						&& proname.equalsIgnoreCase(col)) {
					Comparison comparison = new Comparison();
					Method readmethod = descriptor.getReadMethod();
					comparison.setBefore(readmethod.invoke(beforeobj));
					comparison.setAfter(readmethod.invoke(afterobj));
					comparison.setFieldType(descriptor.getPropertyType());
					comparison.setField(proname);
					comparison.setFieldName(cols.get(col));
					if (comparison.isdifferent()) {
						sames.add(comparison);
					} else {
						differents.add(comparison);
					}
				}
			}
		}
		if (different) {
			return differents;
		} else {
			return sames;
		}
	}

	/**
	 * 获取指定类有指定属性注解的指定注解名性的属性集合
	 * 
	 * @param clazz
	 * @param annoClass
	 *            指定注解类
	 * @param annoName
	 *            指定注解属性
	 * @return
	 */
	public static Map<String, String> getFieldsAnnoMap(
			@SuppressWarnings("rawtypes") Class clazz,
			Class<? extends Annotation> annoClass, String annoName) {
		Map<String, String> map = new HashMap<String, String>();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].isAnnotationPresent(annoClass)) {
				String name = fields[i].getName();
				String valueString = "";
				Annotation annotation = fields[i].getAnnotation(annoClass);
				Method[] annos = annoClass.getMethods();
				for (int j = 0; j < annos.length; j++) {
					if (annoName.equals(annos[j].getName())) {
						try {
							valueString = annos[j].invoke(annotation)
									.toString();
						} catch (IllegalAccessException
								| IllegalArgumentException
								| InvocationTargetException e) {
							e.printStackTrace();
						}
						break;
					}
				}
				map.put(name, valueString);
			}
		}
		return map;
	}


	/**
	 * 
	 * 描述 从vo类获取对应model类的名称 <br>
	 * 前提是要符合命名要符合规则
	 * 
	 * @param clazz
	 * @return
	 */
	public static Class<?> getModelNameByVOName(Class<?> clazz) {
		try {
			String name = clazz.getName();
			if (name.endsWith("VO")) {
				name = name.replace("VO", "");
				if (name.indexOf("vo") != -1) {
					name = name.replace("vo", "model");
				}
				return Class.forName(name);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * 描述 获取目标类名 - 不带包名
	 * 
	 * @param joinPoint
	 * @return
	 */
	public static String getClassNameByJP(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getName();
		return className.substring(className.lastIndexOf(".") + 1).trim();
	}

	/**
	 * 
	 * 描述 获取目标方法名
	 * 
	 * @param joinPoint
	 * @return
	 */
	public static String getMethodNameByJP(JoinPoint joinPoint) {
		return joinPoint.getSignature().getName();
	}

	/**
	 * 
	 * 描述 获取当前request对象
	 * 
	 * @return
	 */
	public static HttpServletRequest getContextRequest() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
	}

	/**
	 * 
	 * 描述 格式化空字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String fomartNullStr(String str) {
		if (StringUtil.isEmpty(str)) {
			return "空值";
		}
		return str;
	}
}
