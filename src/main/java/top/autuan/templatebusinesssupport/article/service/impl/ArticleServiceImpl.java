package top.autuan.templatebusinesssupport.article.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.db.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.autuan.templatebusinesssupport.article.entity.Article;
import top.autuan.templatebusinesssupport.article.entity.ArticleExample;
import org.springframework.stereotype.Service;
import top.autuan.templatebusinesssupport.article.mapper.ArticleMapper;
import top.autuan.templatebusinesssupport.article.service.ArticleService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleMapper articleMapper;
    @Override
    public void add(Article article) {
        log.info("ArticleServiceImpl -> add -> start ->  {}", article);
        long id = IdUtil.getSnowflake().nextId();
        article.setId(id);
        articleMapper.insertSelective(article);
        log.info("ArticleServiceImpl -> add -> end -> {}",article.getTitle());
    }

    @Override
    public void edit(Article article) {
        log.info("ArticleServiceImpl -> edit -> start -> {}",article);
        articleMapper.updateByPrimaryKeySelective(article);
        log.info("ArticleServiceImpl -> edit -> end -> {}",article.getId());
    }

    @Override
    public void abandon(Long id) {
        log.info("ArticleServiceImpl -> abandon -> start ->   {}",id);
        Article obj = Article.builder()
                .id(id)
                .delFlag((byte) 1)
                .build();
        articleMapper.updateByPrimaryKeySelective(obj);
        log.info("ArticleServiceImpl -> abandon -> end -> {}",id);
    }

    @Override
    public PageInfo<Article> listBySubject(Page page, Integer subject) {
        ArticleExample example = new ArticleExample();
        example.createCriteria()
                .andStatusEqualTo(1)
                .andDelFlagEqualTo((byte) 0)
                .andSubjectEqualTo(subject);
        PageHelper.startPage(page.getPageNumber(), page.getPageSize());
//        log.info("ArticleServiceImpl -> start -> listBySubject ->  {}", example);
        List<Article> articles = articleMapper.selectByExample(example);
//        log.info("ArticleServiceImpl -> end -> listBySubject ->  {}",articles);
        PageInfo<Article> result = new PageInfo<>(articles);
        return result;
    }

    @Override
    public Article detail(Long id) {
        Article article = articleMapper.selectByPrimaryKey(id);
        return article;
    }
}
