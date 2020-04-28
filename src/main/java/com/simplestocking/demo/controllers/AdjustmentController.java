package com.simplestocking.demo.controllers;

import com.simplestocking.demo.Response;
import com.simplestocking.demo.model.Adjustment;
import com.simplestocking.demo.services.AdjustmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("adjustment")
public class AdjustmentController {

    @Autowired
    AdjustmentService adjustmentService;

    @GetMapping
    public ResponseEntity<Response> getAll() {
        Response response = new Response();
        response.setMessage("Success Get Data");
        response.setSuccess(true);
        response.setData(adjustmentService.findAll());

        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody @Validated Adjustment adjustment) {
        Response response = new Response();
        response.setMessage("Success Save Data");
        response.setSuccess(true);
        response.setData(adjustmentService.create(adjustment));

        return ResponseEntity
                .status(201)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") String id) {
        Response response = new Response();
        response.setMessage("Success Save Data");
        response.setSuccess(true);
        response.setData(adjustmentService.findById(id));

        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

}
