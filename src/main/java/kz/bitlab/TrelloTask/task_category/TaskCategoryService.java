package kz.bitlab.TrelloTask.task_category;

import java.util.List;

public interface TaskCategoryService {
    List<TaskCategory> getCategories();
    TaskCategory getCategoryById(Long categoryId);
}
