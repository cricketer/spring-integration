package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class StringProducer {

    private final String prefix;
    public StringProducer(@Value("producer.prefix") String prefix){
        this.prefix = prefix;
    }

    public List<String> getNumberOfStrings(int number) {
        List<String> s = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            s.add(String.format("%s%d", this.prefix, i));
        }
        return Collections.unmodifiableList(s);
    }
}
