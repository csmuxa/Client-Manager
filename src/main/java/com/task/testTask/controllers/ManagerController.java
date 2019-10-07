package com.task.testTask.controllers;

import com.task.testTask.entities.Manager;
import com.task.testTask.models.ClientsListModel;
import com.task.testTask.models.ManagerModel;
import com.task.testTask.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("managers")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @GetMapping
    public List<ManagerModel> getManagers(){
       return managerService.getAllManagers();
    }

    @GetMapping(path = "/clients/{id}")
    public List<ClientsListModel> getAllCientsOfManager(@PathVariable long id){
        return managerService.getAllClientsOfManager(id);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Manager createManager(@RequestBody Manager manager){
        return managerService.createManager(manager);
    }

    @PutMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Manager updateManager(@RequestBody Manager manager,@PathVariable long id){
        return managerService.updateManager(id,manager);
    }

    @DeleteMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity deleteManager(@PathVariable long id){
            managerService.deleteManager(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

