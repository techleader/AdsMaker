package com.adelement;

import java.util.List;

import com.adelement.dao.MySqlDataServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adelement.dao.DataService;

 
@RestController
public class AdsController {
	
	DataService dataService = new MySqlDataServiceImpl();
	
	@RequestMapping("/adelement/ads/listHeadlines")
	public List<String> getListOfEmployees(){
		return dataService.getAllHeadlines();
	}
	
}
