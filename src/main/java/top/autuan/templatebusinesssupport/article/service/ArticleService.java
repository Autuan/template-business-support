package top.autuan.templatebusinesssupport.article.service;

import cn.hutool.db.Page;
import com.github.pagehelper.PageInfo;
import top.autuan.templatebusinesssupport.article.entity.Article;

public interface ArticleService {
    void add(Article article);

    void edit(Article article);

    void abandon(Long id);

    PageInfo<Article> listBySubject(Page page, Integer subject);

    Article detail(Long id);
}
