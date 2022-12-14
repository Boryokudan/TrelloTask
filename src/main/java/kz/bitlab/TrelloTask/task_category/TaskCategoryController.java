package kz.bitlab.TrelloTask.task_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class TaskCategoryController {

    @Autowired
    TaskCategoryService taskCategoryService;

    @GetMapping
    public String getCategories(Model model) {
        model.addAttribute("categories", taskCategoryService.getCategories());
        return "categories";
    }
}
