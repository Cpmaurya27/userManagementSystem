package com.example.userManagementSystem.repository;

import com.example.userManagementSystem.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    private List<User> userList;
    public UserDao(){
        userList = new ArrayList<>();
        //Dummy Adding for testing purpose...
        userList.add(new User("01", "Cp Maurya", "cpmaurya", "up", "2045552254"));
    }

    public List<User> getAllUsersFromRepository(){
        return userList;
    }

    public boolean save(User user){
        userList.add(user);
        return true;
    }

    public boolean remove(User user){
        userList.remove(user);
        return true;
    }
    public boolean update(String userId, String status){
        boolean updateStatus = false;
        for(User user: userList){
            if(user.getUserId().equals(userId)){
                remove(user);
                user.setName(status);
                save(user);
                return true;
            }

        }
        return false;
    }
}
