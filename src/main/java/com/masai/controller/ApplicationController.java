package com.masai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.masai.entities.Data;
import com.masai.entities.Entries;
import com.masai.entities.ResultDTO;
import com.masai.service.ApplicationServiceImpl;

@RestController
public class ApplicationController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ApplicationServiceImpl appService;
	
	@GetMapping("entries/{category}")
	ResponseEntity<List<ResultDTO>> getTheDetailsByCategory(@PathVariable String category){
		Data data = restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
	    List<Entries> entries = data.getEntries();
	    List<ResultDTO> results = new ArrayList<>();
	                
	    for(Entries en:entries) {
	    if(en.getCategory().equalsIgnoreCase(category)) {
		              results.add(new ResultDTO(en.getApi(), en.getDescription()));   
		}		                   
	    }   
	                  return new ResponseEntity<>(results,HttpStatus.OK);
	    }
	
	@PostMapping("entries")
	ResponseEntity<String> saveData(@RequestBody Entries entries){
		Data data = restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
        List<Entries> entrie = data.getEntries();
        entrie.add(entries);
        
        String message = " ";
       
        for(int i=0;i<entrie.size();i++) {
        	         message = appService.saveEntries(entrie.get(i)); 	
        }
                    return new  ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	    }
	
	/*Third question : 
	 * How can we make this application secure and reliable?
	 * 
	 * to make it reliable we can use exception handling in this
	 * application i added the global exception handler so that
	 * if any exception occurred client will get the problem response
	 * in a proper formate.
	 * 
	 * we can use validation by validating the data we restrict 
	 * the client by passing invalid data.
	 * 
	 * and for security we can use spring security for login 
	 * and we can also create registration for our client.
	 * we can add role based authorization using spring security
	 * we can restrict who can send the GET request POST request.   
	 * 
	 * */
}
