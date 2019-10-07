package com.task.testTask.services;

import com.task.testTask.entities.Client;
import com.task.testTask.models.ClientModel;

import java.util.List;

public interface ClientService {

    Client createClient(Client client);

    List<ClientModel> getAllClients();

    Client getClient(String clientCode);


    void deleteClient(String clientCode);

    Client updateClient(String clientCode, Client client);
}
