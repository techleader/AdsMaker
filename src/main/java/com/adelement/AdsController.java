package com.adelement;

import java.util.List;

import com.adelement.dao.MySqlDataServiceImpl;
import com.adelement.model.HeadLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adelement.dao.DataService;

 
@RestController
public class AdsController {
	@Autowired
	DataService dataService;
	
	@RequestMapping("/adelement/ads/listHeadlines")
	public List<HeadLine> getListOfEmployees(){
		return dataService.getAllHeadlines();
	}
	
}
