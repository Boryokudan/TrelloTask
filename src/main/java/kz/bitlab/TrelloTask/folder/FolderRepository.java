package kz.bitlab.TrelloTask.folder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FolderRepository extends JpaRepository<Folder, Long> {

}
