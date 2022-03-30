package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StringService {

    private final StringProducer stringProducer;
    private final Integer maxStrings;

    public StringService(StringProducer stringProducer, @Value("${service.max.strings}") Integer maxStrings) {
        this.stringProducer = stringProducer;
        this.maxStrings = maxStrings;
    }

    public List<String> getStrings() {
        return this.stringProducer.getNumberOfStrings(this.maxStrings);
    }

}
