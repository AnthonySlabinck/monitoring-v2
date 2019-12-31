package com.example.monitoringservice.rabbit;

import lombok.Value;

@Value(staticConstructor = "of")
public class Process {

    private final String id;
    private final long pendingMessages;
    private final long failedMessages;
}
