/*
 * Copyright© Institute for Information Industry
 * All rights reserved.
 * 本程式碼係屬財團法人資訊工業策進會版權所有，在未取得本會書面同意前，不得複製、散佈或修改。
 */
package demo.run.jpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.model.entity.CrawlRecord;
import demo.model.entity.Recommend;
import demo.model.service.CrawlRecordManager;
import demo.model.service.impl.BasicCrawlRecordManager;

/**
 * 程式資訊摘要：<P>
 * 類別名稱　　：MessageRunner.java<P>
 * 程式內容說明：<P>
 * 程式修改記錄：<P>
 * XXXX-XX-XX：<P>
 *@author minglungweng
 *@version 1.0
 *@since 1.0
 */
public class JpaExampleRunner01 {

    final static Logger logger = LoggerFactory.getLogger(JpaExampleRunner01.class);
    
    static ApplicationContext applicationContext;
    static CrawlRecordManager recordManager;
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        logger.info("Initializing Spring context.");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        recordManager = (BasicCrawlRecordManager) applicationContext.getBean("basicCrawlRecordManager");
        logger.info("Spring context initialized.");

        initData();
//----------------------------------------------------------------------------------
        
        
        
//----------------------------------------------------------------------------------        
        demo();
        
        
        ((ConfigurableApplicationContext)applicationContext).close();
    }

    /**
     * 
     */
    private static void initData() {
        insertRecommend("forum01", "post01", "r01");
        insertRecommend("forum01", "post01", "r02");
        insertRecommend("forum01", "post01", "r03");
        
        insertRecommend("forum02", "post01", "r01");
        insertRecommend("forum02", "post01", "r02");
        insertRecommend("forum02", "post01", "r03");
        
        insertCrawlRecord("forum03", "post01");
        insertCrawlRecord("forum03", "post02");
        insertCrawlRecord("forum03", "post03");
        
    }

    /**
     * @param string
     * @param string2
     */
    private static void insertCrawlRecord(String forumKey, String postKey) {
        recordManager.addCrawlRecord(forumKey, postKey, "http://"+forumKey+"/"+postKey);
    }

    /**
     * 
     */
    private static void demo() {

        //demo for get
        Recommend r01 = recordManager.getRecommend("forum01", "post01", "r01");
        logger.debug("r01={}", r01.getKey());
        Recommend r02 = recordManager.getRecommend("forum02", "post01", "r01");
        logger.debug("r02={}", r02.getKey());
        
        
        //demo for isReommendExist
        logger.debug("recordManager.isReommendExist(forum01, post01, r01)={}", recordManager.isReommendExist("forum01", "post01", "r01"));
        logger.debug("recordManager.isReommendExist(forum02, post01, r01)={}", recordManager.isReommendExist("forum02", "post01", "r01"));
        logger.debug("recordManager.isReommendExist(forum02, post02, r01)={}", recordManager.isReommendExist("forum02", "post02", "r01"));
        logger.debug("recordManager.isReommendExist(forum03, post01, r01)={}", recordManager.isReommendExist("forum03", "post01", "r01"));
        
        
        //demo for record update
        CrawlRecord cr = recordManager.getCrawlRecord("forum03", "post01");
        logger.debug("before updateCrawlRecord:" + cr.getLastUpdateTime().getTime() + "  "+ cr.getUrl());
        cr = recordManager.updateCrawlRecord("forum03", "post01", "http://updated/"+String.valueOf(Math.random()));
        logger.debug("after updateCrawlRecord:" + cr.getLastUpdateTime().getTime() + "  "+ cr.getUrl());
        
        //demo for get records by forumkey
        List<CrawlRecord> records = recordManager.getRecords("forum03");
        logger.debug("records.size="+records.size());
        for(CrawlRecord cr1 : records) {
            logger.debug("cr="+cr1.getForum().getKey()+"-"+cr1.getPost().getKey()+" >> "+cr1.getUrl());
        }
        
    }

    /**
     * @param string
     * @param string2
     * @param string3
     */
    private static void insertRecommend(String forumKey, String postKey, String recommendKey) {
        recordManager.addRecommand(forumKey, postKey, recommendKey);
        
    }

    /**
     * @param string
     * @param string2
     * @param string3
     */
    private static void insertRecord(String forumKey, String postKey, String url) {
        
//        Forum f = new Forum();
//        f.setKey(forumKey);
//        
//        Post p = new Post();
//        p.setKey(postKey);
//        
//        
//        recordManager
//        
        
    }

}
