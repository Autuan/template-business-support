package top.autuan.templatebusinesssupport.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.autuan.templatebusinesssupport.article.entity.Article;
import top.autuan.templatebusinesssupport.article.entity.ArticleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {
    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(@Param("record") Article record, @Param("selective") Article.Column ... selective);

    Article selectOneByExample(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example, @Param("selective") Article.Column ... selective);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(@Param("record") Article record, @Param("selective") Article.Column ... selective);

    int updateByPrimaryKey(Article record);

    int batchInsert(@Param("list") List<Article> list);

    int batchInsertSelective(@Param("list") List<Article> list, @Param("selective") Article.Column ... selective);
}