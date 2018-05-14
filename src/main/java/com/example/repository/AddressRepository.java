package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.model.Address;

/**
 * Repository {@link Address}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmailcom">Mauricio Garcia</a>
 * @version
 * @sinse 12/05/2018 23:45:12
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>, JpaSpecificationExecutor<Address> {

}