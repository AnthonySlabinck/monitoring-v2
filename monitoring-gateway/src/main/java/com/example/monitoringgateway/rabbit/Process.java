package com.example.monitoringgateway.rabbit;

import lombok.Value;

@Value(staticConstructor = "of")
public class Process {

    private String id;
    private long pendingMessages;
    private long failedMessages;
}
