package br.com.leonardojorge98.ProjetoJAVA.Models.ResponseModels;

import br.com.leonardojorge98.ProjetoJAVA.Models.RequestModels.ArticleUserRequest;

import java.time.Instant;

public class ArticleResponse {
    public String title;

    public String resume;

    public String text;

    public Instant registeredAt;

    public ArticleUserRequest User;

    public ArticleResponse(String title, String resume, String text) {
        this.title = title;
        this.resume = resume;
        this.text = text;
    }
}
