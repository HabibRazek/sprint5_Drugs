package com.walter.drugs.service;

import com.walter.drugs.entities.Drugs;
import com.walter.drugs.entities.Image;
import com.walter.drugs.repos.DrugsRepository;
import com.walter.drugs.repos.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    DrugsService drugsService;
    @Autowired
    private DrugsRepository drugsRepository;

    @Override
    public Image uplaodImage(MultipartFile file) throws IOException {
 /*Ce code commenté est équivalent au code utilisant le design pattern Builder
 * Image image = new Image(null, file.getOriginalFilename(),
 file.getContentType(), file.getBytes(), null);
 return imageRepository.save(image);*/
        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes()).build() );
    }
    @Override
    public Image getImageDetails(Long id) throws IOException{
        final Optional<Image> dbImage = imageRepository. findById (id);
        return Image.builder()
                .idImage(dbImage.get().getIdImage())
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(dbImage.get().getImage()).build() ;
    }
    @Override
    public ResponseEntity<byte[]> getImage(Long id) throws IOException {
        final Optional<Image> dbImage = imageRepository. findById (id);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(dbImage.get().getImage());
    }
    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }



    @Override
    public List<Image> getImagesParProd(int prodId) {
        Drugs p = drugsRepository.findById(prodId).get();
        return p.getImages();
    }


    @Override
    public Image uplaodImageProd(MultipartFile file, int idProd) throws IOException {

        Drugs p = new Drugs();
        p.setId(idProd);
        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                .drug(p).build() );
    }



    @Override
    public List<Image> getImagesParDrug(Long id) {
        return null;
    }
}
