package com.weixiao.controller;

import com.weixiao.domain.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArticleControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * 查询数据库中的数据，数据必须存在
     */
    @Test
    void testFindArticleById() {
        Long id = 1l;
        Article article = this.restTemplate.getForObject("http://localhost:" + port + "/article/" + id, Article.class);
        assertEquals(id, article.getId());
    }
}