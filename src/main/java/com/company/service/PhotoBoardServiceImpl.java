package com.company.service;

import com.company.domain.PhotoBoardVO;
import com.company.mapper.PhotoBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoBoardServiceImpl implements PhotoBoardService{
    @Autowired
    PhotoBoardMapper photoBoardMapper;

    public List getList(){
        List<PhotoBoardVO> list=photoBoardMapper.getList();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        return list;
    }

    @Override
    public boolean insertVO(PhotoBoardVO vo) {
        int result= photoBoardMapper.insertVO(vo);
        if(result==1)return true;

        return false;
    }


}
