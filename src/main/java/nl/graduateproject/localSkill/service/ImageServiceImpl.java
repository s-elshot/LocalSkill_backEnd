package nl.graduateproject.localSkill.service;

import antlr.StringUtils;
import nl.graduateproject.localSkill.model.Image;
import nl.graduateproject.localSkill.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import static antlr.StringUtils.*;
import static org.springframework.util.StringUtils.cleanPath;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void save(MultipartFile file)throws IOException{
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setContent(file.getBytes());
        image.setDescription(file.getContentType());

    }

    @Override
    public Collection<Image> getImages() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> getItemById(long id) {
        if (!imageRepository.existsById(id)) throw new RecordNotFoundException();
        return imageRepository.findById(id);
    }


//    public Image saveImage(MultipartFile file){
//        String name = file.getOriginalFilename();
//        try {
//            Image image = new Image(name, file.getContentType(),file.getBytes());
//            return imageRepository.save(image);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return  null;
//    }


    @Override
    public long createImage(Image image) {
        Image newImage = imageRepository.save(image);
        return newImage.getId();
    }

    @Override
    public void deleteImage(long id) {
        if (!imageRepository.existsById(id)) throw new RecordNotFoundException();
        imageRepository.deleteById(id);
    }

    @Override
    public boolean imageExistsById(long id) {
        return imageRepository.existsById(id);
    }


}
