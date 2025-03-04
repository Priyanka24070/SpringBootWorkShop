package com.example.address_book.service;

import com.example.address_book.dto.AddressDTO;
import java.util.List;

public interface IAddressBookService {
    List<AddressDTO> getAllAddresses();
    AddressDTO getAddressById(Long id);
    AddressDTO addAddress(AddressDTO addressDTO);
    AddressDTO updateAddress(Long id, AddressDTO addressDTO);
    void deleteAddress(Long id);
}
