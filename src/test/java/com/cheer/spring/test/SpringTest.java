/*
 * 文件名：SpringTest.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年11月7日
 */

package com.cheer.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cheer.spring.helloworld.MessagePrinter;
import com.cheer.spring.helloworld.MessageService;

public class SpringTest
{
	@Test
	public void testOldStyle()
	{
		MessageService msgService = new MessageService();
		
		MessagePrinter msgPrinter = new MessagePrinter();
		
		msgPrinter.setMsgService(msgService);
		msgPrinter.printMessage();
	}
	
	  @Test
	    public void testSpringStyle()
	    {
	        //------------Spring特性 IOC DI(Dependency Injection) 依赖注入
	        //------------Spring的beans工厂帮助我们创建对象（通过反射的方式Class.forName("")）
	        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.beans.xml");
	        MessagePrinter msgPrinter = context.getBean(MessagePrinter.class);
	        msgPrinter.printMessage();
	    }

}
