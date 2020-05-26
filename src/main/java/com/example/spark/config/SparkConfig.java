package com.example.spark.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {

    @Value("${spark.app.name}")
    private String appName;
    @Value("${spark.master}")
    private String masterUri;

    @Bean
    public SparkConf conf() {
        return new SparkConf().setAppName(appName).setMaster(masterUri);
    }

    @Bean
    public JavaSparkContext sc() {
        return new JavaSparkContext(conf());
    }

    @Bean
    public SparkSession sparkSession() {


        return SparkSession
                .builder()
                .sparkContext(sc().sc())
                .appName(appName)
                .master(masterUri)
                .config("spark.sql.warehouse.dir", "jdbc:hive2://zk-etcd1.bdp.bdata.ai:2181,zk-etcd2.bdp.bdata.ai:2181,zk-etcd3.bdp.bdata.ai:2181/default;password=irteam;principal=hive/nhk321@C3.NAVER.COM;serviceDiscoveryMode=zooKeeper;user=irteam;zooKeeperNamespace=hiveserver2-batch")
                .config("hive.metastore.uris", "thrift://ranger-hms-oozie1.bdp.bdata.ai:9083,thrift://ranger-hms-oozie2.bdp.bdata.ai:9083")
                .enableHiveSupport()
                .getOrCreate();
    }
}
