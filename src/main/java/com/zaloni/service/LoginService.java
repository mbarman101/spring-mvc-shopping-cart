package com.zaloni.service;

import com.zaloni.dao.ILoginDao;
import com.zaloni.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService implements ILoginService {

    @Autowired
    private ILoginDao logInDao;

    @Override
    @Transactional
    public User logMeIn(int uid){
      return  logInDao.getUserDetails(uid);
    }
}
