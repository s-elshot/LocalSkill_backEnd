package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.fileDB.FileDB;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;


public interface FileDBService {

        public FileDB store(MultipartFile file) throws IOException;

        public FileDB getFile(String id);

        public Stream<FileDB> getAllFiles();
}