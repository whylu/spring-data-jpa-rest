/*
 * Copyright© Institute for Information Industry
 * All rights reserved.
 * 本程式碼係屬財團法人資訊工業策進會版權所有，在未取得本會書面同意前，不得複製、散佈或修改。
 */
package demo.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 程式資訊摘要：<P>
 * 類別名稱　　：Post.java<P>
 * 程式內容說明：<P>
 * 程式修改記錄：<P>
 * XXXX-XX-XX：<P>
 *@author minglungweng
 *@version 1.0
 *@since 1.0
 */

//@Table(name="post")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="postKey", length=50, nullable=false)
    private String key;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="post")
    private List<Recommend> recommends = new ArrayList<Recommend>();
    
    @ManyToOne
    @JoinColumn(name="forum_id")
    private Forum forum;
    
    public Post() {
    }
    
    public Post(String postKey, Forum forum) {
        this.key = postKey;
        this.forum = forum;
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

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the recommends
     */
    public List<Recommend> getRecommends() {
        return recommends;
    }

    /**
     * @param recommends the recommends to set
     */
    public void setRecommends(List<Recommend> recommends) {
        this.recommends = recommends;
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
