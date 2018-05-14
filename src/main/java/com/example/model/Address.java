package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity to mapping TB_ADDRESS<br>
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 12/05/2018 23:05:52
 */
@Entity
@Table(name = "TB_ADDRESS")
public class Address implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5076342277118584038L;

	@Id
	@Column(name = "PK_ADDRESS")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;

	@Column(name = "TX_NAME", length = 50, nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "FK_PERSON")
	private Person person;

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
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [code=" + code + ", name=" + name + ", person=" + person + "]";
	}

}
