package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dto.PersonDTO;
import com.example.model.Person;
import com.example.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryExecutorClientApplicationTests {

	@Autowired
	private transient PersonRepository personRepository;

	private List<Person> people;

	@Before
	public void init() {
		Person person = new Person();
		person.setName("Ana");
		person.setDtBirth(LocalDate.now());
		person.setDtLastChange(LocalDateTime.now());
		person.setTotal(18);
		person.setRate(new BigDecimal("165.68"));

		Person person2 = new Person();
		person2.setName("Roberta");
		person2.setDtBirth(LocalDate.now());
		person2.setDtLastChange(LocalDateTime.now());
		person2.setTotal(12);
		person2.setRate(new BigDecimal("115.68"));

		people = personRepository.saveAll(Arrays.asList(person, person2));

	}

	@After
	public void end() {
		personRepository.deleteAll(people);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void jpaFind() {
		Person person = people.get(0);
		Optional<Person> test = personRepository.findById(person.getCode());

		Assert.assertTrue(test.isPresent());
		Assert.assertEquals(person.getName(), test.get().getName());
	}

	@Test
	public void nativeQueryFindAll() {
		List<PersonDTO> result = this.personRepository.findAllPerson();
		Assert.assertNotNull(result);
	}

	@Test
	public void nativeQueryFind() {
		Person person = people.get(0);
		Optional<PersonDTO> test = personRepository.find(person.getCode());

		Assert.assertTrue(test.isPresent());
		Assert.assertEquals(person.getName(), test.get().getName());
		Assert.assertEquals(person.getCode(), test.get().getCode());
		Assert.assertEquals(person.getDtBirth(), test.get().getDtBirth());
		Assert.assertEquals(person.getRate(), test.get().getRate());
		Assert.assertEquals(person.getTotal(), test.get().getTotal());

	}

}