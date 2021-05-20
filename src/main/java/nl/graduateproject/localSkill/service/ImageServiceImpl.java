package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.Item.Item;
import nl.graduateproject.localSkill.model.image.Image;
import nl.graduateproject.localSkill.repository.ImageRepository;
import nl.graduateproject.localSkill.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {


    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Collection<Image> getImages() {
        return imageRepository.findAll();
    }

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
    public Optional<Image> getItemById(long id) {
        if (!imageRepository.existsById(id)) throw new RecordNotFoundException();
        return imageRepository.findById(id);
    }



    @Override
    public boolean imageExistsById(long id) {
        return imageRepository.existsById(id);
    }


}
