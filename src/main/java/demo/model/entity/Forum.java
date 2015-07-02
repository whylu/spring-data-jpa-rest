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
import javax.persistence.OneToMany;

/**
 * 程式資訊摘要：<P>
 * 類別名稱　　：Forum.java<P>
 * 程式內容說明：<P>
 * 程式修改記錄：<P>
 * XXXX-XX-XX：<P>
 *@author minglungweng
 *@version 1.0
 *@since 1.0
 */
//@Table(name="forum")
@Entity
public class Forum {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="forumKey", length=50, nullable=false, unique=true)
    private String key;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="forum")
    private List<Post> posts = new ArrayList<Post>();
    
    public Forum() {    
    }
    
    public Forum(String forumKey) {
        this.key = forumKey;
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

    /**
     * @return the posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * @param posts the posts to set
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
