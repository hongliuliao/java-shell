/**
 * 
 */
package com.sohu.shell.command;

import java.util.ArrayList;
import java.util.List;

import com.sohu.shell.CodeContainer;

/**
 * 
 * @author liaohongliu
 *
 * 创建日期:2013-4-27 下午5:46:43
 */
public class CommandsHolder {

	List<ICommand> commands = new ArrayList<ICommand>();
	
	public CommandsHolder() {
		commands.add(new ExitCommand());
		commands.add(new RemovePrintCodeCommand());
		commands.add(new RemoveAllCodeCommand());
	}
	
	public boolean effect(String code, CodeContainer container) {
		for (ICommand command : commands) {
			if(command.accept(code)) {
				return command.handle(code, container);
			}
		}
		return false;
	}
	
}


