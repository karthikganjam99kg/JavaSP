package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.XMLToJsonService;


@RestController
@RequestMapping("/api/conversion")
public class ConversionController {

    @Autowired
    private XMLToJsonService xmlToJsonService;

    @PostMapping("/xml-to-json")
    public ResponseEntity<String> convertXmlToJson(@RequestBody String xmlContent) {
        try {
            String jsonResult = xmlToJsonService.convertXmlToJson(xmlContent);
            return ResponseEntity.ok(jsonResult);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error parsing XML: " + e.getMessage());
        }
    }
}