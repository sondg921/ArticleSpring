package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    // 글 작성 처리
    public void articlewrite(Article article, MultipartFile file) throws Exception {

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files";

        UUID uuid = UUID.randomUUID();

        String filename = uuid + "_" + file.getOriginalFilename(); //식별자_파일이름

        File saveFile = new File(projectPath, filename);

        file.transferTo(saveFile);

        article.setFileName(filename);
        article.setFilePath("/files/" + filename);

        articleRepository.save(article);
    }

    // 게시글 리스트 처리
    public List<Article> articleList(){

        return articleRepository.findAll(); //Article이라는 클래스가 담긴 리스트를 반환
    }

    // 특정 게시글 불러오기
    public Article articleView(Long id){

        return articleRepository.findById(id).get();
    }

    // 특정 게시글 삭제 처리
    public void articleDelete(Long id){

        articleRepository.deleteById(id);
    }
}
