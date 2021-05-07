package com.jinznet.transit.freemarker;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class CMSContent implements TemplateMethodModelEx {

	@Override
	public Object exec(@SuppressWarnings("rawtypes") List arguments)
			throws TemplateModelException {
		String url = "";
		String elementId = null;
		Object result = null;
		if(arguments.size() > 0){
			if (arguments.size() < 2) {
				url = arguments.get(0).toString();
			} else {
				url = arguments.get(0).toString();
				elementId = arguments.get(1).toString();
			}
			try {
				result = cmsRead(url, elementId);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private String cmsRead(String url, String elementId) throws IOException {
		String content = "";
		if(url == null){
			return content;
		}
		Document document = Jsoup.connect(url)
				.userAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/600.1.3 (KHTML, like Gecko) Version/8.0 Mobile/12A4345d Safari/600.1.4")
				.get();
		if(document != null){
			if(elementId != null){
				Element element = document.getElementById(elementId);
				if(element != null){
					content = element.outerHtml();
				}
			}else{
				content = document.outerHtml();
			}
		}
		return content;
	}

}
