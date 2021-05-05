package com.company.service;

import com.company.domain.UserVO;

public interface RegService {
    public boolean fingSameId(String userId);
    public boolean insertUser(UserVO vo);
    public String login(UserVO vo);
    public boolean loginAjax(UserVO vo);
    public UserVO mypage(String id);
    public boolean changeUserInfo(UserVO vo);
}
