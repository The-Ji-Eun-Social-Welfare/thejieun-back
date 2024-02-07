package com.koi.thejieun.volunteer.service;

import com.koi.thejieun.exception.ErrorCode;
import com.koi.thejieun.exception.MyException;
import com.koi.thejieun.util.PageGroup;
import com.koi.thejieun.volunteer.dao.VolunteerRepository;
import com.koi.thejieun.volunteer.dto.VolunteerDTO;
import com.koi.thejieun.volunteer.entity.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired private VolunteerRepository repository;

    @Override
    public Long addVolunteer(VolunteerDTO volunteerDTO) throws MyException {
        Volunteer volunteer =
                Volunteer.builder()
                        .voName(volunteerDTO.getVoName())
                        .voPwd(volunteerDTO.getVoPwd())
                        .voContent(volunteerDTO.getVoContent())
                        .voTel(volunteerDTO.getVoTel())
                        .build();
        repository.save(volunteer);
        return volunteer.getVoNo();
    }

    @Override
    public PageGroup<VolunteerDTO> findVoList(Integer currentPage) throws MyException {

        return null;
    }

    @Override
    public PageGroup<VolunteerDTO> findByStatus(Integer currentPage, Integer status)
            throws MyException {
        return null;
    }

    @Override
    public VolunteerDTO findByVoNo(Long voNo) throws MyException {
        Optional<Volunteer> volunteerOpt = repository.findById(voNo);
        if (!volunteerOpt.isPresent()) {
            throw new MyException(ErrorCode.CONTENT_NOT_FOUND);
        }
        Volunteer volunteer = volunteerOpt.get();
        VolunteerDTO volunteerDTO =
                VolunteerDTO.builder()
                        .voNo(voNo)
                        .voName(volunteer.getVoName())
                        .voPwd(volunteer.getVoPwd())
                        .voContent(volunteer.getVoContent())
                        .voTel(volunteer.getVoTel())
                        .voRegdate(volunteer.getVoRegdate())
                        .voStatus(volunteer.getVoStatus())
                        .build();
        return volunteerDTO;
    }

    @Override
    public void modifyVolunteer(VolunteerDTO volunteerDTO) throws MyException {
        Optional<Volunteer> volunteerOpt = repository.findById(volunteerDTO.getVoNo());
        Volunteer volunteer = volunteerOpt.get();
        volunteer.modifyVoInfo(volunteerDTO);
        repository.save(volunteer);
    }

    @Override
    public void modifyStatus(Long voNo) throws MyException {
        Optional<Volunteer> volunteerOpt = repository.findById(voNo);
        Volunteer volunteer = volunteerOpt.get();
        volunteer.modifyStatus();
        repository.save(volunteer);
    }

    @Override
    public void removeVolunteer(Long voNo) throws MyException {
        repository.deleteById(voNo);
    }
}
