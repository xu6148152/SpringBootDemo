package com.binea.cms.model;

/**
 * Created by binea
 * Date: 30/11/2017
 * TIME: 10:49 PM
 */
public class CmsCategory {
    private Integer categoryId;

    private Integer pid;

    private Byte level;

    private String name;

    private String description;

    private String icon;

    private Byte type;

    private String alias;

    private Long ctime;

    private Long orders;

    private static final long serialVersionUID = 1L;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getOrders() {
        return orders;
    }

    public void setOrders(Long orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "CmsCategory{" +
                "categoryId=" + categoryId +
                ", pid=" + pid +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", type=" + type +
                ", alias='" + alias + '\'' +
                ", ctime=" + ctime +
                ", orders=" + orders +
                '}';
    }
}