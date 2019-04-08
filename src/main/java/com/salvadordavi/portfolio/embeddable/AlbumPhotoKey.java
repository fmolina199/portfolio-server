package com.salvadordavi.portfolio.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AlbumPhotoKey implements Serializable {
    @Column(name = "album_id")
    private Long albumId;

    @Column(name = "photo_id")
    private Long photoId;

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumPhotoKey that = (AlbumPhotoKey) o;
        return albumId.equals(that.albumId) &&
                photoId.equals(that.photoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumId, photoId);
    }
}
