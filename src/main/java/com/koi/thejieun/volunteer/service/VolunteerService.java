package com.koi.thejieun.volunteer.service;

import com.koi.thejieun.exception.MyException;
import com.koi.thejieun.util.PageGroup;
import com.koi.thejieun.volunteer.dto.VolunteerDTO;

public interface VolunteerService {
    /**
     * 자원봉사자 신청
     * @param volunteerDTO 지원자 dto
     * @throws MyException
     */
    public void addVolunteer(VolunteerDTO volunteerDTO) throws MyException;

    /**
     * 자원봉사 신청목록 페이징 처리하여 전체 조회
     * @param currentPage 현재 페이지
     * @return 자원봉사 전체 신청 목록
     * @throws MyException
     */
    public PageGroup<VolunteerDTO> findVoList(Integer currentPage) throws MyException;

    /**
     * status에 해당하는 자원봉사 신청 목록을 페이징 처리하여 조회
     * @param currentPage 현재 페이지
     * @param status 완료 여부 : 0인 경우 완료된 봉사, 1인 경우 대기중인 봉사
     * @return 자원봉사 신청 목록
     * @throws MyException
     */
    public PageGroup<VolunteerDTO> findByStatus(Integer currentPage, Integer status) throws MyException;

    /**
     * 자원봉사자 상세 조회
     * @param voNo 공지사항 번호
     * @return voNo에 해당하는 공지사항
     * @throws MyException
     */
    public VolunteerDTO findByVoNo(Long voNo) throws MyException;

    /**
     * @param volunteerDTO
     * @throws MyException
     */
    public void modifyVolunteer(VolunteerDTO volunteerDTO) throws MyException;

    /**
     * 자원봉사자 내역 삭제
     * @param voNo
     * @throws MyException
     */
    public void removeVolunteer(Long voNo) throws MyException;
}
