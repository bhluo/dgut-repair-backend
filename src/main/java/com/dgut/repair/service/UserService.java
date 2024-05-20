package com.dgut.repair.service;

import com.dgut.repair.Response;
import com.dgut.repair.dao.User;

public interface UserService {
    public User getUserById(int id);
    public int addUser(User user);
    public Response loginCheck(String user_name,String user_psd);
}
