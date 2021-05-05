package com.company.service;

import com.company.domain.UserVO;
import com.company.mapper.RegMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegServiceImpl implements RegService{
    @Autowired
    RegMapper mapper;
    //사람 있으면 쓰면 안되!! 펄스 날림
    @Override
    public boolean fingSameId(String userId) {

        if (mapper.findSameUserId(userId)!=0){
            return false;
        }
        return true;
    }

    @Override
    public boolean insertUser(UserVO vo) {
        System.out.println(vo+"on service");
        int result=mapper.insertUser(vo);
        if(result!=1){
            return false;

        }
        return true;
    }

    @Override
    public String login(UserVO vo) {
        String temp=mapper.login(vo);

        return temp;
    }

    @Override
    public boolean loginAjax(UserVO vo) {
        boolean result=false;
        if(mapper.loginAjax(vo)==1){
            result=true;
        }
        return result;
    }

    @Override
    public UserVO mypage(String id) {
        System.out.println("mypage Service :"+id) ;

        UserVO vo=mapper.mypage(id);
        System.out.println(vo);
        return vo;

    }

    @Override
    public boolean changeUserInfo(UserVO vo) {
        System.out.println("change Service "+vo);
        int result= mapper.changeUserInfo(vo);
        if(result==1){
            return true;
        }
        return false;

    }
}
