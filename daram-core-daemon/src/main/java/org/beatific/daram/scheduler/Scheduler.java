package org.beatific.daram.scheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scheduler {
	
	public static void start(Runnable runnable) {
		
		Class<?> clazz = runnable.getClass();
		Schedule schedule = clazz.getAnnotation(Schedule.class);
		
		if(schedule == null)return;
		
		int interval = schedule.fixed();
		int threads = schedule.threads();
		
		ExecutorService executor = Executors.newFixedThreadPool(threads);
		
		while(true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {}
			
			executor.execute(runnable);
			
		}
	}
}
