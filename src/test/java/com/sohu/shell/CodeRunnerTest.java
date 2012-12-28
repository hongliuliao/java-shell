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
	
	CodeGenerator codeGenerator = new CodeGenerator();
	
	CodeContainer codeContainer = new CodeContainer();
	
	@Test
	public void testCompile() {
		codeContainer.addCode("System.out.println(\"haha\");");
		codeContainer.setClassName("Test");
		String javaCode = codeGenerator.generator(codeContainer);
		String basePath = CodeRunnerTest.class.getClassLoader().getResource("").getPath();
		runner.compile(basePath + "Test.java", javaCode);
	}
	
}
