package com.cj.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerTransaction {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // 开启幂等性
        properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        // 开启事务 id
        properties.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "test-transaction-001");
        // 配置生产者
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        // 初始化事务
        producer.initTransactions();
        // 开启事务
        producer.beginTransaction();
        try {
            // 发送消息
            producer.send(new ProducerRecord<>("TOPIC","hello"));
            // 正常发送，提交事务
            producer.commitTransaction();
        } catch (Exception e) {
            // 异常发送，关闭事务
            producer.abortTransaction();
        }
    }
}
