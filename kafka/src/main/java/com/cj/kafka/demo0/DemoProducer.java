package com.cj.kafka.demo0;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class DemoProducer {
    private static final String brokerList = "localhost:9092";
    private static final String topic = "topic-demo";

    public static void main(String[] args) {
        // 1. 配置生产者参数
        Properties properties = new Properties();
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("bootstrap.servers", brokerList);
        // 2. 配置生产者实例
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        // 3. 构建生产者消息
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "hello-kafka");
        // 4. 发送生产者消息
        producer.send(record);
        // 5. 关闭生产者实例
        producer.close();
    }
}
