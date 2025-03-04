package com.example.address_book.service;

import com.example.address_book.dto.AddressDTO;
import com.example.address_book.model.Address;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    private final List<Address> addressList = new ArrayList<>();
    private Long idCounter = 1L; // Counter to assign unique IDs

    @Override
    public List<AddressDTO> getAllAddresses() {
        List<AddressDTO> dtoList = new ArrayList<>();
        for (Address address : addressList) {
            dtoList.add(new AddressDTO(address.getName(), address.getCity()));
        }
        return dtoList;
    }

    @Override
    public AddressDTO getAddressById(Long id) {
        for (Address address : addressList) {
            if (address.getId().equals(id)) {
                return new AddressDTO(address.getName(), address.getCity());
            }
        }
        return null;
    }

    @Override
    public AddressDTO addAddress(AddressDTO addressDTO) {
        Address newAddress = new Address(idCounter++, addressDTO.getName(), addressDTO.getCity());
        addressList.add(newAddress);
        return addressDTO;
    }

    @Override
    public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
        for (Address address : addressList) {
            if (address.getId().equals(id)) {
                address.setName(addressDTO.getName());
                address.setCity(addressDTO.getCity());
                return addressDTO;
            }
        }
        return null;
    }

    @Override
    public void deleteAddress(Long id) {
        addressList.removeIf(address -> address.getId().equals(id));
    }
}
