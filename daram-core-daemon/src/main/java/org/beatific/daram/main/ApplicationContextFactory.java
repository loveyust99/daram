package org.beatific.daram.main;

import org.beatific.ddirori.context.ApplicationContext;
import org.beatific.ddirori.context.impl.XmlApplicationContext;

public class ApplicationContextFactory {

	public static ApplicationContext createWebApplicationContext(){

		String basePackage = "org.beatific.daram";
		XmlApplicationContext context  = new XmlApplicationContext(basePackage);
		
		String configLocationParam = "daram-context-daemon.xml";
		context.setFilePath(configLocationParam);
		return context;
	}
}
