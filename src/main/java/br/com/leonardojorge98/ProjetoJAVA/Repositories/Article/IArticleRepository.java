package br.com.leonardojorge98.ProjetoJAVA.Repositories.Article;

import br.com.leonardojorge98.ProjetoJAVA.Models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IArticleRepository extends JpaRepository<Article, Long> {

    Optional<Article> findByUuid(String uuid);

}