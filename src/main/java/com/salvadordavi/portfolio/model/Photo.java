package com.salvadordavi.portfolio.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String name;
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "photo", cascade = CascadeType.ALL)
    private List<AlbumPhoto> albums = new ArrayList<>();

    Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AlbumPhoto> getAlbums() {
        return albums;
    }
}
