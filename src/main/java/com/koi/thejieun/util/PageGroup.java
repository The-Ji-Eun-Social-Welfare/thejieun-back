package com.koi.thejieun.util;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageGroup<T> {
    public static final Integer CNT_PER_PAGE = 10;
    public static final Integer CNT_PER_PAGEGROUP = 5;
    private List<T> list;
    private Long totalCnt; // T의 총 개수
    private Integer currentPage; // 현재 페이지
    private Integer totalPage; // 총 페이지 수
    private Integer startPage; // 시작 페이지

    private Integer endPage; // 끝 페이지

    public PageGroup(List<T> list, Integer currentPage, Long totalCnt) {
        this.list = list;
        this.currentPage = currentPage;
        this.totalCnt = totalCnt;
        // 총 페이지 수 계산
        this.totalPage = (int) Math.ceil((double) totalCnt / CNT_PER_PAGE);
        if (currentPage <= totalPage) {
            // 시작 페이지, 끝 페이지 계산
            this.startPage = (currentPage - 1) / CNT_PER_PAGEGROUP * CNT_PER_PAGEGROUP + 1;
            this.endPage = startPage + CNT_PER_PAGEGROUP - 1;
            if (endPage > totalPage) {
                endPage = totalPage;
            }
        }
    }
}
