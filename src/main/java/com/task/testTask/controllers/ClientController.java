package com.task.testTask.controllers;

import com.task.testTask.entities.Client;
import com.task.testTask.models.ClientModel;
import com.task.testTask.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public List<ClientModel> getAllClients(){
        return  clientService.getAllClients();
    }

    @GetMapping(path = "/{clientCode}" ,produces = {MediaType.APPLICATION_JSON_VALUE})
    public Client getClient(@PathVariable String clientCode){
        return clientService.getClient(clientCode);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }

    @PutMapping(path = "/{clientCode}",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Client updateClient(@RequestBody Client client,@PathVariable String clientCode){
        return clientService.updateClient(clientCode,client);
    }

    @DeleteMapping(path = "/{clientCode}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteClient(@PathVariable String clientCode){
        clientService.deleteClient(clientCode);
        return new ResponseEntity(HttpStatus.OK);
    }
}
