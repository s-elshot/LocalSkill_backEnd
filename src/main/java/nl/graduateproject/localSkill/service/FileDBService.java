package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.fileDB.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;


public interface FileDBService {

        public Image store(MultipartFile file) throws IOException;

        public Image getFile(String id);

        public Stream<Image> getAllFiles();
}