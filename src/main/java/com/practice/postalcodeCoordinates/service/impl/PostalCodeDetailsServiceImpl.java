package com.practice.postalcodeCoordinates.service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.postalcodeCoordinates.exception.RecordNotFoundException;
import com.practice.postalcodeCoordinates.model.PostalCodeCoordinate;
import com.practice.postalcodeCoordinates.repository.PostalCodeCoordinateRepository;
import com.practice.postalcodeCoordinates.service.PostalCodeDetailsService;

@Service
public class PostalCodeDetailsServiceImpl implements PostalCodeDetailsService {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private PostalCodeCoordinateRepository postalCodeCoordinateRepository;

	@Override
	public ResponseEntity<Object> getPostalGeoCodeInDB() {
		ResponseEntity<Object> response = null;
		BufferedReader br = null;
		try (FileInputStream fis = new FileInputStream("F:\\PC_GEO\\PCGEOUNIQ_MMYYYY_Sample.txt")) {
			br = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				response = loadData(sCurrentLine);
			}
			br.close();
		} catch (Exception e) {
			String message = String.format("Duplicate or invalid postal code: %s", e.getMessage());
			logger.error(message);
			throw new RecordNotFoundException(message);
		}
		return response;
	}

	public ResponseEntity<Object> loadData(String line) {

		PostalCodeCoordinate pcc = new PostalCodeCoordinate();
		pcc.setPostalCode(line.substring(7, 14));
		pcc.setLatitude(Double.parseDouble(line.substring(20, 40)));
		pcc.setLongitude(Double.parseDouble(line.substring(40, 60)));

		logger.debug("Postal Code: {}, Latitude: {}, Longitude: {}", pcc.getPostalCode(), pcc.getLatitude(), pcc.getLongitude());

		postalCodeCoordinateRepository.save(pcc);

		return ResponseEntity.ok(HttpStatus.CREATED);

	}
}
