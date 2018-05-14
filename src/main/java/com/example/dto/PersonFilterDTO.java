package com.example.dto;

/**
 * Specification Filter
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 06/05/2018 18:28:50
 */
public class PersonFilterDTO {

	/**
	 * name
	 */
	private String name;

	/**
	 * total
	 */
	private Integer total;

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

}