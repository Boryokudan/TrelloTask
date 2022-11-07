package kz.bitlab.TrelloTask.folder;

import kz.bitlab.TrelloTask.task.Task;
import kz.bitlab.TrelloTask.task.TaskService;
import kz.bitlab.TrelloTask.task_category.TaskCategory;
import kz.bitlab.TrelloTask.task_category.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{folderId}")
    public String getFolderDetails(@PathVariable(name = "folderId") Long Id,
                            Model model) {
        model = folderService.getFolderDetails(Id, model);
        return "folder_details";
    }

    @PostMapping("/assign_category")
    public String assignCategory(@RequestParam("folder_id") Long folderId,
                                 @RequestParam("category_id") Long categoryId) {
        folderService.assignCategory(folderId, categoryId);
        return "redirect:/folders/" + folderId;
    }

    @PostMapping("/delete_category")
    public String deleteCategory(@RequestParam("folder_id") Long folderId,
                                 @RequestParam("category_id") Long categoryId) {
        folderService.deleteCategory(folderId, categoryId);
        return "redirect:/folders/" + folderId;
    }
}