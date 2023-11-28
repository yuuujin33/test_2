package com.mysite.test_2.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
private final ArticleService articleService;
    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }

    @GetMapping("/create")
    public String create() {
        return "article_form";
    }

    @PostMapping("/create")
    public String create (Model model, @RequestParam(value = "subject") String subject, @RequestParam(value = "content") String content) {
        this.articleService.getArticle(subject, content);
        return "redirect:/article/list";
    }

    @GetMapping("/detail/{id}")
    public String detail (Model model, @PathVariable("id") Integer id) {
        Article article = this.articleService.getId(id);
        model.addAttribute("article", article);
        return "article_detail";
    }
}
