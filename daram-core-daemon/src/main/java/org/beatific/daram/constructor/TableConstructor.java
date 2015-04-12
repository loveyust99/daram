package org.beatific.daram.constructor;


import org.beatific.daram.table.Column;
import org.beatific.daram.table.Table;
import org.beatific.ddirori.bean.BeanDefinition;
import org.beatific.ddirori.bean.Constructor;
import org.beatific.ddirori.bean.annotation.Action;
import org.beatific.ddirori.type.TagType;

@Action(tag="table", type=TagType.BEAN)
public class TableConstructor implements Constructor<Table>{

	@Override
	public Table create(BeanDefinition definition) {
		
		Table table = new Table();
		table.setId((String)definition.attributes().get("id"));
		
		for(BeanDefinition child : definition.children()) {
			if("column".equals(child.getTagName())) {
				table.addColumn(new Column((String)child.attributes().get("name"), (String)child.attributes().get("value")));
			}
		}
		
		return table;
	}

}
