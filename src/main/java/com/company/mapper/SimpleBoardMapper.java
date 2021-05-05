package com.company.mapper;

import com.company.domain.SimpleBoardVO;

import java.util.List;

public interface SimpleBoardMapper {
    public int insertBoard(SimpleBoardVO vo);
    public List<SimpleBoardVO> getBoardList(int pageNum,int criteria);
    public SimpleBoardVO readBoard(int sbno);

}
