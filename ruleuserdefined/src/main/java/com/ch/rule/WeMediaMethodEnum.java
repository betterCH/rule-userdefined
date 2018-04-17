package com.ch.rule;


import org.springframework.util.StringUtils;

/**
 * Created by hao on 2018/4/16.
 */
public enum WeMediaMethodEnum {

    UPLOADERID("uploaderId","getUploaderId","setUploaderId"),
    VERIFIED("verified","getVerified_r","setVerified"),
    COPYRIGHTINFO("copyrightInfo","getCopyrightInfo","setCopyrightInfo"),
    VERIFYFLAG("verifyFlag","getVerifyFlag_r","setVerifyFlag");

    private String name;
    private String get;
    private String set;

    WeMediaMethodEnum(String name, String get, String set) {
        this.name = name;
        this.get = get;
        this.set = set;
    }
    public static WeMediaMethodEnum get(String name){
        if (StringUtils.isEmpty(name)){
            return null;
        }
        for (WeMediaMethodEnum weMediaMethodEnum : WeMediaMethodEnum.values()){
            if (weMediaMethodEnum.getName().equalsIgnoreCase(name)){
                return weMediaMethodEnum;
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }

    public String getGet() {
        return get;
    }

    public String getSet() {
        return set;
    }
}
