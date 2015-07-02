/*
 * Copyright© Institute for Information Industry
 * All rights reserved.
 * 本程式碼係屬財團法人資訊工業策進會版權所有，在未取得本會書面同意前，不得複製、散佈或修改。
 */
package demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 程式資訊摘要：<P>
 * 類別名稱　　：Recommend.java<P>
 * 程式內容說明：<P>
 * 程式修改記錄：<P>
 * XXXX-XX-XX：<P>
 *@author minglungweng
 *@version 1.0
 *@since 1.0
 */
@Entity
public class Recommend {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="recommendKey", length=50, nullable=false)
    private String key;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;
    
    public Recommend() {
    }
    
    public Recommend(String recommendKey, Post post) {
        this.key = recommendKey;
        this.post = post;
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
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }
}
