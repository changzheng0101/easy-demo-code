package com.weixiao.mapper;

import com.weixiao.domain.Article;

/**
 * @author changzheng
 * @date 2025年10月24日 16:56
 */
public interface ArticleMapper {
    Article findById(Long id);
}
