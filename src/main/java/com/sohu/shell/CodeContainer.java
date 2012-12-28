/**
 * 
 */
package com.sohu.shell;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hongliuliao
 *
 * createTime:2012-12-28 ÉÏÎç9:53:51
 */
public class CodeContainer {

	private List<String> importCodes = new ArrayList<String>();
	
	private List<String> codes = new ArrayList<String>();
	
	private String className;
	
	public void addCode(String code) {
		this.codes.add(code);
	}
	
	public void addImport(String importCode) {
		this.importCodes.add(importCode);
	}

	/**
	 * @return the importCodes
	 */
	public List<String> getImportCodes() {
		return importCodes;
	}

	/**
	 * @return the codes
	 */
	public List<String> getCodes() {
		return codes;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	
	public void removeCode(String line) {
		this.importCodes.remove(line);
		this.codes.remove(line);
	}
	
}
