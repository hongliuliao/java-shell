/**
 * 
 */
package com.sohu.shell.command;

import com.sohu.shell.CodeContainer;

/**
 * 
 * @author liaohongliu
 *
 * 创建日期:2013-4-27 下午5:44:18
 */
public class ExitCommand implements ICommand {

	@Override
	public boolean accept(String code) {
		if(code.equals("exit")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean handle(String code, CodeContainer codeContainer) {
		System.exit(0);
		return true;
	}

}
