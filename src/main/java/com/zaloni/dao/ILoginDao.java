package com.zaloni.dao;

import com.zaloni.entity.User;

public interface ILoginDao {

    User getUserDetails(int userId);
}
