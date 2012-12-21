package edu.tongji.se.tools;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.FloatType;

public class DialectRegExp extends MySQLDialect {
	public DialectRegExp() {
		super();
		
		registerFunction("get_distance", new SQLFunctionTemplate(new FloatType(),
				"GET_DISTANCE(?1, ?2, ?3, ?4)"));
	}
}
