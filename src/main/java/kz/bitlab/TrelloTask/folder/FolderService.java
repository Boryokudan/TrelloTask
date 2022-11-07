package kz.bitlab.TrelloTask.folder;

import org.springframework.ui.Model;

import java.util.List;

public interface FolderService {

    List<Folder> getFolders();
    Folder getFolder(Long Id);

    Model getFolderDetails(Long id, Model model);

    void saveFolder(Folder folder);

    void assignCategory(Long folderId, Long categoryId);

    void deleteCategory(Long folderId, Long categoryId);
}
