package com.example.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO to mapping Person entity<br>
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 11/03/2018 19:44:40
 */
public class PersonDTO {

	/**
	 * identifier
	 */
	private Long code;

	/**
	 * name
	 */
	private String name;

	/**
	 * date birth
	 */
	private LocalDate dtBirth;

	/**
	 * @see GenreEnum
	 */
	private String genre;

	/**
	 * active <br>
	 * true = Y<br>
	 * false = N
	 */
	private String active;

	/**
	 * last change
	 */
	private LocalDateTime dtLastChange;

	/**
	 * User cahnge code
	 */
	private Long user;

	/**
	 * rate
	 */
	private BigDecimal rate;

	/**
	 * total
	 */
	private Integer total;

	/**
	 * @param code
	 */
	public PersonDTO(Long code) {
		super();
		this.code = code;
	}

	/**
	 * no args
	 */
	public PersonDTO() {
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
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
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
	 * @return the user
	 */
	public Long getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Long user) {
		this.user = user;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonDTO [code=" + code + ", name=" + name + ", dtBirth=" + dtBirth + ", genre=" + genre + ", active="
				+ active + ", dtLastChange=" + dtLastChange + ", user=" + user + ", rate=" + rate + ", total=" + total
				+ "]";
	}

}