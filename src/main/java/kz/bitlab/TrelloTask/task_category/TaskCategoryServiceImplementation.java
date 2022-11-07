package kz.bitlab.TrelloTask.task_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCategoryServiceImplementation implements TaskCategoryService {
    @Autowired
    TaskCategoryRepository taskCategoryRepository;
    public List<TaskCategory> getCategories() {
        return taskCategoryRepository.findAll();
    }

    @Override
    public TaskCategory getCategoryById(Long categoryId) {
        return taskCategoryRepository.findById(categoryId).get();
    }
}
