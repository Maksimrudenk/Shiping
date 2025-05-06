package org.study.shiping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.study.shiping.model.Port;
import org.study.shiping.repository.PortRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private PortRepository portRepository;

    @GetMapping("/test")
    public List<Port> getPorts(){
        List<Port> ports = portRepository.findAll();
        System.out.println("Ports:");
        ports.forEach(p -> System.out.println(p.getClass() + ": " + p.getName()));
        return ports;
    }

    @GetMapping("/check")
    public Object check() {
        return Map.of("status", "OK");
    }


}
