package com.example.address_book.controller;

import com.example.address_book.dto.AddressDTO;
import com.example.address_book.model.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    private List<Address> addressList = new ArrayList<>();
    private Long idCounter = 1L; // Counter to assign unique IDs

    //  GET all addresses
    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        List<AddressDTO> dtoList = new ArrayList<>();
        for (Address address : addressList) {
            dtoList.add(new AddressDTO(address.getName(), address.getCity()));
        }
        return ResponseEntity.ok(dtoList);
    }

    // GET address by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id) {
        for (Address address : addressList) {
            if (address.getId().equals(id)) {
                return ResponseEntity.ok(new AddressDTO(address.getName(), address.getCity()));
            }
        }
        return ResponseEntity.notFound().build();
    }

    //  POST (Add a new address)
    @PostMapping
    public ResponseEntity<AddressDTO> addAddress(@RequestBody AddressDTO addressDTO) {
        Address newAddress = new Address(idCounter++, addressDTO.getName(), addressDTO.getCity());
        addressList.add(newAddress);
        return ResponseEntity.ok(addressDTO);
    }
}
