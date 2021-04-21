package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.BusinessDAO;
import com.techelevator.model.Business;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class BusinessController {

	private BusinessDAO businessDAO;
		
	public BusinessController(BusinessDAO businessDAO) {
		this.businessDAO = businessDAO;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/favorites", method = RequestMethod.GET)
	public List<Business> getFavoriteBusinesses(Principal principal) {
		return businessDAO.getFavorites(principal.getName());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(path = "/favorites/{id}", method = RequestMethod.DELETE)
	public String deleteFavoriteBusinesses(@Valid @PathVariable("id") String businessID, Principal principal) {
		String response = "";
		int result = businessDAO.deleteFromFavorites(businessID, principal.getName());
		if (result == 1) {
			response = "Removed from favorites successfully.";
		} else {
			response = "There was a database issue and your request was denied.";
		}
		return response;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/favorites/{id}", method = RequestMethod.POST)
	public String addToFavorites(@Valid @PathVariable("id") String businessID, Principal principal) {
		String response = "";
		int result = businessDAO.addToFavorites(businessID, principal.getName());
		if (result == 1) {
			response = "Added to favorites successfully.";
		} else {
			response = "There was a database issue and your request was denied.";
		}
		return response;
	}
	
}
