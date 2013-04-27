/**
 * 
 */
package com.sohu.shell.command;

import com.sohu.shell.CodeContainer;

/**
 * 
 * @author liaohongliu
 *
 * 创建日期:2013-4-27 下午5:54:56
 */
public interface ICommand {

	/**
	 * 是否处理该命令
	 * @param code 客户端输入的字符串
	 * @return
	 */
	public boolean accept(String code);
	
	/**
	 * 具体的处理逻辑
	 * @param code 客户端输入的字符串
	 * @param codeContainer
	 * @return
	 */
	public boolean handle(String code, CodeContainer codeContainer);
	
}
