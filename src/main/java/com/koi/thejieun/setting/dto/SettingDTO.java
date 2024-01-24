package com.koi.thejieun.setting.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SettingDTO {
    private Long settingNo;
    private String adminId;
    private String adminPwd;
}