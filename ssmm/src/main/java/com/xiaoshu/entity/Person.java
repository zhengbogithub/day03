package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "p_person")
public class Person implements Serializable {
    @Id
    private Integer pid;

    @Column(name = "p_name")
    private String pName;

    private String gender;

    private Integer cid;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date cometime;

    private static final long serialVersionUID = 1L;

    /**
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return p_name
     */
    public String getpName() {
        return pName;
    }

    /**
     * @param pName
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * @return cid
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * @param cid
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * @return cometime
     */
    public Date getCometime() {
        return cometime;
    }

    /**
     * @param cometime
     */
    public void setCometime(Date cometime) {
        this.cometime = cometime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", pName=").append(pName);
        sb.append(", gender=").append(gender);
        sb.append(", cid=").append(cid);
        sb.append(", cometime=").append(cometime);
        sb.append("]");
        return sb.toString();
    }
}