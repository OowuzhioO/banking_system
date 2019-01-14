package com.hwj.banking.Service;

import com.hwj.banking.Dao.UserDao;
import com.hwj.banking.entity.User;
import com.hwj.banking.entity.UserDetail;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();

    public int addUser(String name, String password, String email, String phone, String remark) {
        User user = new User();
        user.setuName(name);
        user.setuPassword(password);
        UserDetail userDetail = new UserDetail();
        userDetail.setEmail(email);
        userDetail.setCelephone(phone);
        userDetail.setRemark(remark);
        return userDao.add(user, userDetail);
    }

    public int deleteUser(int id) {
        User user = new User();
        user.setId(id);
        return userDao.delete(user);
    }

    public int updateUser(int id, String name, String password, String email, String phone, String remark) {
        User user = new User();
        user.setId(id);
        user.setuName(name);
        user.setuPassword(password);
        UserDetail userDetail = new UserDetail();
        userDetail.setEmail(email);
        userDetail.setCelephone(phone);
        userDetail.setRemark(remark);
        return userDao.update(user, userDetail);
    }

    public String findUser(int id) {
        return userDao.find(id);
    }

    public List<User> findUsers() {
        return userDao.findAll();
    }

}
