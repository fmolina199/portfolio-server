package com.salvadordavi.portfolio.model;

import com.salvadordavi.portfolio.embeddable.AlbumPhotoKey;

import javax.persistence.*;

@Entity
public class AlbumPhoto {
    @EmbeddedId
    private AlbumPhotoKey id = new AlbumPhotoKey();

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("album_id")
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("photo_id")
    @JoinColumn(name = "photo_id")
    private Photo photo;

    private Integer likeCount = 0;

    public AlbumPhotoKey getId() {
        return id;
    }

    public void setId(AlbumPhotoKey id) {
        this.id = id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
        this.id.setAlbumId(album.getId());
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
        this.id.setPhotoId(photo.getId());
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
