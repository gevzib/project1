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

import com.qa.project.business.PropertyService;
import com.qa.project.persistence.domain.PropertyDomain;
import com.qa.project.business.dto.PropertyDTO;


@RestController
@RequestMapping("/property")
pulic class PropertyController {
    private PropertyService service;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        super();
        this.service = service;
    }

    // READ Mapping
    @GetMapping
    public ResponseEntity<List<PropertyDTO>> readAll() {
        return ResponseEntity.ok(this.service.readAll());
    }

    // READ Mapping by ID
    @GetMapping("/{id}")
    public ResponseEntity<PropertyDTO> readOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.readOne(id));
    }

    // CREATE Mapping
    @PostMapping
    public ResponseEntity<PropertyDTO> create(@RequestBody PropertyDomain model) {
        return new ResponseEntity<>(this.service.create(model), HttpStatus.CREATED);
    }

    // UPDATE Mapping
    @PutMapping("/{id}")
    public ResponseEntity<PropertyDTO> update(@PathVariable Long id, @RequestBody PropertyDomain model) {
        return new ResponseEntity<>(this.service.update(id, model), HttpStatus.ACCEPTED);
    }

    // DELETE Mapping
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.delete(id) ? HttpStatus.NO_CONTENT : HttpStatus.INTERNAL_SERVER_ERROR);
    }
}