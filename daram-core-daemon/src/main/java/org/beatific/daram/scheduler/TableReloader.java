package org.beatific.daram.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.beatific.daram.mbean.MBeanManager;
import org.beatific.daram.table.Table;
import org.beatific.ddirori.context.ApplicationContextUtils;

@Schedule(fixed=1000, threads = 5)
public class TableReloader implements Runnable {

	@Override
	public void run() {
		MBeanManager.reload();

		for (Table table : getTables()) {
			table.load();
		}
	}

	private static List<Table> getTables() {

		List<Table> tables = new ArrayList<Table>();
		for (String beanName : Table.ids) {
			Table table = (Table) ApplicationContextUtils
					.getApplicationContext().getBean(beanName);
			tables.add(table);
		}

		return tables;
	}

}
