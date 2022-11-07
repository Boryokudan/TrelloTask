package kz.bitlab.TrelloTask.task;

import kz.bitlab.TrelloTask.folder.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImplementation implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getTasksByFolderId(Folder folder) {
        return taskRepository.findAllByFolder(folder);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }
}
