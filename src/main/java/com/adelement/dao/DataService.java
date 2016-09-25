package com.adelement.dao;

import com.adelement.model.Ads;
import com.adelement.model.Button;
import com.adelement.model.HeadLine;
import com.adelement.model.SubHeadLine;

import java.util.List;

public interface DataService {

	public List<HeadLine> getAllHeadlines();
	public List<SubHeadLine> getAllSubHeadlines();
	public List<String> getImagesPath();
	public List<Button> getAllButtons();
	public boolean saveAds(Ads ads);

}
