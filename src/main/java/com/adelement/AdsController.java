package com.adelement;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adelement.dao.DataService;

 
@RestController
public class AdsController {
	
	DataService dataService;
	
	@RequestMapping("/listHealines")
	public List<String> getListOfEmployees(){
		return dataService.getAllHeadlines();
	}
	
}
