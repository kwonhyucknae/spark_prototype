package com.example.spark.controller;

import com.example.spark.service.DatasetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SparkController {

    private DatasetService datasetService;

    SparkController(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    @GetMapping("/sparkProcess")
    public String sparkProcess() {

        datasetService.sparkProcess();

        return null;
    }

}
