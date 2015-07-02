/*
 * Copyright© Institute for Information Industry
 * All rights reserved.
 * 本程式碼係屬財團法人資訊工業策進會版權所有，在未取得本會書面同意前，不得複製、散佈或修改。
 */
package demo.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import demo.model.entity.Recommend;

/**
 * 程式資訊摘要：<P>
 * 類別名稱　　：RecommendDao.java<P>
 * 程式內容說明：<P>
 * 程式修改記錄：<P>
 * XXXX-XX-XX：<P>
 *@author minglungweng
 *@version 1.0
 *@since 1.0
 */
public interface RecommendDao extends CrudRepository<Recommend, Long>{

    

    @Query("SELECT r FROM Recommend r WHERE r.post.forum.key=?1 AND r.post.key=?2 AND r.key=?3")
    public Recommend find(String forumKey, String postKey, String recommendKey);
    
}
