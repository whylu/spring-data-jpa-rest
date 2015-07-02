/*
 * Copyright© Institute for Information Industry
 * All rights reserved.
 * 本程式碼係屬財團法人資訊工業策進會版權所有，在未取得本會書面同意前，不得複製、散佈或修改。
 */
package demo.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 程式資訊摘要：<P>
 * 類別名稱　　：CrawlRecord.java<P>
 * 程式內容說明：<P>
 * 程式修改記錄：<P>
 * XXXX-XX-XX：<P>
 *@author minglungweng
 *@version 1.0
 *@since 1.0
 */
//@Table(name="crawl_record")
@Entity
public class CrawlRecord {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne(optional=false, fetch=FetchType.EAGER)
    private Forum forum;
    
    @ManyToOne(optional=false, fetch=FetchType.EAGER)
    private Post post;

    @Column(nullable=false)
    private String url;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime = new Date();
    
    public CrawlRecord() {
    } 
    
    public CrawlRecord(Forum forum, Post post, String url) {
        this.forum = forum;
        this.post = post;
        this.url = url;
    }

    @PreUpdate
    private void updatedAt() {
      this.lastUpdateTime = new Date();
    }
    
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }


    /**
     * @return the post
     */
    public Post getPost() {
        return post;
    }


    /**
     * @param post the post to set
     */
    public void setPost(Post post) {
        this.post = post;
    }


    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }


    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }


    /**
     * @return the lastUpdateTime
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }


    /**
     * @param lastUpdateTime the lastUpdateTime to set
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }


    /**
     * @return the forum
     */
    public Forum getForum() {
        return forum;
    }


    /**
     * @param forum the forum to set
     */
    public void setForum(Forum forum) {
        this.forum = forum;
    }
    
    
    
}
