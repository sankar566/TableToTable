package com.youkas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youkas.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{

}
