package com.mysite.test_2.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;


    public List<Article> getList() {
        List<Article> articleList = this.articleRepository.findAll();
        return articleList;
    }

    public void getArticle(String subject, String content) {
        Article article = new Article();
        article.setSubject(subject);
        article.setContent(content);
        this.articleRepository.save(article);
    }

    public Article getId(Integer id) {
        Optional<Article> article = this.articleRepository.findById(id);
        return article.get();
    }
}
