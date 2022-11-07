package kz.bitlab.TrelloTask.folder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderServiceImplementation implements FolderService {

    @Autowired
    private FolderRepository folderRepository;

    @Override
    public List<Folder> getFolders() {
        return folderRepository.findAll();
    }

    @Override
    public Folder getFolder(Long Id) {
        return folderRepository.findById(Id).orElseThrow();
    }
}
