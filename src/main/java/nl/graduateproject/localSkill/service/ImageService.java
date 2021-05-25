package nl.graduateproject.localSkill.service;


import nl.graduateproject.localSkill.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Optional;


public interface ImageService {

//    public abstract Image saveImage(MultipartFile file);
    public abstract long createImage(Image image);

    public abstract void deleteImage(long id);

    public abstract Collection<Image> getImages();

    public abstract Optional<Image> getItemById(long id);

    public abstract boolean imageExistsById(long id);

}
