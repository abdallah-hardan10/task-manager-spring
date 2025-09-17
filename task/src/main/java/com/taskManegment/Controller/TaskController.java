package com.taskManegment.Controller;

import com.taskManegment.Dto.UserRegistrationDto;
import com.taskManegment.Entity.TaskEntity;
import com.taskManegment.Entity.UserEntity;
import com.taskManegment.Service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        String userEmail = principal.getName();
        UserEntity user = taskService.getUserByEmail(userEmail);

        if(user == null){
            return "redirect:/auth/login";
        }

        List<TaskEntity> tasks = taskService.getTasksByUserEmail(userEmail);

        model.addAttribute("user", user);
        model.addAttribute("tasks", tasks != null ? tasks : List.of());
        model.addAttribute("totalTasks", tasks != null ? tasks.size() : 0);
        model.addAttribute("completedTasks", tasks != null ? tasks.stream().filter(TaskEntity::isCompleted).count() : 0);
        model.addAttribute("pendingTasks", tasks != null ? tasks.stream().filter(t -> !t.isCompleted()).count() : 0);

        return "dashboard";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String title,
                          @RequestParam String description,
                          Principal principal) {
        String userEmail = principal.getName();
        taskService.createTask(title, description, userEmail);
        return "redirect:/tasks/dashboard";
    }

    @PostMapping("/toggle/{id}")
    public String toggleTask(@PathVariable Long id, Principal principal) {
        String userEmail = principal.getName();
        taskService.toggleTaskCompleted(id, userEmail);
        return "redirect:/tasks/dashboard";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks/dashboard";
    }

    @GetMapping("/edit/{id}")
    public String editTaskPage(@PathVariable Long id, Model model) {
        TaskEntity task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "editTask";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable Long id,
                           @RequestParam String title,
                           @RequestParam String description,
                           @RequestParam String userEmail) {
        taskService.updateTask(id, title, description, userEmail);
        return "redirect:/tasks/dashboard";
    }

    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        String email = principal.getName();

        UserEntity user = taskService.getUserByEmail(email);
        if (user == null) {
            return "redirect:/auth/login";
        }

        model.addAttribute("user", user);
        return "profile";
    }


}
