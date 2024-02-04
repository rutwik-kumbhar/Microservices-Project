package com.example.exceptions;

public class ResourcesNotFoundException extends  RuntimeException{


    public ResourcesNotFoundException() {
        super("Resources Not Found");
    }

    public ResourcesNotFoundException(String message) {
        super(message);
    }
}
