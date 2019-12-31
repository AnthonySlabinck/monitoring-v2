package com.example.monitoringservice.rabbit;

import com.rabbitmq.http.client.ReactorNettyClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class QueueService {

    private final ReactorNettyClient client;

    public QueueService(ReactorNettyClient client) {
        this.client = client;
    }

    public Flux<Queue> getQueues() {
        return client.getQueues()
                .map(q -> Queue.of(q.getVhost(), q.getName(), q.getTotalMessages(), q.getConsumerCount()));
    }
}
