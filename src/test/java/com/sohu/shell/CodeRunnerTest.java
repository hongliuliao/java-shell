/**
 * 
 */
package com.sohu.shell;

import org.junit.Test;

/**
 * @author hongliuliao
 *
 * createTime:2012-12-28 ионГ10:56:58
 */
public class CodeRunnerTest {

	CodeRunner runner = new CodeRunner();
	
	@Test
	public void testRun() {
		runner.run(ClassLoader.getSystemResource("TestClass.class").getPath(), "TestClass");
	}
	
	@Test
	public void testCompileByFileName() {
		this.runner.compile("TestClass.java");
	}
}
