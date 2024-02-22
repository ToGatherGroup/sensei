package com.togather.sensei.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException (String message) {
        super(String.format(message));
    }
}
