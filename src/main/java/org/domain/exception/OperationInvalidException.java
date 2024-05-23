package org.domain.exception;

public class OperationInvalidException extends RuntimeException {
    public OperationInvalidException(String message) {
        super(message);
    }
}
