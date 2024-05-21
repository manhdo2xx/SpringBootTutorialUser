package com.example.user.Service;

import com.example.user.Model.UserModel;
import com.example.user.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Override
    public void createUser(UserModel userModel) {
        userRepo.save(userModel);
    }

    @Override
    public void updateUser(String id, UserModel userModel) {
        if (userRepo.existsById(Long.valueOf(id))) {
            userModel.setId(Integer.parseInt(id));
            userRepo.save(userModel);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public Collection<UserModel> getUserModels() {
        return userRepo.findAll();
    }
}
