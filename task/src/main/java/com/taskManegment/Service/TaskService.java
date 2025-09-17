package com.taskManegment.Service;

import com.taskManegment.Entity.TaskEntity;
import com.taskManegment.Entity.UserEntity;
import com.taskManegment.Repository.TaskRepository;
import com.taskManegment.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void createTask(String title, String description, String userEmail) {
        UserEntity user = getUserByEmail(userEmail);
        TaskEntity task = new TaskEntity();
        task.setTitle(title);
        task.setDescription(description);
        task.setCompleted(false);
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<TaskEntity> getTasksByUserEmail(String email) {
        UserEntity user = getUserByEmail(email);
        return taskRepository.findByUser(user);
    }

    public void toggleTaskCompleted(Long taskId, String userEmail) {
        TaskEntity task = getTasksByUserEmail(userEmail).stream()
                .filter(t -> t.getId().equals(taskId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public TaskEntity getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void updateTask(Long id, String title, String description, String userEmail) {
        TaskEntity task = getTaskById(id);
        task.setTitle(title);
        task.setDescription(description);
        taskRepository.save(task);
    }

}
