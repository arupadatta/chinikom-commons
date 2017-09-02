package com.chinikom.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "userdetails")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String sex;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth", unique = false, nullable = false, length = 10)
	private Date dateOfBirth;

	@Column(nullable = false)
	private String isMarried;

	@Temporal(TemporalType.DATE)
	@Column(name = "marriage_anniversary", unique = false, nullable = false, length = 10)
	private Date marriageAnniversery;

	@Column(nullable = true)
	private long bonusPoints;

	@Column(nullable = true)
	private String rewardCardNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "member_since", unique = false, nullable = false, length = 10)
	private Date memberSince;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@JsonManagedReference
	private final Set<AddressDetails> addresses = new HashSet<AddressDetails>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@JsonManagedReference
	private final Set<ContactDetails> contacts = new HashSet<ContactDetails>();

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_login_id")
	private final UserLogin userLogin = null;

	public UserDetails() {

	}

	public UserDetails(String firstName, String lastName, String sex,
			Date dateOfBirth, String isMarried, Date marriageAnniversery) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.isMarried = isMarried;
		this.marriageAnniversery = marriageAnniversery;
		this.memberSince = new Date();
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", name=" + name + ", sex=" + sex
				+ ", dateOfBirth=" + dateOfBirth + ", isMarried=" + isMarried
				+ ", marriageAnniversery=" + marriageAnniversery
				+ ", bonusPoints=" + bonusPoints + ", rewardCardNo="
				+ rewardCardNo + ", memberSince=" + memberSince
				+ ", addresses=" + addresses + ", contacts=" + contacts
				+ ", userLogin=" + userLogin + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIsMarried() {
		return isMarried;
	}

	public void setIsMarried(String isMarried) {
		this.isMarried = isMarried;
	}

	public Date getMarriageAnniversery() {
		return marriageAnniversery;
	}

	public void setMarriageAnniversery(Date marriageAnniversery) {
		this.marriageAnniversery = marriageAnniversery;
	}

	public long getBonusPoints() {
		return bonusPoints;
	}

	public void setBonusPoints(long bonusPoints) {
		this.bonusPoints = bonusPoints;
	}

	public String getRewardCardNo() {
		return rewardCardNo;
	}

	public void setRewardCardNo(String rewardCardNo) {
		this.rewardCardNo = rewardCardNo;
	}

	public Date getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}

	public Set<AddressDetails> getAddresses() {
		return addresses;
	}

	public Set<ContactDetails> getContacts() {
		return contacts;
	}

	public UserLogin getUserLogin() {
		return userLogin;
	}

}
