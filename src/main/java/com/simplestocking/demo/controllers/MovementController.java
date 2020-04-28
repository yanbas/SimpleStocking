package com.simplestocking.demo.controllers;

import com.simplestocking.demo.Response;
import com.simplestocking.demo.model.Movement;
import com.simplestocking.demo.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("movement")
@RestController
public class MovementController {

    @Autowired
    MovementService movementService;

    @GetMapping
    public ResponseEntity<Response> getAll() {

        Response response = new Response();
        response.setSuccess(true);
        response.setMessage("Success Get Data!");
        response.setData(movementService.findAll());

        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") String id) {
        Response response = new Response();
        response.setSuccess(true);
        response.setMessage("Success Get Data!");
        response.setData(movementService.findById(id));

        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);

    }

    @PostMapping()
    public ResponseEntity<Response> create(@RequestBody @Validated Movement movement) {
        Response response = new Response();
        response.setSuccess(true);
        response.setMessage("Success Get Data!");
        response.setData(movementService.create(movement));

        return ResponseEntity
                .status(201)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }


}
