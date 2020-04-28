package com.simplestocking.demo.controllers;

import com.simplestocking.demo.Response;
import com.simplestocking.demo.model.Material;
import com.simplestocking.demo.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("material")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @GetMapping
    public ResponseEntity<Response> findAll() {
        Response response = new Response();
        response.setSuccess(true);
        response.setMessage("Success Call Method");

        response.setData(materialService.findAll());

        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Response> findOneData(@PathVariable("id") String id) {

        Response response = new Response();
        response.setMessage("Success Find Data");
        response.setSuccess(true);
        response.setData(materialService.findById(id));

        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }


    @PostMapping
    public ResponseEntity<Response> create(@RequestBody @Validated Material material) {
        Response response = new Response();

        response.setSuccess(true);
        response.setMessage("Success Created!");
        response.setData(materialService.create(material));

        return ResponseEntity
                .status(201)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

}
