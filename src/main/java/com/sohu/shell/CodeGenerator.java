/**
 * 
 */
package com.sohu.shell;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author hongliuliao
 *
 * createTime:2012-12-28 上午10:02:38
 */
public class CodeGenerator {

	public static String CODE_TEMPLATE = "";
	
	static {
		loadTemplateFromFile();
	}
	
	/**
	 * generator java code from codeContainer
	 * @param codeContainer
	 * @return the java code
	 */
	public String generator(CodeContainer codeContainer) {
		String importCodeLines = "";
		if(codeContainer.getImportCodes() != null) {
			importCodeLines = this.generatorCodeString(codeContainer.getImportCodes());
		}
		String mainCodeLines = "";
		if(codeContainer.getCodes() != null) {
			mainCodeLines = this.generatorCodeString(codeContainer.getCodes());
		}
		String resultCode = CODE_TEMPLATE.replace("${IMPORT_CODES}", importCodeLines);
		resultCode = resultCode.replace("${CODES_IN_MAIN}", mainCodeLines);
		resultCode = resultCode.replace("${CLASS_NAME}", codeContainer.getClassName());
		return resultCode;
	}
	
	private String generatorCodeString(List<String> codes) {
		StringBuffer codeLines = new StringBuffer();
		for (String code : codes) {
			codeLines.append(code);
			codeLines.append("\n");
		}
		return codeLines.toString();
	}
	
	private static void loadTemplateFromFile() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(CodeGenerator.class.getResourceAsStream("/java_template.txt")));
			String line = null;
			while((line = reader.readLine()) != null) {
				CODE_TEMPLATE = CODE_TEMPLATE + line + "\n";
			}
		} catch (Exception e) {
			throw new RuntimeException("load temp from file error!", e);
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	
}
