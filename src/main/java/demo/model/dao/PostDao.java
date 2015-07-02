/*
 * Copyright© Institute for Information Industry
 * All rights reserved.
 * 本程式碼係屬財團法人資訊工業策進會版權所有，在未取得本會書面同意前，不得複製、散佈或修改。
 */
package demo.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import demo.model.entity.Post;

/**
 * 程式資訊摘要：<P>
 * 類別名稱　　：PostDao.java<P>
 * 程式內容說明：<P>
 * 程式修改記錄：<P>
 * XXXX-XX-XX：<P>
 *@author minglungweng
 *@version 1.0
 *@since 1.0
 */
//@RepositoryRestResource
public interface PostDao extends PagingAndSortingRepository<Post, Long>{

    
    /**
     * find the post by forumKey-postKey, should be only one
     * @param forumKey
     * @param postKey
     * @return
     */
    @Query("SELECT p FROM Post p WHERE p.forum.key=?1 AND p.key=?2")
    public Post find(String forumKey, String postKey);
}
