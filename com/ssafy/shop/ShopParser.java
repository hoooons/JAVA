package com.ssafy.shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ShopParser {
	
	static List<Shop> list = new ArrayList<>();
	
	public static List<Shop> getShop(String url){
		list.removeAll(list);
		connectShop(url);
		return list;
	}
	private static void connectShop(String url) {
		BufferedReader br = null;
		String line;
		String path = url;
		
		try {
			br = new BufferedReader(new FileReader(path)); 
			while((line = br.readLine()) != null) {
				Shop s = new Shop();
				String[] temp = line.split(","); 
				
				s.setName(temp[0]);
				s.setGroup(temp[1]);
				s.setAdd(temp[2]);
				
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
