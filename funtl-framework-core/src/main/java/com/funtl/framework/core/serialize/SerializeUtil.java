package com.funtl.framework.core.serialize;

import net.sf.ehcache.CacheException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化工具
 * Created by 李卫民 on 2016/7/19.
 */
public class SerializeUtil {
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			final byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (final Exception e) {
			throw new CacheException(e);
		}
	}

	public static Object unserialize(byte[] bytes) {
		if (bytes == null) {
			return null;
		}
		ByteArrayInputStream bais = null;
		try {
			bais = new ByteArrayInputStream(bytes);
			final ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (final Exception e) {
			throw new CacheException(e);
		}
	}
}
