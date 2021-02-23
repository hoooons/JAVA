package com.ssafy.HW10;

import java.util.List;

public interface INewsDAO {
	
	public List<News> getNewsList(String url);
	
}
