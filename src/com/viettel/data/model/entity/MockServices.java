package com.viettel.data.model.entity;

// Generated Aug 6, 2015 9:16:39 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MockServices generated by hbm2java
 */
@Entity
@Table(name = "MOCK_SERVICES")
public class MockServices {

	private BigDecimal serviceId;
	private BigDecimal priceId;

	public MockServices() {
	}

	public MockServices(BigDecimal serviceId) {
		this.serviceId = serviceId;
	}

	public MockServices(BigDecimal serviceId, BigDecimal priceId) {
		this.serviceId = serviceId;
		this.priceId = priceId;
	}

	@Id
	@Column(name = "SERVICE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(BigDecimal serviceId) {
		this.serviceId = serviceId;
	}

	@Column(name = "PRICE_ID", precision = 22, scale = 0)
	public BigDecimal getPriceId() {
		return this.priceId;
	}

	public void setPriceId(BigDecimal priceId) {
		this.priceId = priceId;
	}

}
