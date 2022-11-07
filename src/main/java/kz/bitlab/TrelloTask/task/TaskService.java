package kz.bitlab.TrelloTask.task;

import kz.bitlab.TrelloTask.folder.Folder;

import java.util.List;

public interface TaskService {
    List<Task> getTasksByFolderId(Folder folder);

    Task getTaskById(Long id);
}
