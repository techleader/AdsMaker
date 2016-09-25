package com.adelement.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import com.adelement.dao.MySqlDataServiceImpl;
import com.adelement.model.Button;
import com.adelement.model.HeadLine;
import com.adelement.model.SubHeadLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adelement.dao.DataService;

 
@RestController
public class AdsController {
	@Autowired
	DataService dataService;
	
	@RequestMapping("/adelement/ads/listHeadlines")
	public List<HeadLine> getAllHeadlines(){
		return dataService.getAllHeadlines();
	}

	@RequestMapping("/adelement/ads/listSubHeadlines")
	public List<SubHeadLine> getAllSubHeadlines(){
		return dataService.getAllSubHeadlines();
	}

	@RequestMapping("/adelement/ads/listButtons")
	public List<Button> getAllButtons(){
		return dataService.getAllButtons();
	}

	@RequestMapping("/adelement/ads/save")
	public boolean saveAds(@RequestBody String headline, @RequestBody String subheadline,@RequestBody String imageurl,@RequestBody String button){
		try {
			headline = URLDecoder.decode(headline,"UTF-8");
			subheadline = URLDecoder.decode(subheadline,"UTF-8");
			button = URLDecoder.decode(button,"UTF-8");
			imageurl = URLDecoder.decode(imageurl,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.out.println("Saving ads " + headline + ", " + subheadline + ", " + imageurl + ", " + button);
		return dataService.saveAds(headline,subheadline,imageurl,button);
	}
}
