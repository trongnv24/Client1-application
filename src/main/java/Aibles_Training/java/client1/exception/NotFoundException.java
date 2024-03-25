package Aibles_Training.java.client1.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private String message;
    private String id;
    private String objectName;
    public NotFoundException(String message, String id , String objectName) {
        this.id = id;
        this.message = message;
        this.objectName = objectName;
    }
}
