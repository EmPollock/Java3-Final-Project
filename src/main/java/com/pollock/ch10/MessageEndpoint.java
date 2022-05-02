package com.pollock.ch10;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(
        value = "/ch10/endpoint",
        encoders = {MessageEncoder.class},
        decoders = {MessageDecoder.class}
)
public class MessageEndpoint {
    private static final Set<Session> subscribers = Collections.synchronizedSet(new HashSet<Session>());

    public void onOpen(Session session){
        subscribers.add(session);
    }

    public void onMessage(Message message, Session session) throws EncodeException, IOException {
        for(Session sub : subscribers){
            if(!sub.equals(session)) {
                sub.getBasicRemote().sendObject(message);
            }
        }
    }

    public void onClose(Session session){
        subscribers.remove(session);
    }

    public void onError(Throwable throwable){
        System.err.println("ERROR: " + throwable.getMessage());
    }
}
