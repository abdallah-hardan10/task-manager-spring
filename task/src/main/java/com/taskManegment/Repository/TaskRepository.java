package com.taskManegment.Repository;

import com.taskManegment.Entity.TaskEntity;
import com.taskManegment.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByUser(UserEntity user);
    List<TaskEntity> findByUserAndCompleted(UserEntity user, boolean completed);
}
