package com.koi.thejieun.banner.dao;

import com.koi.thejieun.banner.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository<Banner, Long> {}
