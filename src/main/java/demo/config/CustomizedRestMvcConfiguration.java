/*
 * Copyright© Institute for Information Industry
 * All rights reserved.
 * 本程式碼係屬財團法人資訊工業策進會版權所有，在未取得本會書面同意前，不得複製、散佈或修改。
 */
package demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import demo.model.entity.Post;

/**
 * 程式資訊摘要：<P>
 * 類別名稱　　：CustomizedRestMvcConfiguration.java<P>
 * 程式內容說明：<P>
 * 程式修改記錄：<P>
 * XXXX-XX-XX：<P>
 *@author minglungweng
 *@version 1.0
 *@since 1.0
 */
@Configuration
public class CustomizedRestMvcConfiguration extends RepositoryRestMvcConfiguration {

    @Override
    public RepositoryRestConfiguration config() {
        RepositoryRestConfiguration config = super.config();
        config.exposeIdsFor(Post.class);
        config.setBasePath("/api");
        return config;
    }
}
