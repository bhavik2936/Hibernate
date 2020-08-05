package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hb_address")
public class AddressBean {

	@Id
	private int addressId;
	@Column(nullable = false)
	private String streetName;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String state;

	public final int getAddressId() {
		return addressId;
	}

	public final void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public final String getStreetName() {
		return streetName;
	}

	public final void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public final String getCity() {
		return city;
	}

	public final void setCity(String city) {
		this.city = city;
	}

	public final String getState() {
		return state;
	}

	public final void setState(String state) {
		this.state = state;
	}
}
