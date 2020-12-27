package com.dioni.bookrenting.services;

import com.dioni.bookrenting.controllers.dtos.UpdateUserBody;
import com.dioni.bookrenting.controllers.dtos.UserBody;
import com.dioni.bookrenting.entities.User;
import com.dioni.bookrenting.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void createUser(UserBody userBody) {
        if (userRepository.findByUsername(userBody.username) != null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Usuario ya existe con ese nombre");
        }
        User user = new User();
        user.username = userBody.username;
        user.password = userBody.password;
        userRepository.save(user); // insert en mysql de la tabla "user" (Metodo save hace un insert or update)
    }

    public void updateUser(String username, UpdateUserBody body) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        user.password = body.password;
        userRepository.save(user); // update en mysql de la tabla "user"
    }

    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        userRepository.delete(user);
    }

}
