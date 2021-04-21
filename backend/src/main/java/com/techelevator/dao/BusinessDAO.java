package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Business;

public interface BusinessDAO {
	
	List<Business> getFavorites(String username);
	
	int addToFavorites(String businessID, String username);
	
	int deleteFromFavorites(String businessID, String username);
	
}
