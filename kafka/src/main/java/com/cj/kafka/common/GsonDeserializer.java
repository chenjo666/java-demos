package com.cj.kafka.common;

import com.google.gson.Gson;
import org.apache.kafka.common.serialization.Deserializer;

public class GsonDeserializer implements Deserializer<Message> {
    @Override
    public Message deserialize(String s, byte[] bytes) {
        return new Gson().fromJson(new String(bytes), Message.class);
    }
}