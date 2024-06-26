package com.qa.project.presentation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qa.project.business.SellerService;
import com.qa.project.persistence.domain.SellerDomain;
import com.qa.project.business.dto.SellerDTO;

@RestController
@RequestMapping("/seller")
public class SellerController {
    private SellerService service;


    @Autowired
    public SellerController(SellerService service) {
        super();
        this.service = service;
    }

    // CRUD

    // CREATE Mapping
    @PostMapping
    public ResponseEntity<SellerDTO> create(@RequestBody SellerDomain model) {
        return new ResponseEntity<>(this.service.create(model), HttpStatus.CREATED);
    }

    // READ Mapping
    @GetMapping
    public ResponseEntity<List<SellerDTO>> readAll() {
        return ResponseEntity.ok(this.service.readAll());
    }

    // READ by ID
    @GetMapping("/{id}")
    public ResponseEntity<SellerDTO> readOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.readOne(id));
    }

    // UPDATE Mapping
    @PutMapping("/{id}")
    public ResponseEntity<SellerDTO> update(@PathVariable Long id, @RequestBody SellerDomain model) {
        return new ResponseEntity<>(this.service.update(id, model), HttpStatus.ACCEPTED);
    }

    // DELETE Mapping
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.delete(id) ? HttpStatus.NO_CONTENT : HttpStatus.INTERNAL_SERVER_ERROR);
    }
}