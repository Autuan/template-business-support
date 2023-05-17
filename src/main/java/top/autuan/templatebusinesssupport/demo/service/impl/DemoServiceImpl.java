package top.autuan.templatebusinesssupport.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.autuan.templatebusinesssupport.article.entity.Article;
import top.autuan.templatebusinesssupport.article.mapper.ArticleMapper;
import top.autuan.templatebusinesssupport.demo.mapper.CustomizeDemoMapper;
import top.autuan.templatebusinesssupport.demo.service.DemoService;

@Slf4j
@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {
    private final CustomizeDemoMapper customizeDemoMapper;

    private final ArticleMapper articleMapper;

    @Override
    public String queryStr() {
        return customizeDemoMapper.queryStr();
    }

    @Override
    public Article queryArticle(){
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1);
        Article article = articleMapper.selectOne(queryWrapper);
        return article;
    }
}
