package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.model.Person;
import com.example.repository.query.PersonQueryRepository;

/**
 * Repository {@link Person}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmailcom">Mauricio Garcia</a>
 * @version
 * @sinse 18/02/2018 19:25:47
 */
@Repository
public interface PersonRepository
		extends JpaRepository<Person, Long>, PersonQueryRepository, JpaSpecificationExecutor<Person> {

	/**
	 * find a specific Person by:
	 * 
	 * @param code: code identifier
	 * @return {@link Optional} {@link Person}
	 */
	Optional<Person> findByCode(Long code);
}
