package com.binea.cms.dao.model;

/**
 * Created by binea
 * Date: 30/11/2017
 * TIME: 10:44 PM
 */
public class CmsArticle {
    private Integer articleId;

    private String title;

    private String author;

    private String fromurl;

    private String image;

    private String keywords;

    private String description;

    private Byte type;

    private Byte allowcomments;

    private Byte status;

    private Integer userId;

    private Integer up;

    private Integer down;

    private Integer readnumber;

    private Long ctime;

    private Long orders;

    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFromurl() {
        return fromurl;
    }

    public void setFromurl(String fromurl) {
        this.fromurl = fromurl;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getAllowcomments() {
        return allowcomments;
    }

    public void setAllowcomments(Byte allowcomments) {
        this.allowcomments = allowcomments;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    public Integer getReadnumber() {
        return readnumber;
    }

    public void setReadnumber(Integer readnumber) {
        this.readnumber = readnumber;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CmsArticle{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", fromurl='" + fromurl + '\'' +
                ", image='" + image + '\'' +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", allowcomments=" + allowcomments +
                ", status=" + status +
                ", userId=" + userId +
                ", up=" + up +
                ", down=" + down +
                ", readnumber=" + readnumber +
                ", ctime=" + ctime +
                ", orders=" + orders +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CmsArticle other = (CmsArticle) that;
        return (this.getArticleId() == null ? other.getArticleId() == null : this.getArticleId().equals(
                other.getArticleId()))
                && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
                && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
                && (this.getFromurl() == null ? other.getFromurl() == null : this.getFromurl().equals(
                other.getFromurl()))
                && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
                && (this.getKeywords() == null ? other.getKeywords() == null : this.getKeywords().equals(
                other.getKeywords()))
                && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(
                other.getDescription()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getAllowcomments() == null ? other.getAllowcomments() == null : this.getAllowcomments().equals(
                other.getAllowcomments()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getUp() == null ? other.getUp() == null : this.getUp().equals(other.getUp()))
                && (this.getDown() == null ? other.getDown() == null : this.getDown().equals(other.getDown()))
                && (this.getReadnumber() == null ? other.getReadnumber() == null : this.getReadnumber().equals(
                other.getReadnumber()))
                && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
                && (this.getOrders() == null ? other.getOrders() == null : this.getOrders().equals(other.getOrders()))
                && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(
                other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getFromurl() == null) ? 0 : getFromurl().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getKeywords() == null) ? 0 : getKeywords().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getAllowcomments() == null) ? 0 : getAllowcomments().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUp() == null) ? 0 : getUp().hashCode());
        result = prime * result + ((getDown() == null) ? 0 : getDown().hashCode());
        result = prime * result + ((getReadnumber() == null) ? 0 : getReadnumber().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getOrders() == null) ? 0 : getOrders().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}