package com.example.spark.service;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class HiveService {

    public void hiveConnection() throws Exception {


        try{
            Class.forName("org.apache.hive.jdbc.HiveDriver");
        } catch (Exception e) {

        }
//
        //하둡 설정 로딩. CLASSPATH 에서 core-site.xml hdfs-site.xml 등의 하둡설정을 읽는다
        Configuration conf = new Configuration();
        conf.set("hadoop.security.authentication", "Kerberos");
        //Set the static configuration for UGI.
        UserGroupInformation.setConfiguration(conf);

        //현재 로그인(커버러스 인증)한 유저명
        String username = UserGroupInformation.getCurrentUser().getShortUserName();

        System.out.println(username);


        Connection con = DriverManager.getConnection("jdbcUrl", "", "");
        Statement stmt = con.createStatement();
        String sql = "show databases";
        System.out.println("Running: " + sql);
    }

}
