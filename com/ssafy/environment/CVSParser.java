package com.ssafy.environment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CVSParser {
	
	static List<Kuro> list = new ArrayList<>();
	
	public static List<Kuro> getEV(String url, String key){
		list.removeAll(list);
		connectEV(url);
		return searchAll(key);
	}
	private static void connectEV(String url) {
		BufferedReader br = null;
		String line;
		
		try {
			br = new BufferedReader(new FileReader(url)); 
			while((line = br.readLine()) != null) {
				Kuro j = new Kuro();
				String[] temp = line.split(","); 
				
				j.setName(temp[0]);
				j.setNy(temp[8]);
				j.setCheck(temp[9]);
				j.setAdd(temp[11]);
				list.add(j);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static List<Kuro> searchAll(String key){
		if(key.equals("전체")) {
			list.remove(0);
			return list;
		}
		List<Kuro> find = new ArrayList<>();
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i).getCheck().contains(key)) {
				find.add(list.get(i));
			}
		}
		return find;
	}
}
