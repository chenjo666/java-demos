package com.cj.kafka.producer;

import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;

public class ProducerAcksRetries {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // 配置应答级别为 1，仅等待 leader 副本接收完消息
        properties.put(ProducerConfig.ACKS_CONFIG, "1");
        // 配置重试次数为 5，失败则进行重试
        properties.put(ProducerConfig.RETRIES_CONFIG, 5);
    }
}
