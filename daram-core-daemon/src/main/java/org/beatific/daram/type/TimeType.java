package org.beatific.daram.type;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.beatific.ddirori.attribute.annotation.DefinitionType;
import org.beatific.ddirori.attribute.resolver.DefinitionTypeResolver;

@DefinitionType(type="time")
public class TimeType implements DefinitionTypeResolver<String> {

	@Override
	public String resolve() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

}
