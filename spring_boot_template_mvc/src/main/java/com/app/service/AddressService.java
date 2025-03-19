package com.app.service;

import java.util.List;

import com.app.Pojo.Address;
import com.app.Pojo.User;

public interface AddressService {
	
	Address addAddress(Address address);
	
	Address updateAddress(Address address);
	
	Address getAddressById(int addressId);

}
