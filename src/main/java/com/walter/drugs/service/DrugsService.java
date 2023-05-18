package com.walter.drugs.service;

import com.walter.drugs.entities.Drugs;
import com.walter.drugs.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DrugsService {
    Drugs saveDrugs(Drugs drug);
    Drugs updateDrugs(Drugs drug);
    void deleteDrugs(Drugs drug);
    void deleteDrugsById(int id);
    Drugs getDrugsById(int id);
    Iterable<Drugs> getAllDrugs();

    /****/
    List<Drugs> findByGenericName(String genericName);
    List<Drugs> findByGenericNameContains(String genericName);
    List<Drugs> findByDrugClassIdcl(Integer idcl);
    List<Drugs> findByOrderByGenericNameAsc();
    List<Drugs> sortByGenericNameDosageForm();
    List<Drugs> findByGenericNameBrandNames(String genericName, String brandNames);







}
