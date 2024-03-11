package com.example.translate;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MXMessage")
public class MXMessage {
    private String header;
    private String body;

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
