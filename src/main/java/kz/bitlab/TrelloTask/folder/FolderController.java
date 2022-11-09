package kz.bitlab.TrelloTask.folder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/folders")
//@RequiredArgsConstructor
public class FolderController {
    private final FolderService folderService;

    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @GetMapping
    public String getFolders(Model model) {
        List<Folder> folders = folderService.getFolders();
        model.addAttribute("folders", folders);
        return "index";
    }

    @GetMapping("/{folderId}")
    public String getFolderDetails(@PathVariable(name = "folderId") Long id, Model model) {
        model = folderService.getFolderDetails(id, model);
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