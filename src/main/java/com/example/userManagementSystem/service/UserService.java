package com.example.userManagementSystem.service;

import com.example.userManagementSystem.repository.UserDao;
import com.example.userManagementSystem.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> getAllUsersFromService(){
        return userDao.getAllUsersFromRepository();
    }
    public String addUserInService(User user){
        boolean insertion = userDao.save(user);
        if(insertion){
            return "User added succesfully!!!!!!";
        }
        else{
            return "failed!!!!!!.....Insertion not possible";
        }
    }
    public User getUserByIdFromService(String userId){
        List<User> currentUsers = userDao.getAllUsersFromRepository();
        for(User user: currentUsers){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;

    }
    public String removeUserById(String userId){
        boolean deleteResponse = false;
        String status;
        if(userId != null){
            List<User> currentUsers = userDao.getAllUsersFromRepository();
            for(User user: currentUsers){
                if(user.getUserId().equals(userId)){
                    deleteResponse = userDao.remove(user);
                    if(deleteResponse){
                        status = "user with " + userId + " was deleted...";
                    }
                    else{
                        status = "user with " + userId + " was not possible deleted...";
                    }
                    return status;
                }
            }
            return "user with " + userId + " does not exist";
        }
        else{
            return "Invalid id!!!... can not accept null userId";
        }
    }
    public String updateUserById(String userId, String status){

               boolean updateStatus = userDao.update(userId, status);
               if(updateStatus){
                   return "user with " + userId + " was updated...";
               }
               else{
                    return "user with " + userId + " was not updated...";
               }


    }
}
