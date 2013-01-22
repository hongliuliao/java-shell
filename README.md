java-shell
==========

让你的可以像python的shell交互式命令一样进行代码的测试

使用步骤:

一.获取jar包

	基于源代码:
		1.git clone git@github.com:hongliuliao/java-shell.git
		2.mvn clean package
	直接下载(需要iteye账号):
		http://dl.iteye.com/topics/download/fe7e05a0-128e-3d39-8338-0b0ba0fb4a7f
                
二.将获取到的jar加入path

三.执行代码

	java -jar java-shell-0.0.1-SNAPSHOT.jar
        
	之后就可以输入代码了,例如输入如下代码
	>>>import java.util.List;
	>>>import java.util.ArrayList;
	
	>>>List<String> list = new ArrayList<String>();
	>>>list.add("test1"); 
	>>>list.add("test2"); 
	>>>System.out.println(list);
	
	之后会看到控制台输出的内容...
	也可以到https://github.com/hongliuliao/java-shell/wiki看看运行效果
	
实现原理:

	1.编译输入内容,并会将编译的内容放到generate文件夹
	2.执行编译的代码
