package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {

    public final StringService barCom;

    public StringController(StringService barCom) {
        this.barCom = barCom;
    }

    @GetMapping("/strings")
    public ResponseDto getStrings() {
        return new ResponseDto(barCom.getStrings());
    }

}
