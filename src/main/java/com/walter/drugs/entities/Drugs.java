package com.walter.drugs.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Drugs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String genericName;
    private String brandNames;
    private String dosageForm;
    private Date lastUpdated;
    @ManyToOne
    private  DrugClass drugClass;

    @OneToMany (mappedBy = "drug")
    private List<Image> images;




    //constructor
    public Drugs() {
        super();
    }


    public Drugs(Integer id, String genericName, String brandNames, String dosageForm, Date lastUpdated, DrugClass drugClass, List<Image> images) {
        this.id = id;
        this.genericName = genericName;
        this.brandNames = brandNames;
        this.dosageForm = dosageForm;
        this.lastUpdated = lastUpdated;
        this.drugClass = drugClass;
        this.images = images;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getGenericName() {
        return genericName;
    }
    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }
    public String getBrandNames() {
        return brandNames;
    }
    public void setBrandNames(String brandNames) {
        this.brandNames = brandNames;
    }
    public String getDosageForm() {
        return dosageForm;
    }
    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public DrugClass getDrugClass() {
        return drugClass;
    }
    public void setDrugClass(DrugClass drugClass) {
        this.drugClass = drugClass;
    }


    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    //toString
    @Override
    public String toString() {
        return "drugs [id=" + id + ", genericName=" + genericName + ", brandNames=" + brandNames + ", dosageForm="
                + dosageForm + ", lastUpdated=" + lastUpdated + "]";
    }
}
