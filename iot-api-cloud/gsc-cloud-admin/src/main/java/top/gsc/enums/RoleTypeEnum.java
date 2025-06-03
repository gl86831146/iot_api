package top.gsc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum RoleTypeEnum {
    SUPER_ADMIN(1, "超级管理员"),
    NORMAL_ADMIN(2, "普通管理员");

    private final Integer value;
    private final String name;

    // 保留原有的转换方法
    public static String getNameByValue(int value) {
        for (SuperAdminEnum s : SuperAdminEnum.values()) {
            if (s.getValue() == value) {
                return s.getName();
            }
        }
        return "";
    }

    public static Integer getValueByName(String name) {
        for (SuperAdminEnum s : SuperAdminEnum.values()) {
            if (Objects.equals(s.getName(), name)) {
                return s.getValue();
            }
        }
        return null;
    }
}
