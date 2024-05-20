package com.dgut.repair.service;

import com.dgut.repair.Response;
import com.dgut.repair.dao.User;
import com.dgut.repair.dao.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    @Override
    @Transactional
    public int addUser(User user) {
//        List<User> userList = userRepository.findByUser_phone(user.getUser_phone());
//        if(!CollectionUtils.isEmpty(userList)){
//            throw new IllegalStateException("phone:"+user.getUser_phone()+" has been taken");
//        }
        userRepository.save(user);
        return user.getUserid();
    }
    @Override
    @Transactional
    public Response loginCheck(String user_name,String user_psd){
        User user = userRepository.findByUsername(user_name);
        System.out.println(user);
        if(user == null){
            return Response.newFail("用户不存在");
        }else if(user.getUser_psd().equals(user.getUser_name())){
            return Response.newSuccess(user);
        }else{
            return Response.newFail("密码错误");
        }
    }
}
