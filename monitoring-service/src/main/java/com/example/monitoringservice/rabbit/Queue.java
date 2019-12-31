package com.example.monitoringservice.rabbit;

import lombok.Value;

@Value(staticConstructor = "of")
public class Queue {

    public static final String DLQ_POSTFIX = ".dlq";

    private final String virtualHost;
    private final String name;
    private final long totalMessages;
    private final long consumers;

    public boolean isDeadLetterQueue() {
        return name.endsWith(DLQ_POSTFIX);
    }
}
