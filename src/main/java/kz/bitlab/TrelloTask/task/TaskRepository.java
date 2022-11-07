package kz.bitlab.TrelloTask.task;

import kz.bitlab.TrelloTask.folder.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByFolder(Folder folder);
}
