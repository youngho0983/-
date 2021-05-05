package com.company.mapper;

import com.company.domain.UserVO;

public interface RegMapper {
    public int findSameUserId(String userId);
    public int insertUser(UserVO vo);
    public String login(UserVO vo);
    public int loginAjax(UserVO vo);
    public UserVO mypage(String id);
    public int changeUserInfo(UserVO vo);

}
