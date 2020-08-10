package com.javalive.entity;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name = "USER_NAME") // , type=”String”)
	private String userName;
	@ElementCollection
	// Fields (including property get methods)Defines a collection of instances of a
	// basic type or embeddable class. Must be specified if the collection is to be
	// mapped by means of a collection table.
	private Collection<Address> lisOfAddresses = new ArrayList<Address>();

	public Collection<Address> getLisOfAddresses() {
		return lisOfAddresses;
	}

	public void setLisOfAddresses(Collection<Address> lisOfAddresses) {
		this.lisOfAddresses = lisOfAddresses;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String toString() {
		return "[User Name: " + userName + "n Office Address: " + this.lisOfAddresses + "]";
	}
}