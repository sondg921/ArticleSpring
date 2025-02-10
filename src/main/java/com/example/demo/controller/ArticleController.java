package com.example.demo.controller;

import com.example.demo.entity.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/write") //localhost:8080/article/write 주소로 접속시 ArticleWrite 파일을 보여주겠다는 의미
    public String articleWriteFprm(){

        return "ArticleWrite";
    }

    @PostMapping("/article/writepro")
    public String articleWritePro(Article article){

        articleService.write(article);

        return "";
    }

    @GetMapping("/article/list")
    public String articleList(Model model){ //데이터를 담아서 우리가 쓰는 페이지로 보내주는 model

        model.addAttribute("list", articleService.articleList());

        return "ArticleList";
    }
}
