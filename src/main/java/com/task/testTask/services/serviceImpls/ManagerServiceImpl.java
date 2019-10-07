package com.task.testTask.services.serviceImpls;

import com.task.testTask.models.ClientsListModel;
import com.task.testTask.exceptions.ManagerException;
import com.task.testTask.entities.Client;
import com.task.testTask.entities.Manager;
import com.task.testTask.models.ManagerModel;
import com.task.testTask.repositories.ClientRepository;
import com.task.testTask.repositories.ManagerRepository;
import com.task.testTask.services.ManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {


    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    ClientRepository clientRepository;


    @Override
    public Manager createManager(Manager manager) {
        Manager savingManager=new Manager();
        BeanUtils.copyProperties(manager,savingManager);
        if (savingManager.getDeputy()!=null){
            Manager deputy=managerRepository.findById(savingManager.getDeputy().getId());
            savingManager.setDeputy(deputy);
        }
        return managerRepository.save(savingManager);
    }

    @Override
    public List<ManagerModel> getAllManagers() {
        List<ManagerModel> returningManagers=new ArrayList<>();
        List<Manager> managers= managerRepository.findAll();
        for(Manager manager:managers){
            ManagerModel model=new ManagerModel();
            BeanUtils.copyProperties(manager,model);
            if(manager.getDeputy()!=null){
            model.setDeputyFullName(manager.getDeputy().getFullName());
            model.setDeputyPhoneNumber(manager.getDeputy().getPhoneNumber());}
            returningManagers.add(model);
        }
        return returningManagers;
    }

    @Override
    public List<ClientsListModel> getAllClientsOfManager(long id) {
        List<Client> clients= managerRepository.findById(id).getClients();
        List<ClientsListModel> returningClients=new ArrayList<>();
        for (Client client:clients){
            ClientsListModel clientsListModel=new ClientsListModel();
            BeanUtils.copyProperties(client,clientsListModel);
            returningClients.add(clientsListModel);
        }
        return returningClients;

    }

    @Override
    public Manager updateManager(long id, Manager manager) {
        Manager updatingManager = managerRepository.findById(id);
        if (updatingManager == null) throw new ManagerException("Manager not found or already deleted");
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(manager, updatingManager);
        return managerRepository.save(updatingManager);
    }

    @Override
    public void deleteManager(long id) {
        Manager deletingManager = managerRepository.findById(id);
        Manager deputyManager = deletingManager.getDeputy();
        if (deletingManager.getClients() == null)
            managerRepository.deleteById(id);
        if (deputyManager == null) throw new ManagerException("Can't delete,deputy doesn't exist");

            for (Client client : deletingManager.getClients()) {
                deputyManager.getClients().add(client);
            }
            managerRepository.save(deputyManager);
            managerRepository.deleteById(id);

        }


    }

