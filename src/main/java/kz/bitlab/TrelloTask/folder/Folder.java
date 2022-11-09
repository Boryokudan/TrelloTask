package kz.bitlab.TrelloTask.folder;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import kz.bitlab.TrelloTask.task_category.TaskCategory;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_folders")
@NoArgsConstructor
@Getter
@Setter
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private String description;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<TaskCategory> categories;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TaskCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<TaskCategory> categories) {
        this.categories = categories;
    }
}
