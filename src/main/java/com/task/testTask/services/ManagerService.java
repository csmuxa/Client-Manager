package com.task.testTask.services;

import com.task.testTask.models.ClientsListModel;
import com.task.testTask.entities.Manager;
import com.task.testTask.models.ManagerModel;

import java.util.List;

public interface ManagerService {

    Manager createManager(Manager manager);

    List<ManagerModel> getAllManagers();

    List<ClientsListModel> getAllClientsOfManager(long id);

    Manager updateManager(long id, Manager manager);

    void deleteManager(long id);


}
