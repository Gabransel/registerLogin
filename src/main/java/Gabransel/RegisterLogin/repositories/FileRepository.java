package Gabransel.RegisterLogin.repositories;

import Gabransel.RegisterLogin.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {

    List<File> findByUserId(Long id);
    List<File> findByUserIdAndFileType(Long id, File.FileType fileType);
}
