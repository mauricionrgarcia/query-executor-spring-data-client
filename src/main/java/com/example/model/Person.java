package com.example.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * Entity to mapping TB_PEOPLE<br>
 * Extract the auth to abstract entity
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 19/02/2018 22:05:29
 */
@NamedNativeQueries({ @NamedNativeQuery(name = "person.all", query = "SELECT * FROM TB_PEOPLE") })
@Entity
@Table(name = "TB_PEOPLE")
public class Person implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5076342277118584038L;

	@Id
	@Column(name = "PK_PERSON")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;

	@Size(max = 50, min = 3)
	@Column(name = "TX_NAME", length = 50, nullable = false)
	private String name;

	@Column(name = "DT_BIRTH")
	private LocalDate dtBirth;

	@Column(name = "DT_LAST_CHANGE")
	@LastModifiedDate
	private LocalDateTime dtLastChange;

	@Column(name = "ID_USER")
	@LastModifiedBy
	private Long userChange;

	@Column(name = "VL_RATE", precision = 7, scale = 2)
	private BigDecimal rate;

	@Column(name = "VL_TOTAL")
	private Integer total;

	/**
	 * @param code
	 */
	public Person(Long code) {
		super();
		this.code = code;
	}

	/**
	 * no args
	 */
	public Person() {
		super();
	}

	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dtBirth
	 */
	public LocalDate getDtBirth() {
		return dtBirth;
	}

	/**
	 * @param dtBirth the dtBirth to set
	 */
	public void setDtBirth(LocalDate dtBirth) {
		this.dtBirth = dtBirth;
	}

	/**
	 * @return the dtLastChange
	 */
	public LocalDateTime getDtLastChange() {
		return dtLastChange;
	}

	/**
	 * @param dtLastChange the dtLastChange to set
	 */
	public void setDtLastChange(LocalDateTime dtLastChange) {
		this.dtLastChange = dtLastChange;
	}

	/**
	 * @return the userChange
	 */
	public Long getUserChange() {
		return userChange;
	}

	/**
	 * @param userChange the userChange to set
	 */
	public void setUserChange(Long userChange) {
		this.userChange = userChange;
	}

	/**
	 * @return the rate
	 */
	public BigDecimal getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
