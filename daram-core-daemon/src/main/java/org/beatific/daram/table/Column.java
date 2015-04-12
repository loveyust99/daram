package org.beatific.daram.table;

import org.beatific.daram.mbean.MBeanManager;

public class Column {

	private String name;
	private String value;
	private String expression;
	
	public Column(String name, String expression) {
		this.name = name;
		this.expression = expression;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	public void loadColumn() {
		this.value = (String)MBeanManager.extract(expression);
	}

	@Override
	public String toString() {
		return "Column [name=" + name + ", value=" + value + ", expression="
				+ expression + "]";
	}
	
}
