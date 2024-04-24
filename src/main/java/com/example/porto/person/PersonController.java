package com.example.porto.person;

import com.example.porto.util.response.ApiResponse;
import com.example.porto.util.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class PersonController {

    @Autowired
    private PersonService usrSvc;

    @PostMapping("create-person")
    public ResponseEntity<ApiResponse> createUser(@RequestBody Person person) {
        try {
            String response = usrSvc.createPerson(person);
            return ResponseHandler.success("Successfully", response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.error("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("get-all-person")
    public ResponseEntity<ApiResponse> getAllUser() {
        try {
            List<Person> response = usrSvc.getAllPerson();
            return ResponseHandler.success("Successfully", response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.error("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("get-person-by-id")
    public ResponseEntity<ApiResponse> findById(@RequestBody Person person) {
        try {
            Optional<Person> response = usrSvc.findById(person.getId());
            return ResponseHandler.success("Successfully", response.get(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.error("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("delete-person-by-id")
    public ResponseEntity<ApiResponse> deleteById(@RequestBody Person person) {
        try {
            String response = usrSvc.deletePerson(person.getId());
            return ResponseHandler.success("Successfully", response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.error("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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
