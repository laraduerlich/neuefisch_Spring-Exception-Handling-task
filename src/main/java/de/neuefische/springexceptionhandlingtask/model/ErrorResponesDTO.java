package de.neuefische.springexceptionhandlingtask.model;

public class ErrorResponesDTO {

    private String message;

    public ErrorResponesDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
