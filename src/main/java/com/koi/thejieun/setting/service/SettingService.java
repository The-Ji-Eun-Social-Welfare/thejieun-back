package com.koi.thejieun.setting.service;

import com.koi.thejieun.exception.MyException;
import com.koi.thejieun.setting.dto.SettingDTO;

interface SettingService {
    /**
     * 관리자를 추가한다.
     * @param settingDTO 관리자 dto
     * @throws MyException
     */
    public void addSetting(SettingDTO settingDTO) throws MyException;

    /**
     * 관리자 정보를 수정한다.
     * @param settingDTO
     * @throws MyException
     */
    public void modifySetting(SettingDTO settingDTO) throws MyException;
}
