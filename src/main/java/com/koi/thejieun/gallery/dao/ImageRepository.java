package com.koi.thejieun.gallery.dao;

import com.koi.thejieun.gallery.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {}
