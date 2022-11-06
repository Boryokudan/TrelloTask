package kz.bitlab.TrelloTask.folder;

import kz.bitlab.TrelloTask.task_category.TaskCategory;
import kz.bitlab.TrelloTask.task_category.TaskCategoryServiceImplementation;
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
    private FolderServiceImplementation folderService;

    @Autowired
    private TaskCategoryServiceImplementation taskCategoryService;

    @GetMapping
    public String getFolders(Model model) {
        List<Folder> folders = folderService.getFolders();
        System.out.println(folders.get(0).getDescription());
        model.addAttribute("folders", folders);
        return "index";
    }

    @GetMapping(value = "/{folderId}")
    public String getFolder(@PathVariable(name = "folderId") Long Id,
                            Model model) {
        Folder folder = folderService.getFolder(Id);
        List<TaskCategory> categoryList = taskCategoryService.getCategories();
        model.addAttribute(folder);
        model.addAttribute(categoryList);
        return "folder_details";
    }
}
