package com.koi.thejieun.setting.dao;

import com.koi.thejieun.setting.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, Long> {}
