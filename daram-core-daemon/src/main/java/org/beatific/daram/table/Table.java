package org.beatific.daram.table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.beatific.ddirori.context.ApplicationContextUtils;
import org.beatific.ddirori.repository.RepositoryStore;

public class Table {

	public static List<String>ids = new ArrayList<String>();
	
	private final List<Column> columns = new ArrayList<Column>();
	private final RepositoryStore store = ApplicationContextUtils.getApplicationContext().getStore();
	private Date time;
	private String id;
	
    public void setId(String id) {
    	ids.add(id);
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void load() {
		
    	time = new Date();
		
    	loadColumns();
		
		store.change(this);
	}
    
	public void addColumn(Column column) {
		columns.add(column);
	}
	
    private void loadColumns() {
    	
    	for(Column column : columns)
    		column.loadColumn();
    }

	public List<Column> getColumns() {
		return columns;
	}
    
}
