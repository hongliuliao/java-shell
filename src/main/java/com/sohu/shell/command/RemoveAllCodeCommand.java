/**
 * 
 */
package com.sohu.shell.command;

import com.sohu.shell.CodeContainer;

/**
 * 
 * @author liaohongliu
 *
 * 创建日期:2013-4-27 下午6:01:16
 */
public class RemoveAllCodeCommand implements ICommand {

	@Override
	public boolean accept(String code) {
		if(code.equals("clear")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean handle(String code, CodeContainer codeContainer) {
		codeContainer.getCodes().clear();
		return true;
	}

}
