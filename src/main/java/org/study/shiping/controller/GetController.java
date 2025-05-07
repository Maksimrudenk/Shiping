package org.study.shiping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.study.shiping.model.Client;
import org.study.shiping.model.Port;
import org.study.shiping.repository.ClientRepository;
import org.study.shiping.repository.OrderRepository;
import org.study.shiping.repository.PortRepository;
import org.study.shiping.repository.RouteRepository;

import java.util.List;

@RestController
public class GetController {

    private final PortRepository pr;
    private final ClientRepository cr;

    public GetController(PortRepository pr, ClientRepository cr) {
        this.pr = pr;
        this.cr = cr;
    }

    @GetMapping("/ports")
    public List<Port> getPorts() {
        return pr.findAll();
    }

    @GetMapping("/clients")
    public List<Client> getClients() {
        return cr.findAll();
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserByName(@RequestParam String username) {
        Client client = cr.findByName(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sender name"));
        return ResponseEntity.ok(client.getId());
    }


}
