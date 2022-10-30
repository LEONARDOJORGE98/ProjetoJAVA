package br.com.leonardojorge98.ProjetoJAVA.Models.ResponseModels;

import br.com.leonardojorge98.ProjetoJAVA.Models.User;

import java.time.Instant;

public class UserResponse {

    public String uuid;
    public String username;
    public Instant registeredAt;

    public UserResponse(User user) {
        this.uuid = user.getUuid();
        this.username = user.getUsername();
        this.registeredAt = user.getRegisteredAt();
    }

}
