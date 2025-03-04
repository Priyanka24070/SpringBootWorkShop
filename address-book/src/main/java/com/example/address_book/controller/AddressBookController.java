package com.example.address_book.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    @GetMapping
    public ResponseEntity<String> getAllAddresses() {
        return ResponseEntity.ok("Returning all addresses");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAddressById(@PathVariable Long id) {
        return ResponseEntity.ok("Returning address for ID: " + id);
    }

    @PostMapping
    public ResponseEntity<String> addAddress(@RequestBody String address) {
        return ResponseEntity.ok("Address added: " + address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable Long id, @RequestBody String address) {
        return ResponseEntity.ok("Address updated for ID " + id + ": " + address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        return ResponseEntity.ok("Address deleted for ID: " + id);
    }
}
