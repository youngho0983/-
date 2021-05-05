package com.company.service;

import com.company.domain.SimpleBoardVO;
import com.company.mapper.SimpleBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleBoardServiceImpl implements SimpleBoardService{
    @Autowired
    SimpleBoardMapper mapper;

    @Override
    public boolean insertBoard(SimpleBoardVO vo) {
        System.out.println("insertBoard Service :"+vo);
        int result= mapper.insertBoard(vo);
        if(result!=1){
            return false;
        }

        return true;
    }

    @Override
    public List getList(int pageNum,int criteria) {
        List<SimpleBoardVO> list=mapper.getBoardList(pageNum,criteria);
        return list;
    }

    @Override
    public SimpleBoardVO read(int sbno) {
        return mapper.readBoard(sbno);
    }


}
