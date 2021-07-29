package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.fileDB.Image;
import nl.graduateproject.localSkill.repository.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileDBServiceImpl implements FileDBService {

    @Autowired
    private FileDBRepository fileDBRepository;

    public Image store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Image Image = new Image(fileName, file.getContentType(), file.getBytes());

        return fileDBRepository.save(Image);
    }

    public Image getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<Image> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}


