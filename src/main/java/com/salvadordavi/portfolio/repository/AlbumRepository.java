package com.salvadordavi.portfolio.repository;

import com.salvadordavi.portfolio.model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
}