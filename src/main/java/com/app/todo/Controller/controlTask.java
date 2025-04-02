package com.app.todo.Controller;

import com.app.todo.Service.taskService;
import com.app.todo.model.Task;
import com.app.todo.respository.taskRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping()
public class controlTask {

    private final taskService ts;

    public controlTask(taskService ts) {
        this.ts = ts;
    }

    @GetMapping
    public String getAllTasks(Model model) {
        List<Task> tasks = ts.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/")
    public String createNewTask(@RequestParam String title){
        ts.createNewTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        ts.deleteTaskById(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        ts.toggleTask(id);
        return "redirect:/";
    }
}
