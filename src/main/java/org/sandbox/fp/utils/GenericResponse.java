package org.sandbox.fp.utils;

import java.util.List;

public class GenericResponse<T> {

    private List<Message> messages;
    private T result;

    public GenericResponse(List<Message> messages, T result) {
        this.messages = messages;
        this.result = result;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public T getResult() {
        return result;
    }
}
