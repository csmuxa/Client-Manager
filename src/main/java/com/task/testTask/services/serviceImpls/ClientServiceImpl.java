package com.task.testTask.services.serviceImpls;

import com.task.testTask.entities.Client;
import com.task.testTask.entities.Manager;
import com.task.testTask.exceptions.ClientException;
import com.task.testTask.models.ClientModel;
import com.task.testTask.repositories.ClientRepository;
import com.task.testTask.repositories.ManagerRepository;
import com.task.testTask.services.ClientService;
import com.task.testTask.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    Utils utils;

    @Override
    public Client createClient(Client client) {
        if(clientRepository.findByClientCode(client.getClientCode())!=null)throw new ClientException("Client already exists");
        Client savingClient=new Client();
        BeanUtils.copyProperties(client,savingClient);
        if(client.getManager()!=null){
        Manager manager=managerRepository.findById(savingClient.getManager().getId());
        if (manager!=null){
        savingClient.setManager(manager);}}
        savingClient.setClientCode(utils.generateClientId(10));
         return clientRepository.save(savingClient);
    }

    @Override
    public List<ClientModel> getAllClients() {
        List<ClientModel> returningClients=new ArrayList<>();
        List<Client> clients= clientRepository.findAllByStatusIsFalse();
        for(Client client:clients){
            ClientModel model=new ClientModel();
            BeanUtils.copyProperties(client,model);
            if (client.getManager()!=null){
            model.setManagerFullName(client.getManager().getFullName());
            model.setManagerPhoneNumber(client.getManager().getPhoneNumber());
            if (client.getManager().getDeputy()!=null){
            model.setManagerDeputyPhoneNumber(client.getManager().getDeputy().getPhoneNumber());}}
            returningClients.add(model);
        }
        return returningClients;
    }

    @Override
    public Client getClient(String clientCode) {
        Client gettingClient=clientRepository.findByClientCode(clientCode);
        if(gettingClient==null)throw new ClientException("Client not found");
        if(gettingClient.isStatus()==true)throw new ClientException("Client is deleted");
        return gettingClient;

    }

    @Override
    public void deleteClient(String clientCode) {
        Client deletingClient=clientRepository.findByClientCode(clientCode);
        if(deletingClient==null || deletingClient.isStatus()==true)throw new ClientException("Client doesn't exist or already deleted");
        deletingClient.setStatus(true);
        clientRepository.save(deletingClient);
    }

    @Override
    public Client updateClient(String clientCode, Client client) {
        Client updatingClient=clientRepository.findByClientCode(clientCode);
        if(updatingClient==null) throw new ClientException("Client not found");
        updatingClient.setFullName(client.getFullName());
        updatingClient.setAddress(client.getAddress());
        return clientRepository.save(updatingClient);
    }

}
