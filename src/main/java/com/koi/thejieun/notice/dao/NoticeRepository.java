package com.koi.thejieun.notice.dao;

import com.koi.thejieun.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {}
