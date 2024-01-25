package com.koi.thejieun.setting.service;

import com.koi.thejieun.exception.MyException;
import com.koi.thejieun.setting.dto.SettingDTO;

interface SettingService {
    /**
     * 관리자를 추가한다.
     *
     * @param settingDTO 관리자 dto
     * @throws MyException
     */
    public void addSetting(SettingDTO settingDTO) throws MyException;

    /**
     * settingNo에 해당하는 관리자를 조회한다.
     *
     * @param settingNo 번호
     * @return settingNo에 해당하는 관리자
     * @throws MyException
     */
    public SettingDTO findBySettingNo(Long settingNo) throws MyException;

    /**
     * 관리자 정보를 수정한다.
     *
     * @param settingDTO
     * @throws MyException
     */
    public void modifySetting(SettingDTO settingDTO) throws MyException;
}
