package com.cj.kafka.demo0;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class DemoConsumer {
    private static final String brokerList = "localhost:9092";
    private static final String topic = "topic-demo";
    private static final String groupId = "group.demo";
    public static void main(String[] args) {
        // 1. 配置消费者参数
        Properties properties = new Properties();
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("bootstrap.servers", brokerList);
        // 2. 设置消费者组
        properties.put("group.id", groupId);
        // 3. 构建消费者实例
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        // 4. 订阅主题
        consumer.subscribe(Collections.singletonList(topic));
        // 5. 循环接收消息
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.value());
            }
        }
    }
}
