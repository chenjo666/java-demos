package com.cj.kafka.common;

import com.google.gson.Gson;
import org.apache.kafka.common.serialization.Serializer;

public class GsonSerializer implements Serializer<Message> {
    @Override
    public byte[] serialize(String s, Message message) {
        return new Gson().toJson(message).getBytes();
    }
}