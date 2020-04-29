package com.simplestocking.demo.controllers;

import com.simplestocking.demo.Response;
import com.simplestocking.demo.model.Users;
import com.simplestocking.demo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UsersService usersService;

    @GetMapping
    public ResponseEntity<Response> getAll() {
        Response response = new Response();
        response.setSuccess(true);
        response.setMessage("Success get data");
        response.setData(usersService.findAll());

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") String id) {
        Response response = new Response();
        response.setSuccess(true);
        response.setMessage("Success get data");
        response.setData(usersService.findById(id));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody @Validated Users users) {
        Response response = new Response();
        response.setSuccess(true);
        response.setMessage("Created");
        response.setData(usersService.create(users));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }


}
