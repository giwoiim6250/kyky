/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 */
package com.jinznet.transit.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

/**
 * @author hejian
 *
 */
public class JsoupTest {

	@Test
	public void parseIdTest(){
		try {
			Document document = Jsoup.connect("http://translat.kuaizhan.com/19/9/p362824749e21b3")
					.userAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/600.1.3 (KHTML, like Gecko) Version/8.0 Mobile/12A4345d Safari/600.1.4")
					.get();
//			System.out.println(document.outerHtml());
			Element element = document.getElementById("article-awardlist");
			System.out.println(element.outerHtml());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
