package com.techelevator.services;

import java.util.List;
import com.techelevator.model.Business;


public interface YelpService {
	
	List<Business> getBusinessesNoRadius(String zipCode, String category);
	
	List<Business> getBusinessesWithRadius(String zipCode, String category, String radius);
	
	Business getBusinessByID(String businessID);
	
}
