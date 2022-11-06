package kz.bitlab.TrelloTask.folder;

import java.util.List;

public interface FolderService {

    List<Folder> getFolders();
    Folder getFolder(Long Id);
}
