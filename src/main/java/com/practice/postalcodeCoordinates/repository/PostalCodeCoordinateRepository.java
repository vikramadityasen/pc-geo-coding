package com.practice.postalcodeCoordinates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.postalcodeCoordinates.model.PostalCodeCoordinate;

@Repository
public interface PostalCodeCoordinateRepository extends JpaRepository<PostalCodeCoordinate, String> {

}
