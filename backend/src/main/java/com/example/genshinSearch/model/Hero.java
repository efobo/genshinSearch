package com.example.genshinSearch.model;




import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Hero implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String element;
    private String weaponType;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String heroCode;

    public Hero () {}

    public Hero (String name, String element, String weaponType, String imageUrl, String heroCode) {
        this.name = name;
        this.element = element;
        this.weaponType = weaponType;
        this.imageUrl = imageUrl;
        this.heroCode = heroCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeroCode() {
        return heroCode;
    }

    public void setHeroCode(String heroCode) {
        this.heroCode = heroCode;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", element='" + element + '\'' +
                ", weaponType='" + weaponType + '\'' +
                ", imageUrl='" + imageUrl + '\'';
    }
}
