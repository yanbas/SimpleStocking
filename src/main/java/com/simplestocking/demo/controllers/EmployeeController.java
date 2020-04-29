package com.simplestocking.demo.controllers;

import com.simplestocking.demo.Response;
import com.simplestocking.demo.model.Employee;
import com.simplestocking.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Response> getAll() {
        Response response = new Response();
        response.setSuccess(true);
        response.setMessage("success get data");

        response.setData(employeeService.findAll());

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody @Validated Employee employee) {
        Response response  = new Response();
        response.setMessage("Created!");
        response.setSuccess(true);
        response.setData(employeeService.create(employee));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") int id) {
        Response response  = new Response();
        response.setMessage("success get data!");
        response.setSuccess(true);
        response.setData(employeeService.findById(id));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") int id) {
        Response response  = new Response();
        response.setMessage("success delete data!");
        response.setSuccess(true);
        employeeService.delete(id);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PutMapping
    public ResponseEntity<Response> create(@PathVariable("id") int id, @RequestBody @Validated Employee employee) {
        Response response  = new Response();
        response.setMessage("Created!");
        response.setSuccess(true);
        response.setData(employeeService.update(employee));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }


}
