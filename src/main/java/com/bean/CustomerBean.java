package com.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hb_customer")
public class CustomerBean {

	@Id
	@GeneratedValue
	private int CustomerId;
	@Column(nullable = false)
	private String customerName;
	@OneToOne(cascade = CascadeType.ALL)
	private AddressBean address;

	public AddressBean getAddress() {
		return address;
	}

	public void setAddress(AddressBean address) {
		this.address = address;
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
