package com.example.PolitischeRedenV1.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.PolitischeRedenV1.enities.Rede;
import com.example.PolitischeRedenV1.enities.Response;

import Helpers.Helper;

@RestController
public class Controller {

	
	@GetMapping("/")
	public String home() {
		
		return " Aufagabe Home " ;
	}
	
	 @GetMapping("evaluation/")
	 public Response evaluation(@RequestParam String url ) throws FileNotFoundException, IOException {
		 
		 
		 Response response = new Response();
		  
		 //we need to read the file passed as an url
		ArrayList  rede =Helper.convert(url);
		 // we need to transform the file into an array of the entities with type  rede
	   
	   
		
		
		
	     
	     String politiker_mit_wenigisten_wörter=Helper.minWords(rede).getRedner();
	     
	     response.setLeastWordy(politiker_mit_wenigisten_wörter);
		
		 
		String inneresicherheit =Helper.responseSecurity(rede, "Innere Sicherheit");
		 if(!inneresicherheit.equals("nothing")) {response.setMostSecurity(inneresicherheit);}
		
		 String jahr = Helper.response2013(rede, "2013");
		 if(!jahr.equals("nothing")) {response.setMostSpeeches(jahr);}
		 
		 
		 return response ;
		 
		 
		 
	 }
}
