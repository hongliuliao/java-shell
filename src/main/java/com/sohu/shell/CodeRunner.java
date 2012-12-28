/**
 * 
 */
package com.sohu.shell;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * @author hongliuliao
 *
 * createTime:2012-12-28 上午10:31:55
 */
public class CodeRunner {
	
	public boolean compile(String buildFilePath, String javaCode) {
		return this.compile(this.buildFile(buildFilePath, javaCode));
	}
	
	public boolean compile(String javaFilePath) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, javaFilePath);
		return result == 0;
	}
	
	public void loadClassAndRun(String filePath, String className) {
		try {
			Class<?> runClass = loadClass(className, readFileToBytes(filePath));
			Method mainMethod = runClass.getDeclaredMethod("main", String[].class);
			Object arg = new String[] {};
			mainMethod.invoke(null, arg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private byte[] readFileToBytes(String filePath) {
		try {
			RandomAccessFile f = new RandomAccessFile(filePath, "r");
			byte[] b = new byte[(int)f.length()];
			f.read(b);
			return b;
		} catch (Exception e) {
			throw new RuntimeException("readFileToBytes error!", e);
		}
		
	}
	
	public Class<?> loadClass(String classFileName, byte[] code){
		try {
			Class<?> clazz = Class.forName("java.lang.ClassLoader");
			Method m = clazz.getDeclaredMethod("defineClass", byte[].class, int.class, int.class);
			m.setAccessible(true);
			ClassLoader loader = this.getClass().getClassLoader();
			m.invoke(loader, code, 0, code.length);
			Class<?> newClass = Class.forName(classFileName);
			return newClass;
		} catch (Exception e) {
			throw new RuntimeException("getClass error",e);
		}
	}
	
	public String buildFile(String path, String javaCode) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(new File(path)));
			writer.write(javaCode);
			writer.flush();
			return path;
		} catch (Exception e) {
			throw new RuntimeException("build java file error!", e);
		} finally {
			try {
				if(writer != null) {
					writer.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
