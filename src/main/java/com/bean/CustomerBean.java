package com.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hb_customer")
public class CustomerBean {

	@Id
	private int CustomerId;
	@Column(nullable = false)
	private String customerName;
	@OneToOne(cascade = CascadeType.ALL)
	private AddressBean address;

	public final AddressBean getAddress() {
		return address;
	}

	public final void setAddress(AddressBean address) {
		this.address = address;
	}

	public final int getCustomerId() {
		return CustomerId;
	}

	public final void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public final String getCustomerName() {
		return customerName;
	}

	public final void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
