/**
 * 
 */
package com.sohu.shell.command;

import com.sohu.shell.CodeContainer;

/**
 * 
 * @author liaohongliu
 *
 * 创建日期:2013-4-27 下午6:00:05
 */
public class RemovePrintCodeCommand implements ICommand {

	@Override
	public boolean accept(String code) {
		if(code.trim().equals("cp") || code.trim().equals("cleanprint")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean handle(String code, CodeContainer codeContainer) {
		codeContainer.removePrintCodes();
		return true;
	}

}
