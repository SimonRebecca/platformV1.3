package com.zx.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhangxin on 2015-07-27.
 */
@Entity
@Table(name = "user")
public class User {


    //状态位： 1：正常    0：锁定
    public static final int USER_STATE_YES = 1;
    public static final int USER_STATE_NO = 0;

    @Id
    @GeneratedValue(generator = "myGenerator")
    @GenericGenerator(name = "myGenerator", strategy = "uuid")
    @Column(name = "userId", unique = true, nullable = false)
    private String userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userAge")
    private Integer userAge;

    @Column(name = "userSex")
    private Integer userSex;

    @Column(name = "userTel")
    private String userTel;

    @Column(name = "userState")
    private Integer userState;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "money")
    private Integer money;

    // 附加属性
    @Transient
    private Date createTimeStartSearch;//查询条件：起始创建时间
    @Transient
    private Date createTimeEndSearch;//查询条件：终止创建时间

    public User() {
    }

    public User(String userName, Integer userAge, Integer userSex, String userTel, Integer userState, Date createTime, Integer money) {
        this.userName = userName;
        this.userAge = userAge;
        this.userSex = userSex;
        this.userTel = userTel;
        this.userState = userState;
        this.createTime = createTime;
        this.money = money;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getCreateTimeStartSearch() {
        return createTimeStartSearch;
    }

    public void setCreateTimeStartSearch(Date createTimeStartSearch) {
        this.createTimeStartSearch = createTimeStartSearch;
    }

    public Date getCreateTimeEndSearch() {
        return createTimeEndSearch;
    }

    public void setCreateTimeEndSearch(Date createTimeEndSearch) {
        this.createTimeEndSearch = createTimeEndSearch;
    }
}
