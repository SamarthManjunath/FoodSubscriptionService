package com.java.foodSubscription.service.serviceImpl;

import com.java.foodSubscription.dto.UserLoginDTO;
import com.java.foodSubscription.model.Chef;
import com.java.foodSubscription.model.Users;
import com.java.foodSubscription.repository.UserRepository;
import com.java.foodSubscription.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Users addUser(Users users) {
        //check if the user already exists
        String userEmail = users.getEmail();
        Optional<Users> existingUser = userRepository.findByEmail(userEmail);
        if(existingUser.isPresent()){
            throw new DuplicateKeyException("User already exists");
        }
        String hashedPassword =  passwordEncoder.encode(users.getPassword());
        Users hashedUser = new Users();
        //updating the user with new hashed password
        //hashedUser.setId(users.getId());
        hashedUser.setPassword(hashedPassword);
        hashedUser.setEmail(users.getEmail());
        hashedUser.setFirstName(users.getFirstName());
        hashedUser.setLastName(users.getLastName());

        return userRepository.save(hashedUser);
    }

    @Override
    public Optional<Users> getUsers(UserLoginDTO userLoginDTO) {
        String email = userLoginDTO.getEmail();
        Optional<Users> existingUser = userRepository.findByEmail(email);
        if(existingUser.isPresent()){
            //check if password matches
            boolean isPasswordMatch = passwordEncoder.matches(userLoginDTO.getPassword(), existingUser.get().getPassword());
            if(isPasswordMatch){
                return existingUser;
            }else {
                return Optional.empty();
            }
        }else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Users> getUserById(int userId) {
        //Long longUserId = userId;
        return userRepository.findById(userId);
    }

}
