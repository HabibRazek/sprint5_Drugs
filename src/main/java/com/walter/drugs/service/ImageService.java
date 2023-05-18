package com.walter.drugs.service;

import com.walter.drugs.entities.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    Image uplaodImage(MultipartFile file) throws IOException;
    Image getImageDetails(Long id) throws IOException;
    ResponseEntity<byte[]> getImage(Long id) throws IOException;
    void deleteImage(Long id) ;
    Image uplaodImageProd(MultipartFile file,int idProd) throws IOException;

    List<Image> getImagesParProd(int prodId);



    List<Image> getImagesParDrug(Long id);


}
