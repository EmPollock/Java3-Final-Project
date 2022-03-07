package com.pollock.support;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ticket {
    private String customerName;
    private String subject;
    private String body;
    private Map<String, Attachment> attachments;

    public final String DEFAULT_STR = "Undefined";

    public Ticket() {
        this.customerName = DEFAULT_STR;
        this.subject = DEFAULT_STR;
        this.body = DEFAULT_STR;
        this.attachments = new LinkedHashMap<>();
    }
/*
    public Ticket(String customerName, String subject, String body) {
        validateCustomerName(customerName);
        validateSubject(subject);
        validateBody(body);
        this.customerName = customerName;
        this.subject = subject;
        this.body = body;
    }
*/
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        validateCustomerName(customerName);
        this.customerName = customerName;
    }

    private void validateCustomerName(String customerName){
        if(customerName == null || customerName.length() == 0){
            throw new IllegalArgumentException("Name required");
        }
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        validateSubject(subject);
        this.subject = subject;
    }

    private void validateSubject(String subject){
        if(subject == null || subject.length() == 0){
            throw new IllegalArgumentException("Subject required");
        }
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        validateBody(body);
        this.body = body;
    }

    private void validateBody(String body){
        if(body == null || body.length() == 0){
            throw new IllegalArgumentException("Name required");
        }
    }

    public Attachment getAttachment(String name){
        return attachments.get(name);
    }

    public Collection<Attachment> getAttachments(){
        return attachments.values();
    }

    public void addAttachment(Attachment attachment){
        attachments.put(attachment.getName(), attachment);
    }

    public int getNumberOfAttachments(){
        return attachments.size();
    }
}
