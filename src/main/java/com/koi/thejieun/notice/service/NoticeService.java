package com.koi.thejieun.notice.service;

import com.koi.thejieun.exception.MyException;
import com.koi.thejieun.notice.dto.NoticeDTO;
import com.koi.thejieun.util.PageGroup;

interface NoticeService {
    /**
     * 공지사항을 추가한다.
     * @param noticeDTO 공지사항 dto
     * @throws MyException
     */
    public void addNotice(NoticeDTO noticeDTO) throws MyException;

    /**
     * 공지사항 목록을 페이징 처리하여 조회한다.
     * @param currentPage 현재 페이지
     * @return currentPage에 해당하는 공지사항 목록
     * @throws MyException
     */
    public PageGroup<NoticeDTO> findNoticeList(Integer currentPage) throws MyException;

    /**
     * noticeNo에 해당하는 공지사항을 상세 조회한다.
     * @param noticeNo 공지사항 번호
     * @return noticeNo에 해당하는 공지사항
     * @throws MyException
     */
    public NoticeDTO findByNoticeNo(Long noticeNo) throws MyException;

    /**
     * 공지사항 내용을 수정한다.
     * @param noticeDTO 공지사항 dto
     * @throws MyException
     */
    public void modifyNotice(NoticeDTO noticeDTO) throws MyException;

    /**
     * noticeNo에 해당하는 공지사항을 삭제한다.
     * @param noticeNo 공지사항 번호
     * @throws MyException
     */
    public void removeNotice(Long noticeNo) throws MyException;
}
