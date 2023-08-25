package com.cj.kafka.syn;

import com.cj.kafka.common.GsonSerializer;
import com.cj.kafka.common.Message;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class DemoProducer {
    private static final String brokerList = "localhost:9092";
    private static final String topic = "topic-demo";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. 配置生产者参数
        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GsonSerializer.class.getName());
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        // 2. 配置生产者实例
        KafkaProducer<String, Message> producer = new KafkaProducer<>(properties);
        // 3. 构建生产者消息
        Message message = Message.builder()
                .code(200)
                .msg("hello")
                .data("good bye")
                .build();
        ProducerRecord<String, Message> record = new ProducerRecord<>(topic, message);
        // 4. 发送生产者消息
        RecordMetadata recordMetadata = producer.send(record).get();
        // 5. 关闭生产者实例
        producer.close();
    }

}
