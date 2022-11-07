package kz.bitlab.TrelloTask.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{taskId}")
    public String getTaskDetails(@PathVariable(name = "taskId") Long taskId,
                                 Model model) {
        Task task = taskService.getTaskById(taskId);
        model.addAttribute("task", task);
        return "task_details";
    }
}
