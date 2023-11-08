package org.sandbox.fp.utils;

public class Message {

    private String type;
    private String code;
    private String message;
    private String rootCause;

    public Message(String type, String code, String message, String rootCause) {
        this.type = type;
        this.code = code;
        this.message = message;
        this.rootCause = rootCause;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getRootCause() {
        return rootCause;
    }
}
