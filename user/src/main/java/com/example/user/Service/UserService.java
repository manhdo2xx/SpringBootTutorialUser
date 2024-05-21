package com.example.user.Service;

import com.example.user.Model.UserModel;

import java.util.Collection;

public interface UserService {
    public abstract void createUser(UserModel userModel);
    public abstract void updateUser(String id,UserModel userModel);
    public abstract void deleteUser(Long id);
    public abstract Collection<UserModel> getUserModels();
}
