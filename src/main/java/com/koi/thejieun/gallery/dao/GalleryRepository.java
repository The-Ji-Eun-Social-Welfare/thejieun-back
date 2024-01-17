package com.koi.thejieun.gallery.dao;

import com.koi.thejieun.gallery.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {}
