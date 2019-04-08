package com.salvadordavi.portfolio.repository;

import com.salvadordavi.portfolio.model.AlbumPhoto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumPhotoRepository extends CrudRepository<AlbumPhoto, Long> {
}
