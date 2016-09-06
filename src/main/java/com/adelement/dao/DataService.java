package com.adelement.dao;

import com.adelement.model.HeadLine;

import java.util.List;

public interface DataService {

	public List<HeadLine> getAllHeadlines();
	public List<String> getAllSubHeadlines();
	public List<String> getImagesPath();
	public List<String> getAllButtons();
	public boolean saveAds(String headline,String subHeadline,String image, String button);

}
