package com.example.monitoringgateway.rabbit;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "processes", url = "http://localhost:8080")
public interface ProcessClient {

    @GetMapping("/processes")
    List<Process> getProcesses();
}
