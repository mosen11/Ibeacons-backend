package nl.ibeacons.ibeacons.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cutomer")
public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public Long id;

	public Long getId() {
		return id;
	}

	@Column
	private String compoanyURL;

	@Column
	private String customerName;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(final String customerName) {
		this.customerName = customerName;
	}


	public String getCompoanyURL() {
		return compoanyURL;
	}

	public void setCompoanyURL(final String compoanyURL) {
		this.compoanyURL = compoanyURL;
	}


}
