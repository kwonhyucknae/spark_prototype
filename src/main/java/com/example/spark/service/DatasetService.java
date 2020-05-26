package com.example.spark.service;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.*;
import org.springframework.stereotype.Service;

@Service
public class DatasetService {

    private SparkSession sparkSession;
    DatasetService(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    public void sparkProcess() {
//        Encoder<FrequentInquiry> frequentInquiryEncoder = Encoders.bean(FrequentInquiry.class);


        Dataset<String> textP = sparkSession.read().textFile("src/main/resources/data/test.jsonl");
        Dataset<Row> jsonFile = sparkSession.read().json("src/main/resources/data/test.jsonl");
        Dataset<Row> jsonMultiLine = sparkSession.read().option("multiline", true).json("src/main/resources/data/test.jsonl");


        jsonMultiLine.printSchema();
        jsonMultiLine.select();

        jsonMultiLine.select("name", "date").distinct().show();


//        JavaRDD<FrequentInquiry> test4 = sparkSession.read().option("multiline", true).json("src/main/resources/data/test.jsonl").javaRDD().map(line -> {
//            System.out.println("aa" + line);
//            FrequentInquiry fq = new FrequentInquiry();
//            BaseInformation baseInformation = new BaseInformation();
////            baseInformation.setDumpId();
//
//
//            return fq;
//        });
    }
}
