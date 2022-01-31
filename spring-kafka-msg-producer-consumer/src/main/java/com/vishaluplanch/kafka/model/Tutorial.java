package com.vishaluplanch.kafka.model;

public class Tutorial {

    String topicName;
    String publisher;
    String location;
    String type;
    String topicId;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "Tutorial{" +
                "topicName='" + topicName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", topicId='" + topicId + '\'' +
                '}';
    }
}
