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

    @ManyToMany
    private List<TaskCategory> categories;
}
