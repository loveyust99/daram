package org.beatific.daram.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.beatific.daram.scheduler.Scheduler;
import org.beatific.daram.scheduler.TableReloader;
import org.beatific.ddirori.context.ApplicationContext;

public class DaramMain {

	private static Log logger = LogFactory.getLog(DaramMain.class);
	
	public static void main(String[] args) {
		
		ApplicationContext context = ApplicationContextFactory.createWebApplicationContext();
		logger.debug("DDirori Application Context initializing");
		context.init();
		logger.debug("DDirori Application Context initialized");
		
		Scheduler.start(new TableReloader());
	}
}
