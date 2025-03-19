package com.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Pojo.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

}
