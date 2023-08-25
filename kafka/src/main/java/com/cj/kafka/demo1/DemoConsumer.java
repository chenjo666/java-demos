package com.cj.kafka.demo1;

import com.cj.kafka.common.GsonDeserializer;
import com.cj.kafka.common.Message;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

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
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, GsonDeserializer.class.getName());
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        // 设置 JsonDeserializer 的配置参数
        // 3. 构建消费者实例
        KafkaConsumer<String, Message> consumer = new KafkaConsumer<>(properties);
        // 4. 订阅主题
        consumer.subscribe(Collections.singletonList(topic));
        // 5. 循环接收消息
        while (true) {
            ConsumerRecords<String, Message> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, Message> record : records) {
                System.out.println(record.value());
            }
        }
    }
}
