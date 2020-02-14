package com.zx.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 附件类
 * <p/>
 * Created by zhangxin on 2015-08-13.
 */
@Entity
@Table(name = "annex")
public class Annex {

    @Id
    @GeneratedValue(generator = "myGenerator")
    @GenericGenerator(name = "myGenerator", strategy = "uuid")
    @Column(name = "annex_id", unique = true, nullable = false)
    private String annexId;

    @Column(name = "annex_path")
    private String annexPath;

    @Column(name = "annex_name")
    private String annexName;

    @Column(name = "create_time")
    private Date createTime;

    public Annex() {
    }

    public Annex(String annexPath, String annexName, Date createTime) {
        this.annexPath = annexPath;
        this.annexName = annexName;
        this.createTime = createTime;
    }

    public String getAnnexId() {
        return annexId;
    }

    public void setAnnexId(String annexId) {
        this.annexId = annexId;
    }

    public String getAnnexPath() {
        return annexPath;
    }

    public void setAnnexPath(String annexPath) {
        this.annexPath = annexPath;
    }

    public String getAnnexName() {
        return annexName;
    }

    public void setAnnexName(String annexName) {
        this.annexName = annexName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
