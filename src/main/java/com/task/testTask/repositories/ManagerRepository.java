package com.task.testTask.repositories;

import com.task.testTask.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Manager findById(long id);
}
