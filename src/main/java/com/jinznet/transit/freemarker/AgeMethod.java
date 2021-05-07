package com.jinznet.transit.freemarker;

import java.util.List;

import org.joda.time.DateTime;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class AgeMethod implements TemplateMethodModelEx {

	@Override
	public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
		if(arguments.size() == 0){
			return 0;
		}else{
			DateTime now = new DateTime();
			int end  = now.getYear();
			int start = Integer.valueOf(arguments.get(0).toString());
			return (end - start + 1);
		}
	}

}
