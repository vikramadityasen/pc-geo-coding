package com.practice.postalcodeCoordinates.service;

import org.springframework.http.ResponseEntity;

public interface PostalCodeDetailsService {

	ResponseEntity<Object> getPostalGeoCodeInDB();

}
