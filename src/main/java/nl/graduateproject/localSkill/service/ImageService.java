package nl.graduateproject.localSkill.service;


import nl.graduateproject.localSkill.model.Customer;
import nl.graduateproject.localSkill.model.Image;
import nl.graduateproject.localSkill.model.Item;
import nl.graduateproject.localSkill.model.ItemType;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Optional;


public interface ImageService {

//    public abstract Image saveImage(MultipartFile file);
    public long createImage(Image image);

    public void deleteImage(long id);

    public Collection<Image> getImages();

    public Optional<Image> getImageById(long id);

    public void updateImage(long id, Image image);

    public boolean imageExistsById(long id);

    public void uploadFile(MultipartFile file);

}
