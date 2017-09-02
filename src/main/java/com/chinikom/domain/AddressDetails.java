package com.chinikom.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "addressdetail")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = true)
	private String unit;

	@Column(nullable = false)
	private String street;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String zipCode;

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	private boolean isCurrentAddress;

	@Column(nullable = false)
	private boolean isMailingAddress;

	@Column(nullable = false)
	private boolean isBillingAddress;

	@Column(nullable = false)
	private boolean isPermanentResidence;

	@Column(nullable = false)
	private boolean isResidentialAddress;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference
	private UserDetails user;

	public AddressDetails() {

	}

	public AddressDetails(String street, String unit, String state,
			String city, String zipCode, String country,
			boolean isCurrentAddress, boolean isMailingAddress,
			boolean isBillingAddress, boolean isPermanentResidence,
			boolean isInvestmentProperty) {
		super();
		this.street = street;
		this.unit = unit;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
		this.isCurrentAddress = isCurrentAddress;
		this.isMailingAddress = isMailingAddress;
		this.isBillingAddress = isBillingAddress;
		this.isPermanentResidence = isPermanentResidence;
		if (isResidentialAddress) {
			this.isResidentialAddress = true;
		} else {
			this.isResidentialAddress = false;
		}
		// this.customer = customer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isCurrentAddress() {
		return isCurrentAddress;
	}

	public void setCurrentAddress(boolean isCurrentAddress) {
		this.isCurrentAddress = isCurrentAddress;
	}

	public boolean isMailingAddress() {
		return isMailingAddress;
	}

	public void setMailingAddress(boolean isMailingAddress) {
		this.isMailingAddress = isMailingAddress;
	}

	public boolean isBillingAddress() {
		return isBillingAddress;
	}

	public void setBillingAddress(boolean isBillingAddress) {
		this.isBillingAddress = isBillingAddress;
	}

	public boolean isPermanentResidence() {
		return isPermanentResidence;
	}

	public void setPermanentResidence(boolean isPermanentResidence) {
		this.isPermanentResidence = isPermanentResidence;
	}

	public boolean isResidentialAddress() {
		return isResidentialAddress;
	}

	public void setIsResidentialAddress(boolean isResidentialAddress) {
		this.isResidentialAddress = isResidentialAddress;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", Street=" + street + ", Unit=" + unit
				+ ", state=" + state + ", city=" + city + ", zipCode="
				+ zipCode + ", country=" + country + ", isCurrentAddress="
				+ isCurrentAddress + ", isMailingAddress=" + isMailingAddress
				+ ", isBillingAddress=" + isBillingAddress
				+ ", isPermanentResidence=" + isPermanentResidence
				+ ", isInvestmentProperty=" + isResidentialAddress + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressDetails other = (AddressDetails) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (unit == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
}
