package com.koi.thejieun.volunteer.dao;

import com.koi.thejieun.volunteer.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {}
