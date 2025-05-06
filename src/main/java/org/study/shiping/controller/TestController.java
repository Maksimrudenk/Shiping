package org.study.shiping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.study.shiping.model.Port;
import org.study.shiping.repository.PortRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private PortRepository portRepository;

    @GetMapping("/ports")
    public List<Port> getPorts(){
        List<Port> ports = new ArrayList<Port>();
        ports = portRepository.findAll();
        System.out.println("Ports:");
        ports.forEach(System.out::println);
        return ports;
    }

}
