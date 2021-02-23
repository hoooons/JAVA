package com.ssafy.HW10;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements INewsDAO {
	List<News> list = new ArrayList<>();

	public List<News> getNewsList(String url) {
		list.removeAll(list);
		connectNews(url);
		return list;
	}

	public void connectNews(String url) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(url);

			Element root = doc.getDocumentElement();
			NodeList nodes = root.getElementsByTagName("item");

			for (int i = 0; i < nodes.getLength(); i++) {

					News n = new News();
					Node item = nodes.item(i);
					NodeList kids = item.getChildNodes();

					for (int j = 0; j < kids.getLength(); j++) {
						Node kid = kids.item(j);
						String str = kid.getNodeName();

						if (str.equals("title"))
							n.setTitle(kid.getTextContent());
						else if (str.contains("desc"))
							n.setDesc(kid.getTextContent());
						else if (str.equals("link"))
							n.setLink(kid.getTextContent());
					}
					System.out.println(n);
					list.add(n);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
