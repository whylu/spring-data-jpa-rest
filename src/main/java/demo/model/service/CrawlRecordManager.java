/*
 * Copyright© Institute for Information Industry
 * All rights reserved.
 * 本程式碼係屬財團法人資訊工業策進會版權所有，在未取得本會書面同意前，不得複製、散佈或修改。
 */
package demo.model.service;

import java.util.List;

import demo.model.entity.CrawlRecord;
import demo.model.entity.Forum;
import demo.model.entity.Post;
import demo.model.entity.Recommend;

/**
 * 程式資訊摘要：<P>
 * 類別名稱　　：CrawlRecordManager.java<P>
 * 程式內容說明：<P>
 * 程式修改記錄：<P>
 * XXXX-XX-XX：<P>
 *@author minglungweng
 *@version 1.0
 *@since 1.0
 */
public interface CrawlRecordManager {
    
    public Forum getForum(String forumKey);

    public Post getPost(String forumKey, String postKey);
    
    public Recommend getRecommend(String forumKey, String postKey, String recommendKey);
    
    public CrawlRecord getCrawlRecord(String forumKey, String postKey);

    /**
     * get records by forumKey
     * @param forumKey
     * @return
     */
    public List<CrawlRecord> getRecords(String forumKey);
    
    /**
     * check if recommend exist in DB
     * @param forumKey
     * @param postKey
     * @param recommendKey
     * @return
     */
    public boolean isReommendExist(String forumKey, String postKey, String recommendKey);
    
    /**
     * if forum not exist, create one, 
     * if post not exist, create one, 
     * if recommend not exist create one, else return null, 
     * if recommend created, return recommend
     * @param forumKey
     * @param postKey
     * @param recommendKey
     * @return
     */
    public Recommend addRecommand(String forumKey, String postKey, String recommendKey);
    

    /**
     * add a crawl record, must contain forumKey, postKey, url, 
     * if a CrawlRecord exist with the same  forumKey, postKey, then return null,
     * please use updateCrawlRecord to update a CrawlRecord   
     * @param record
     * @return
     */
    public CrawlRecord addCrawlRecord(String forumKey, String postKey, String url);
    
    /**
     * update a crawlrecord, must contain forumKey, postKey, url, then return updated-crawlrecord
     * if crawlrecord not exist,  return null
     * @param record
     * @return
     */
    public CrawlRecord updateCrawlRecord(String forumKey, String postKey, String url);
    
    
}
