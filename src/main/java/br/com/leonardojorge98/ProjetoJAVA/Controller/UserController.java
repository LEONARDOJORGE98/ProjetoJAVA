package br.com.leonardojorge98.ProjetoJAVA.Controller;

import br.com.leonardojorge98.ProjetoJAVA.Models.RequestModels.UserRequest;
import br.com.leonardojorge98.ProjetoJAVA.Models.ResponseModels.UserResponse;
import br.com.leonardojorge98.ProjetoJAVA.Models.User;
import br.com.leonardojorge98.ProjetoJAVA.Repositories.User.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserRepository userRepository;


    @GetMapping
    public List<User> Get() {
        return userRepository.findAll();
    }

    @PostMapping
    public UserResponse Post(@RequestBody UserRequest userRequest) {
        User user = new User(userRequest.username, userRequest.password);
        var createdUser = userRepository.save(user);
        UserResponse response = new UserResponse(createdUser);
        return response;

    }
    
    @PutMapping(value = "/{uuid}")
    public void Put(@RequestBody UserRequest userRequest, @PathVariable("uuid") String uuid) {

        Optional<User> userOptional = userRepository.findByUuid(uuid);

        userOptional.get().setUsername(userRequest.username);
        userOptional.get().setPassword(userRequest.password);

        this.userRepository.save(userOptional.get());

    }

    @GetMapping(value = "/{uuid}")
    public User GetUser(@PathVariable("uuid") String uuid) {
        Optional<User> user = this.userRepository.findByUuid(uuid);
        return user.get();
    }

    @DeleteMapping("/{uuid}")
    public void Delete(@PathVariable("uuid") String uuid) {
        Optional<User> user = this.userRepository.findByUuid(uuid);
        userRepository.delete(user.get());
    }
}
