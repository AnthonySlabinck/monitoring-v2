package com.example.monitoringgateway.rabbit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/processes")
public class ProcessController {

    private final ProcessClient processClient;

    public ProcessController(ProcessClient processClient) {
        this.processClient = processClient;
    }

    @GetMapping
    public List<Process> getProcesses() {
        return processClient.getProcesses();
    }
}
