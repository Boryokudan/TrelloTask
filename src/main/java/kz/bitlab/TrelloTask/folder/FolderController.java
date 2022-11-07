package kz.bitlab.TrelloTask.folder;

import kz.bitlab.TrelloTask.task.Task;
import kz.bitlab.TrelloTask.task.TaskService;
import kz.bitlab.TrelloTask.task_category.TaskCategory;
import kz.bitlab.TrelloTask.task_category.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/folders")
public class FolderController {

    @Autowired
    private FolderService folderService;

    @Autowired
    private TaskCategoryService taskCategoryService;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getFolders(Model model) {
        List<Folder> folders = folderService.getFolders();
        model.addAttribute("folders", folders);
        return "index";
    }

    @GetMapping(value = "/{folderId}")
    public String getFolder(@PathVariable(name = "folderId") Long Id,
                            Model model) {
        Folder folder = folderService.getFolder(Id);
        List<TaskCategory> categories = taskCategoryService.getCategories();
        List<Task> tasks = taskService.getTasksByFolderId(folder);
        model.addAttribute("folder", folder);
        model.addAttribute("categories", categories);
        model.addAttribute("tasks", tasks);
        return "folder_details";
    }
}