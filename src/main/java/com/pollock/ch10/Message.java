package com.pollock.ch10;

import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.io.StringWriter;

public class Message {
    private JsonObject json;

    public Message(JsonObject json){
        this.json = json;
    }

    public void setJson(JsonObject json){
        this.json = json;
    }

    @Override
    public String toString(){
        StringWriter writer = new StringWriter();
        Json.createWriter(writer).write(json);
        return writer.toString();
    }
}
