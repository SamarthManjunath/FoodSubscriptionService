package com.java.foodSubscription.service.serviceImpl;

import com.java.foodSubscription.dto.ChefLoginDTO;
import com.java.foodSubscription.model.Chef;
import com.java.foodSubscription.repository.ChefRepository;
import com.java.foodSubscription.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChefServiceImpl implements ChefService {

    private final ChefRepository chefRepository;
    private final PasswordEncoder passwordEncoder;

    public ChefServiceImpl(ChefRepository chefRepository, PasswordEncoder passwordEncoder) {
        this.chefRepository = chefRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Chef addChef(Chef chef) {
        //this can be optimized by mutating the same obj
        String chefEmail = chef.getEmail(); //since ID increments automatically, using email to check for existing chef
        Optional<Chef> existingChef = chefRepository.findByEmail(chefEmail);
        if(existingChef.isPresent()){
            throw new DuplicateKeyException("Chef already exists");
        }
        String hashedPassword = passwordEncoder.encode(chef.getPassword());
        Chef hashChef = new Chef();
        hashChef.setId(chef.getId());
        hashChef.setPassword(hashedPassword);
        hashChef.setFirstName(chef.getFirstName());
        hashChef.setLastName(chef.getLastName());
        hashChef.setEmail(chef.getEmail());

         return chefRepository.save(hashChef);
    }

    //used for login
    @Override
    public Optional<Chef> getChef(ChefLoginDTO chef) {
        String chefEmail = chef.getEmail();
        Optional<Chef> existingChef = chefRepository.findByEmail(chefEmail);
        if(existingChef.isPresent()){
            //check if password matches
            boolean isPasswordMatch = passwordEncoder.matches(chef.getPassword(), existingChef.get().getPassword());
            if(isPasswordMatch){
                return existingChef;
            }else {
                return Optional.empty();
            }
        }else {
            return Optional.empty();
        }
    }

}
