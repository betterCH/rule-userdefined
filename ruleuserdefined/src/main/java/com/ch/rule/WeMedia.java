package com.ch.rule;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hao on 2018/4/17.
 */
public class WeMedia implements Serializable{
    /**
     * auto increment
     */
    @JsonIgnore
    private long id;

    /**
     * 自媒体id
     */
    private long uploaderId;



    private String nickName;

    @JsonIgnore
    private String realName;


    @JsonIgnore
    private Date createTime;

    public Integer getToutiaoVerified() {
        return toutiaoVerified;
    }

    public void setToutiaoVerified(Integer toutiaoVerified) {
        this.toutiaoVerified = toutiaoVerified;
    }

    @JsonIgnore
    private Date updateTime;

    private Integer verified;
    private Integer verified_r;

    @JsonIgnore
    private Integer toutiaoVerified;

    private Integer verifyFlag;

    private Integer verifyFlag_r;

    @JsonIgnore
    private String showName;

    @JsonIgnore
    private String recommendLevel;

    @JsonIgnore
    private String label;

    private Long fansCount;

    private Integer mark;
    @JsonIgnore
    private Integer verifyClass;
    @JsonIgnore
    private Integer copyrightInfo;
    @JsonIgnore
    private Integer verifyState;
    @JsonIgnore
    private Integer verifyLevel;
    private boolean isCrawler;//是否是机器人账号，只前端展示用
    private boolean showFollowButton;//是否显示关注按钮，只前端展示用
    private boolean showFollowPanel;//是否显示关注区域,只前端展示用
    private int isadshr;

    private boolean notifyValid;
    @JsonIgnore
    private String verifyInfo;    //来源认证接口，存在显示该字段，不存在显示brief


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(long uploaderId) {
        this.uploaderId = uploaderId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    public Integer getVerified_r() {
        return verified_r;
    }

    public void setVerified_r(Integer verified_r) {
        this.verified_r = verified_r;
    }

    public Integer getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(Integer verifyFlag) {
        this.verifyFlag = verifyFlag;
    }

    public Integer getVerifyFlag_r() {
        return verifyFlag_r;
    }

    public void setVerifyFlag_r(Integer verifyFlag_r) {
        this.verifyFlag_r = verifyFlag_r;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getRecommendLevel() {
        return recommendLevel;
    }

    public void setRecommendLevel(String recommendLevel) {
        this.recommendLevel = recommendLevel;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getFansCount() {
        return fansCount;
    }

    public void setFansCount(Long fansCount) {
        this.fansCount = fansCount;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getVerifyClass() {
        return verifyClass;
    }

    public void setVerifyClass(Integer verifyClass) {
        this.verifyClass = verifyClass;
    }

    public Integer getCopyrightInfo() {
        return copyrightInfo;
    }

    public void setCopyrightInfo(Integer copyrightInfo) {
        this.copyrightInfo = copyrightInfo;
    }

    public Integer getVerifyState() {
        return verifyState;
    }

    public void setVerifyState(Integer verifyState) {
        this.verifyState = verifyState;
    }

    public Integer getVerifyLevel() {
        return verifyLevel;
    }

    public void setVerifyLevel(Integer verifyLevel) {
        this.verifyLevel = verifyLevel;
    }

    public boolean isCrawler() {
        return isCrawler;
    }

    public void setCrawler(boolean crawler) {
        isCrawler = crawler;
    }

    public boolean isShowFollowButton() {
        return showFollowButton;
    }

    public void setShowFollowButton(boolean showFollowButton) {
        this.showFollowButton = showFollowButton;
    }

    public boolean isShowFollowPanel() {
        return showFollowPanel;
    }

    public void setShowFollowPanel(boolean showFollowPanel) {
        this.showFollowPanel = showFollowPanel;
    }

    public int getIsadshr() {
        return isadshr;
    }

    public void setIsadshr(int isadshr) {
        this.isadshr = isadshr;
    }

    public boolean isNotifyValid() {
        return notifyValid;
    }

    public void setNotifyValid(boolean notifyValid) {
        this.notifyValid = notifyValid;
    }

    public String getVerifyInfo() {
        return verifyInfo;
    }

    public void setVerifyInfo(String verifyInfo) {
        this.verifyInfo = verifyInfo;
    }
}
