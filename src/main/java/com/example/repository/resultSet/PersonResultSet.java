package com.example.repository.resultSet;

import com.example.dto.PersonDTO;
import com.query.resultset.ResultSet;
import com.query.resultset.RowResult;

public class PersonResultSet implements ResultSet<PersonDTO> {

	/**
	 * sql result name position
	 */
	private static final Integer NAME = 0;
	/**
	 * sql result code position
	 */
	private static final Integer CODE = 1;
	/**
	 * sql result code position
	 */
	private static final Integer BIRTH = 2;
	/**
	 * sql result code position
	 */
	private static final Integer DATE_CHANGE = 3;

	/**
	 * sql result code position
	 */
	private static final Integer RATE = 4;
	/**
	 * sql result code position
	 */
	private static final Integer TOTAL = 5;

	@Override
	public PersonDTO mapRow(RowResult rowResult) {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setName(rowResult.getString(NAME));
		personDTO.setCode(rowResult.getLong(CODE));
		personDTO.setDtBirth(rowResult.getLocalDate(BIRTH));
		personDTO.setDtLastChange(rowResult.getLocalDateTime(DATE_CHANGE));
		personDTO.setRate(rowResult.getBigDecimal(RATE));
		personDTO.setTotal(rowResult.getInteger(TOTAL));
		return personDTO;
	}

}
