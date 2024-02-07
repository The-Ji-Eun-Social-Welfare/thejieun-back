package com.koi.thejieun.setting.service;

import com.koi.thejieun.exception.MyException;
import com.koi.thejieun.setting.dao.SettingRepository;
import com.koi.thejieun.setting.dto.SettingDTO;
import com.koi.thejieun.setting.entity.Setting;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SettingServiceImpl implements SettingService {
    @Autowired private SettingRepository repository;

    @Override
    public void addSetting(SettingDTO settingDTO) throws MyException {
        Setting setting =
                Setting.builder()
                        .adminId(settingDTO.getAdminId())
                        .adminPwd(settingDTO.getAdminPwd())
                        .build();
        repository.save(setting);
    }

    @Override
    public SettingDTO findBySettingNo(Long settingNo) throws MyException {
        Optional<Setting> settingOpt = repository.findById(settingNo);
        Setting setting = settingOpt.get();
        SettingDTO settingDTO =
                SettingDTO.builder()
                        .settingNo(settingNo)
                        .adminId(setting.getAdminId())
                        .adminPwd(setting.getAdminPwd())
                        .build();
        return settingDTO;
    }

    @Override
    public void modifySetting(SettingDTO settingDTO) throws MyException {
        Optional<Setting> settingOpt = repository.findById(settingDTO.getSettingNo());
        Setting setting = settingOpt.get();
        setting.modifySetInfo(settingDTO);
        repository.save(setting);
    }
}
