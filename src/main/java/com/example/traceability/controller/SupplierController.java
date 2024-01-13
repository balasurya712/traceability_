package com.example.traceability.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.traceability.models.Supplier;
import com.example.traceability.service.SupplierServiceInterface;

@RestController
@RequestMapping("supplier")
public class SupplierController {

    @Autowired
    private SupplierServiceInterface service;

    // write crud operations here
    @GetMapping("/hello")
    public String get() {
        return "Hello World!";
    }

    // create and save the Supplier
    @PostMapping("/save")
    public ResponseEntity<Supplier> insertSupplier(@RequestBody Supplier supplier) {
        try {

            return new ResponseEntity<Supplier>(service.saveData(supplier), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Supplier>(HttpStatus.BAD_REQUEST);
        }
    }

    // select all Supplier
    // @PreAuthorize("hasAuthority(\"ADMIN\")")
    @GetMapping("/select/all")
    public ResponseEntity<List<Supplier>> selectAll() {
        try {
            return new ResponseEntity<List<Supplier>>(service.getAllSupplier(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // select Supplier by id;
    @PreAuthorize("hasRole('admin')")
    @GetMapping("/select/{id}")
    public ResponseEntity<Supplier> selectById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<Supplier>(service.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // update the Supplier;
    @PutMapping("update")
    public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier) {
        try {
            return new ResponseEntity<Supplier>(service.updateData(supplier), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Supplier>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable String id) {
        Boolean result = false;
        try {
            result = service.deleteData(id);
            if (result) {
                return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
            } else
                return new ResponseEntity<String>("Id not found", HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Internal error", HttpStatus.BAD_REQUEST);
        }
    }

}
