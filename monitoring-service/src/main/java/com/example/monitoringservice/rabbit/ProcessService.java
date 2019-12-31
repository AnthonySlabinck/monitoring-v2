package com.example.monitoringservice.rabbit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProcessService {

    private final QueueService queueService;

    public ProcessService(QueueService queueService) {
        this.queueService = queueService;
    }

    public Flux<Process> getProcesses() {
        return queueService.getQueues()
                .collectMultimap(q -> StringUtils.removeEnd(q.getName(), Queue.DLQ_POSTFIX))
                .flatMapIterable(map -> map.entrySet())
                .map(entry -> {
                    String id = entry.getKey();
                    long messagesPending = 0;
                    long messagesFailed = 0;
                    for (Queue queue : entry.getValue()) {
                        if (queue.isDeadLetterQueue()) {
                            messagesFailed += queue.getTotalMessages();
                        } else {
                            messagesPending += queue.getTotalMessages();
                        }
                    }
                    return Process.of(id, messagesPending, messagesFailed);
                });
    }
}
