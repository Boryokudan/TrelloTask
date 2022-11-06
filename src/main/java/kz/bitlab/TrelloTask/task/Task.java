package kz.bitlab.TrelloTask.task;

import kz.bitlab.TrelloTask.folder.Folder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_tasks")
@NoArgsConstructor
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int status;

    @ManyToOne
    private Folder folder;
}
