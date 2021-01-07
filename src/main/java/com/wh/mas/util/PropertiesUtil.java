package com.wh.mas.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

public final class PropertiesUtil {

	private static final Logger LOGGER = Logger.getLogger(PropertiesUtil.class);

	/** 资源属性 */
	private static Properties properties;

	/**
	 * 私有构造方法
	 */
	private PropertiesUtil() {
	}

	static {
		properties = new Properties();
		try {
			// 读取配置文件
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("param.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.error("读取配置文件出错，请确认properties文件已经放在目录下。");
		}
	}

	/**
	 * 获取配置信息
	 * 
	 * @param key 键
	 * @return 配置信息
	 */
	public static String getValue(String key) {
		String value = properties.getProperty(key);
		if (StringUtils.isNotBlank(value)) {
			LOGGER.warn("没有获取指定key的值，请确认资源文件中是否存在【" + key + "】");
		}
		return value;
	}

	/**
	 * 获取配置信息
	 * 
	 * @param key 键
	 * @param param 参数
	 * @return 配置信息
	 */
	public static String getValue(String key, Object[] param) {
		String value = getValue(key);
		return MessageFormat.format(value, param);
	}

}
