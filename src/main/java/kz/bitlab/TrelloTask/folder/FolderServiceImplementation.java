package kz.bitlab.TrelloTask.folder;

import kz.bitlab.TrelloTask.task.Task;
import kz.bitlab.TrelloTask.task.TaskService;
import kz.bitlab.TrelloTask.task_category.TaskCategory;
import kz.bitlab.TrelloTask.task_category.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class FolderServiceImplementation implements FolderService {

    @Autowired
    TaskService taskService;
    @Autowired
    TaskCategoryService taskCategoryService;
    @Autowired
    private FolderRepository folderRepository;

    @Override
    public List<Folder> getFolders() {
        return folderRepository.findAll();
    }

    @Override
    public Folder getFolder(Long Id) {
        return folderRepository.findById(Id).orElseThrow();
    }

    @Override
    public void saveFolder(Folder folder) {
        folderRepository.save(folder);
    }

    @Override
    public Model getFolderDetails(Long folderId, Model model) {
        Folder folder = getFolder(folderId);
        List<TaskCategory> folderCategories = folder.getCategories();
        List<TaskCategory> categories = taskCategoryService.getCategories();
        List<Task> tasks = taskService.getTasksByFolderId(folder);
        if (folderCategories != null) categories.removeAll(folderCategories);

        model.addAttribute("folder", folder);
        model.addAttribute("categories", categories);
        model.addAttribute("tasks", tasks);

        return model;
    }

    @Override
    public void assignCategory(Long folderId, Long categoryId) {
        Folder folder = getFolder(folderId);
        List<TaskCategory> categories = folder.getCategories();
        TaskCategory category = taskCategoryService.getCategoryById(categoryId);
        if (categories == null) {
            categories = new ArrayList<>();
        }
        if (!categories.contains(category)) {
            categories.add(category);
            folder.setCategories(categories);
            saveFolder(folder);
        }
    }

    @Override
    public void deleteCategory(Long folderId, Long categoryId) {
        Folder folder = getFolder(folderId);
        List<TaskCategory> categories = folder.getCategories();
        TaskCategory category = taskCategoryService.getCategoryById(categoryId);

        if (categories != null) {
            if (categories.contains(category)) {
                categories.remove(category);
                folder.setCategories(categories);
                saveFolder(folder);
            }
        }
    }
}
