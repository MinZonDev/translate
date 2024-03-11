package com.example.translate;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MTMessage")
public class MTMessage {
    private String header;
    private String body;

    public MTMessage() {

    }

    public MTMessage(String message) {
        this.body = message;
    }

    @XmlElement(name = "Header")
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @XmlElement(name = "Body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
