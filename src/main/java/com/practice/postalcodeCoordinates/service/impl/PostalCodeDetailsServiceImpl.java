package com.practice.postalcodeCoordinates.service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.postalcodeCoordinates.model.PostalCodeCoordinate;
import com.practice.postalcodeCoordinates.repository.PostalCodeCoordinateRepository;
import com.practice.postalcodeCoordinates.service.PostalCodeDetailsService;

@Service
public class PostalCodeDetailsServiceImpl implements PostalCodeDetailsService {
	@Autowired
	private PostalCodeCoordinateRepository postalCodeCoordinateRepository;

	@Override
	public void getAllPostalCodeDetails() throws Exception {
		BufferedReader br = null;
		try (FileInputStream fis = new FileInputStream("F:\\PC_GEO\\PCGEOUNIQ_MMYYYY_Sample.txt")) {
			br = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				processLine(sCurrentLine);
			}
		} finally {
			if (br != null)
				br.close();
		}
	}

	public void processLine(String line) {

		PostalCodeCoordinate pcc = new PostalCodeCoordinate();
		pcc.setPostalCode(line.substring(7, 14));
		pcc.setLatitude(Double.parseDouble(line.substring(20, 40)));
		pcc.setLongitude(Double.parseDouble(line.substring(40, 60)));
		
		System.out.println(pcc.getPostalCode() + "\t" + pcc.getLatitude() + "\t" + pcc.getLongitude());

		postalCodeCoordinateRepository.save(pcc);
		
	}
}
