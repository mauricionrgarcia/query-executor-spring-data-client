package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.util.SpecificationSearchCriteria;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dto.AddressFilterDTO;
import com.example.dto.PersonFilterDTO;
import com.example.dto.PersonFilterLessDTO;
import com.example.model.Address;
import com.example.model.Person;
import com.example.repository.AddressRepository;
import com.example.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpecificationTests {

	@Autowired
	private transient PersonRepository personRepository;

	@Autowired
	private transient AddressRepository addressRepository;

	private List<Person> people;
	private List<Address> addresses;

	@Before
	public void init() {
		Person ana = new Person();
		ana.setName("Ana");
		ana.setDtBirth(LocalDate.now());
		ana.setDtLastChange(LocalDateTime.now());
		ana.setTotal(18);
		ana.setRate(new BigDecimal("165.68"));

		ana = personRepository.save(ana);

		Address homeAna = new Address();
		homeAna.setName("Home");
		homeAna.setPerson(ana);

		Address businessAna = new Address();
		businessAna.setName("Business");
		businessAna.setPerson(ana);

		Person person2 = new Person();
		person2.setName("Roberta");
		person2.setDtBirth(LocalDate.now());
		person2.setDtLastChange(LocalDateTime.now());
		person2.setTotal(12);
		person2.setRate(new BigDecimal("115.68"));
		person2 = personRepository.save(person2);

		Address address2 = new Address();
		address2.setName("Ro");
		address2.setPerson(person2);

		addresses = addressRepository.saveAll(Arrays.asList(homeAna, businessAna, address2));
		people = Arrays.asList(ana, person2);

	}

	@After
	public void end() {
		addressRepository.deleteAll(addresses);
		personRepository.deleteAll(people);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void specificationJoinRecursive() {

		AddressFilterDTO filter = new AddressFilterDTO();
		PersonFilterDTO person = new PersonFilterDTO();
		person.setName("Roberta");
		filter.setPerson(person);

		List<Address> result = null;
		try {

			SpecificationSearchCriteria<AddressFilterDTO, Address> spec = new SpecificationSearchCriteria<>(filter);
			result = this.addressRepository.findAll(spec);
		} catch (Exception e) {
			System.out.println(e);
		}

		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());

		result.forEach(address -> {
			System.out.println(address.getName());
		});
	}

	@Test
	public void specificationFindByName() {
		PersonFilterDTO filter = new PersonFilterDTO();
		String name = "Ana";
		filter.setName(name);

		SpecificationSearchCriteria<PersonFilterDTO, Person> spec = new SpecificationSearchCriteria<>(filter);
		List<Person> result = this.personRepository.findAll(spec);

		Assert.assertNotNull(result);

		result.forEach(person -> {
			Assert.assertEquals(name, person.getName());
		});

	}

	@Test
	public void specificationFindByTotal() {
		PersonFilterDTO filter = new PersonFilterDTO();
		Integer total = 12;
		filter.setTotal(total);

		SpecificationSearchCriteria<PersonFilterDTO, Person> spec = new SpecificationSearchCriteria<>(filter);
		List<Person> result = this.personRepository.findAll(spec);

		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());

		result.forEach(person -> {
			Assert.assertEquals(total, person.getTotal());
		});
	}

	@Test
	public void specificationFindByTotalLessThan() {
		PersonFilterLessDTO filter = new PersonFilterLessDTO();
		Integer total = 18;
		filter.setTotal(total);

		SpecificationSearchCriteria<PersonFilterLessDTO, Person> spec = new SpecificationSearchCriteria<>(filter);
		List<Person> result = this.personRepository.findAll(spec);

		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());

		result.forEach(person -> {
			System.out.println(person);
			Assert.assertNotNull(person.getTotal());
			Assert.assertTrue(person.getTotal() < total);
		});
	}
}