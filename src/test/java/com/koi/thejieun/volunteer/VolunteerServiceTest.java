package com.koi.thejieun.volunteer;

import com.koi.thejieun.volunteer.dao.VolunteerRepository;
import com.koi.thejieun.volunteer.dto.VolunteerDTO;
import com.koi.thejieun.volunteer.service.VolunteerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VolunteerServiceTest {
    @Mock
    VolunteerRepository repository;
    @InjectMocks
    VolunteerServiceImpl service;

    @Test
    void insert() {
        VolunteerDTO volunteerDTO=VolunteerDTO.builder()
                .voName("최종수")
                .voPwd(1231L)
                .voTel("010-1234-5678")
                .voContent("저는 농구를 잘합니다!!")
                .build();
        Long no=service.addVolunteer(volunteerDTO);
        System.out.println(no);
    }
}
