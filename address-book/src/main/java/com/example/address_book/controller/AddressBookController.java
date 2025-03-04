package com.example.address_book.controller;

import com.example.address_book.dto.AddressDTO;
import com.example.address_book.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    //  GET all addresses
    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        return ResponseEntity.ok(addressBookService.getAllAddresses());
    }

    // GET address by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id) {
        AddressDTO addressDTO = addressBookService.getAddressById(id);
        return (addressDTO != null) ? ResponseEntity.ok(addressDTO) : ResponseEntity.notFound().build();
    }

    // POST (Add a new address)
    @PostMapping
    public ResponseEntity<AddressDTO> addAddress(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(addressBookService.addAddress(addressDTO));
    }

    //  PUT (Update an address)
    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable Long id, @RequestBody AddressDTO addressDTO) {
        AddressDTO updatedAddress = addressBookService.updateAddress(id, addressDTO);
        return (updatedAddress != null) ? ResponseEntity.ok(updatedAddress) : ResponseEntity.notFound().build();
    }

    // DELETE an address
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        addressBookService.deleteAddress(id);
        return ResponseEntity.ok("Address deleted successfully.");
    }
}
