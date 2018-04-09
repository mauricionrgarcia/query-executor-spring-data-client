package com.example.repository.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dto.PersonDTO;
import com.example.repository.resultSet.PersonResultSet;
import com.query.executor.JpaQuery;
import com.query.executor.JpaQueryExecutor;
import com.query.nativequery.JpaNamedNativeQuery;

/**
 * Custom repository impl
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 07/04/2018 20:23:45
 */
public class PersonQueryRepositoryImpl implements PersonQueryRepository {

	@JpaQuery
	@Autowired
	private transient JpaQueryExecutor jpaQuery;

	/**
	 * {@link EntityManager}
	 */
	@PersistenceContext
	private EntityManager manager;

	public Optional<PersonDTO> find(Long code) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", code);

		com.query.query.Query<PersonDTO> query = new JpaNamedNativeQuery<>("person.find.id.orm", new PersonResultSet(),
				PersonDTO.class, map);
		return jpaQuery.getSingleResult(query);
	}

	@Override
	public List<PersonDTO> findAllPerson() {
		com.query.query.Query<PersonDTO> query = new JpaNamedNativeQuery<>("person.orm", new PersonResultSet(),
				PersonDTO.class);
		List<PersonDTO> result = jpaQuery.getResultList(query);
		return result;
	}
}
