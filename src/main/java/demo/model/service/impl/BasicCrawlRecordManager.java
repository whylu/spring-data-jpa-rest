/*
 * Copyright© Institute for Information Industry
 * All rights reserved.
 * 本程式碼係屬財團法人資訊工業策進會版權所有，在未取得本會書面同意前，不得複製、散佈或修改。
 */
package demo.model.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.dao.CrawlRecordDao;
import demo.model.dao.ForumDao;
import demo.model.dao.PostDao;
import demo.model.dao.RecommendDao;
import demo.model.entity.CrawlRecord;
import demo.model.entity.Forum;
import demo.model.entity.Post;
import demo.model.entity.Recommend;
import demo.model.service.CrawlRecordManager;

/**
 * 程式資訊摘要：<P>
 * 類別名稱　　：BasicCrawlRecordManager.java<P>
 * 程式內容說明：<P>
 * 程式修改記錄：<P>
 * XXXX-XX-XX：<P>
 *@author minglungweng
 *@version 1.0
 *@since 1.0
 */
@Service("basicCrawlRecordManager")
public class BasicCrawlRecordManager implements CrawlRecordManager {
    private final static Logger logger = LoggerFactory.getLogger(BasicCrawlRecordManager.class);
    
    @Autowired
    private ForumDao forumDao;
    
    @Autowired
    private PostDao postDao;
    
    @Autowired
    private RecommendDao recommendDao;
    
    @Autowired
    private CrawlRecordDao crawlRecordDao;
    
    
    /* (non-Javadoc)
     * @see demo.model.service.CrawlRecordManager#getRecords(java.lang.String)
     */
    @Override
    public List<CrawlRecord> getRecords(String forumKey) {
        return crawlRecordDao.findByForumKey(forumKey);
    }

    /* (non-Javadoc)
     * @see demo.model.service.CrawlRecordManager#checkReommendExist(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public boolean isReommendExist(String forumKey, String postKey, String recommendKey) {
        Recommend recommend = recommendDao.find(forumKey, postKey, recommendKey);
        return recommend!=null;
    }

    
    /* (non-Javadoc)
     * @see demo.model.service.CrawlRecordManager#addRecommand(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Recommend addRecommand(String forumKey, String postKey, String recommendKey) {
        Recommend recommend = recommendDao.find(forumKey, postKey, recommendKey);
        if(recommend!=null) { //recommend exist, return null
            return null;
        }
        
        recommend = new Recommend(recommendKey, findOrCreatePost(forumKey, postKey));
        recommendDao.save(recommend);
        return recommend;
    }

    /* (non-Javadoc)
     * @see demo.model.service.CrawlRecordManager#add(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public CrawlRecord addCrawlRecord(String forumKey, String postKey, String url) {
        CrawlRecord crawlRecord = crawlRecordDao.find(forumKey, postKey);
        if(crawlRecord!=null) {
            return null;
        }
        
        Post post = findOrCreatePost(forumKey, postKey);
        crawlRecord = new CrawlRecord(post.getForum(), post, url);
        crawlRecordDao.save(crawlRecord);
        return crawlRecord;
    }

    /* (non-Javadoc)
     * @see demo.model.service.CrawlRecordManager#updateCrawlRecord(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public CrawlRecord updateCrawlRecord(String forumKey, String postKey, String url) {
        CrawlRecord crawlRecord = crawlRecordDao.find(forumKey, postKey);
        if(crawlRecord==null) {
            return null;
        }
        crawlRecord.setUrl(url);
        crawlRecordDao.save(crawlRecord);
        return crawlRecord;
    }


    /* (non-Javadoc)
     * @see demo.model.service.CrawlRecordManager#getForum(java.lang.String)
     */
    @Override
    public Forum getForum(String forumKey) {
        List<Forum> forums = forumDao.findByKey(forumKey);
        if(CollectionUtils.isEmpty(forums)) {
            logger.debug("There is no Forum.key={}", forumKey);
            return null;
        }
        return forums.get(0);
    }

    /* (non-Javadoc)
     * @see demo.model.service.CrawlRecordManager#getPost(java.lang.String, java.lang.String)
     */
    @Override
    public Post getPost(String forumKey, String postKey) {
        return postDao.find(forumKey, postKey);
    }
    
    /* (non-Javadoc)
     * @see demo.model.service.CrawlRecordManager#getRecommend(java.lang.String)
     */
    @Override
    public Recommend getRecommend(String forumKey, String postKey, String recommendKey) {
        return recommendDao.find(forumKey, postKey, recommendKey);
    }

    /* (non-Javadoc)
     * @see demo.model.service.CrawlRecordManager#gerCrawlRecord(java.lang.String, java.lang.String)
     */
    @Override
    public CrawlRecord getCrawlRecord(String forumKey, String postKey) {
        return crawlRecordDao.find(forumKey, postKey);
    }


    /**
     * if forum exist, return it
     * if forum not exist, create it, 
     * @param forumKey
     * @return
     */
    private Forum findOrCreateForum(String forumKey) {
        Forum forum = getForum(forumKey);
        if(forum==null) {
            forum = new Forum(forumKey);
            forumDao.save(forum);
        }
        return forum;
    }

    /**
     * if post exist, return it
     * if post not exist, create it, 
     * if post.forum not exist, create it.
     * @param forumKey
     * @param postKey
     * @return
     */
    private Post findOrCreatePost(String forumKey, String postKey) {
        Post post = postDao.find(forumKey, postKey);
        if(post==null) {
            post = new Post(postKey, findOrCreateForum(forumKey));
            postDao.save(post);
        }
        return post;
    }
    
    
}
