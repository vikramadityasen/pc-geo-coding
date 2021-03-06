package com.practice.postalcodeCoordinates.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.postalcodeCoordinates.service.PostalCodeDetailsService;

@RequestMapping("/api")
@RestController
public class PostalCodeCoordinatesRestController {

	@Autowired
	private PostalCodeDetailsService postalCodeDetailsService;

	@GetMapping(value = "/savePostalGeoCode")
	public ResponseEntity<Object> getPostalGeoCodeInDB() {
		return postalCodeDetailsService.getPostalGeoCodeInDB();
	}
}
