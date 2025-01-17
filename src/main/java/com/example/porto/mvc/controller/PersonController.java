package com.example.porto.mvc.controller;

import com.example.porto.mvc.model.Person;
import com.example.porto.mvc.service.PersonService;
import com.example.porto.util.response.ApiResponse;
import com.example.porto.util.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person/")
public class PersonController {

    @Autowired
    private PersonService usrSvc;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("create-person")
    public ResponseEntity<ApiResponse> createUser(@RequestBody Person person) {
        try {
            String response = usrSvc.createPerson(person);
            return ResponseHandler.success("Successfully", response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.error("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("get-all-person")
    public ResponseEntity<ApiResponse> getAllUser() {
        try {
            List<Person> response = usrSvc.getAllPerson();
            return ResponseHandler.success("Successfully", response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.error("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("get-person-by-id")
    public ResponseEntity<ApiResponse> findById(@RequestBody Person person) {
        try {
            Optional<Person> response = usrSvc.findById(person.getId());
            return ResponseHandler.success("Successfully", response.get(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.error("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("delete-person-by-id")
    public ResponseEntity<ApiResponse> deleteById(@RequestBody Person person) {
        try {
            String response = usrSvc.deletePerson(person.getId());
            return ResponseHandler.success("Successfully", response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.error("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("update-person-by-id")
    public ResponseEntity<ApiResponse> updateById(@RequestBody Person person) {
        try {
            String response = usrSvc.updatePerson(person);
            return ResponseHandler.success("Successfully", response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.error("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
