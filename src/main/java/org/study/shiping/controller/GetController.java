package org.study.shiping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.study.shiping.model.Port;
import org.study.shiping.repository.OrderRepository;
import org.study.shiping.repository.PortRepository;
import org.study.shiping.repository.RouteRepository;

import java.util.List;

@RestController
public class GetController {

//    @Autowired
//    private RouteRepository rr;
    private final PortRepository pr;

    public GetController(PortRepository pr) {
        this.pr = pr;
    }

    @GetMapping("/ports")
    public List<Port> getPorts() {
        return pr.findAll();
    }

}
