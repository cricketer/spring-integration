package com.example.demo;

import java.util.List;
import java.util.Objects;

public record ResponseDto(List<String> detail) {
    public ResponseDto {
        Objects.requireNonNull(detail);
    }
}
