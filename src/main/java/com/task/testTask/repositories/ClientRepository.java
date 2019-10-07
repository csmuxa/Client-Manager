package com.task.testTask.repositories;

import com.task.testTask.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByStatusIsFalse();
    Client findByClientCode(String clientCode);


}
