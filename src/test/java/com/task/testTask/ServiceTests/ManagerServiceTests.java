package com.task.testTask.ServiceTests;

import com.task.testTask.entities.Client;
import com.task.testTask.entities.Manager;
import com.task.testTask.exceptions.ManagerException;
import com.task.testTask.repositories.ManagerRepository;
import com.task.testTask.services.serviceImpls.ManagerServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTests {

    @InjectMocks
    ManagerServiceImpl service;

    @Mock
    ManagerRepository managerRepository;

    Client client=new Client();
    Manager manager=new Manager();
    String clientCode="96d9a8768y0a";
    String fullName="Oleg Ostapovich Mixaylov";
    String address="New York,street 3A";
    String phoneNumber="+994505523333";
    boolean status=true;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        manager.setFullName(fullName);
        manager.setPhoneNumber(phoneNumber);
        manager.setId(1);
        client.setClientCode(clientCode);
        client.setStatus(status);
        client.setAddress(address);
        client.setFullName(fullName);
        client.setManager(manager);
    }


    @Test
    public void deleteManager(){
        when(managerRepository.findById(anyLong())).thenReturn(manager);

        assertThrows(ManagerException.class,
                () -> {
                    service.deleteManager(1);
                }
        );
    }





}
