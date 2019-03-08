//package com.redis;
// 
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
// 
//public class SerializeUtil {
//	/**
//	 *
//	 * 序列化
//	 */
//	public static byte[] serialize(Object obj) {
// 
//		ObjectOutputStream oos = null;
//		ByteArrayOutputStream baos = null;
// 
//		try {
//			baos = new ByteArrayOutputStream();
//			oos = new ObjectOutputStream(baos);
// 
//			oos.writeObject(obj);
//			byte[] byteArray = baos.toByteArray();
//			return byteArray;
// 
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
// 
//	/**
//	 *
//	 * 反序列化
//	 *
//	 * @param bytes
//	 * @return
//	 */
//	public static Object unSerialize(byte[] bytes) {
// 
//		ByteArrayInputStream bais = null;
// 
//		try {
//			bais = new ByteArrayInputStream(bytes);
//			ObjectInputStream ois = new ObjectInputStream(bais);
//			return ois.readObject();
// 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//}
