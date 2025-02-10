package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public void write(Article article){

        articleRepository.save(article);
    }

    public List<Article> articleList(){

        return articleRepository.findAll(); //Article이라는 클래스가 담긴 리스트를 반환
    }
}
