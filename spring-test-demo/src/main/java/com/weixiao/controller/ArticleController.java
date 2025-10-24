package com.weixiao.controller;

import com.weixiao.domain.Article;
import com.weixiao.mapper.ArticleMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changzheng
 * @date 2025年10月24日 17:03
 */
@RestController
public class ArticleController {
    @Resource
    private ArticleMapper articleMapper;

    @GetMapping("/article/{id}")
    public Article findById(@PathVariable("id") Long id) {
        return articleMapper.findById(id);
    }
}
