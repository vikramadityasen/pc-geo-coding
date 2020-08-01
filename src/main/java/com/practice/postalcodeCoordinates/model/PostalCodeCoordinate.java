package com.practice.postalcodeCoordinates.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pc_geo_crd")
public class PostalCodeCoordinate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(unique = true)
	private String postalCode;
	@Column
	private Double latitude;
	@Column
	private Double longitude;

	public PostalCodeCoordinate() {
		super();
	}

	public PostalCodeCoordinate(String postalCode, Double latitude, Double longitude) {
		super();
		this.postalCode = postalCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "PostalCodeCoordinate [postalCode=" + postalCode + ", latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
