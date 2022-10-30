package br.com.leonardojorge98.ProjetoJAVA.Controller;


import br.com.leonardojorge98.ProjetoJAVA.Models.Article;
import br.com.leonardojorge98.ProjetoJAVA.Models.RequestModels.ArticleRequest;
import br.com.leonardojorge98.ProjetoJAVA.Models.User;
import br.com.leonardojorge98.ProjetoJAVA.Repositories.Article.IArticleRepository;
import br.com.leonardojorge98.ProjetoJAVA.Repositories.User.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleRepository articleRepository;
    @Autowired
    private IUserRepository userRepository;


    @GetMapping
    public List<Article> Get() {
        return articleRepository.findAll();
    }

    @PostMapping
    public void Post(@RequestBody ArticleRequest articleRequest) {

        Optional<User> userOptional = userRepository.findByUuid(articleRequest.User.uuid);

        Article article = new Article(articleRequest.title,articleRequest.resume, articleRequest.text, userOptional.get());
        articleRepository.save(article);
    }

    @PutMapping(value = "/{uuid}")
    public void Put(@RequestBody ArticleRequest articleRequest, @PathVariable("uuid") String uuid) {

        Optional<Article> articleOptional = articleRepository.findByUuid(uuid);

        articleOptional.get().setTitle(articleRequest.title);
        articleOptional.get().setResume(articleRequest.resume);
        articleOptional.get().setText(articleRequest.text);

        this.articleRepository.save(articleOptional.get());
    }

    @GetMapping(value = "/{uuid}")
    public Optional<Article> GetUser(@PathVariable("uuid") String uuid) {
        Optional<Article> article = this.articleRepository.findByUuid(uuid);
        return article;
    }
}
