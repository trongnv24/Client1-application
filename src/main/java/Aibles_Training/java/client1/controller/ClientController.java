package Aibles_Training.java.client1.controller;

import Aibles_Training.java.client1.dto.request.ClientRequest;
import Aibles_Training.java.client1.dto.response.ClientResponse;
import Aibles_Training.java.client1.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/clients")
@Slf4j
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse create(@RequestBody ClientRequest request) {
        log.info(" === Start api create new client === ");
        log.info(" === Request Body : {} ", request);
        ClientResponse response = service.create(request);
        log.info(" === Finish api create new client, Client Id {} : === ", response.getId());
        return response;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponse getById(@PathVariable("id") String id) {
        log.info(" === Start api getById client === ");
        log.info(" === String id {} : === ", id);
        ClientResponse response = service.getById(id);
        log.info(" === Finish api getById client, Client Id : {}  ", response.getId());
        return response;
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  ClientResponse update(@RequestBody ClientRequest request, @PathVariable("id") String id ){
        log.info(" === Start api update client === ");
        log.info(" === Request Body : {}, String id : {} === ", request, id);
        ClientResponse response = service.update(request, id);
        log.info( " === Finish api update client, Client Id : {} === ", response.getId());
        return response;
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") String id) {
        log.info(" === Start api deleteById client === ");
        log.info(" === String id {} : === ", id);
        log.info(" === Finish api deleteById client, Client Id : {} === ");
        service.deleteById(id);
    }
}
