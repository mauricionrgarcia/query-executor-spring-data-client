package com.example.dto;

import org.springframework.data.jpa.util.SpecificationJoinField;
import org.springframework.data.jpa.util.criteriabuilder.PredicateJoinType;

/**
 * Specification Filter
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 06/05/2018 18:28:50
 */
public class AddressFilterDTO {

	@SpecificationJoinField(joinType = PredicateJoinType.RECURSIVE)
	private PersonFilterDTO person;

	/**
	 * @return the person
	 */
	public PersonFilterDTO getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(PersonFilterDTO person) {
		this.person = person;
	}

}