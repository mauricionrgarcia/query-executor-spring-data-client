package com.example.repository.query;

import java.util.List;
import java.util.Optional;

import com.example.dto.PersonDTO;

/**
 * Custom repository impl
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 07/04/2018 20:22:12
 */
public interface PersonQueryRepository {

	/**
	 * find person by
	 * 
	 * @param code
	 * @return
	 */
	Optional<PersonDTO> find(Long code);

	/**
	 * @return
	 */
	List<PersonDTO> findAllPerson();

}
