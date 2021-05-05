package com.company.service;

import com.company.domain.SimpleBoardVO;

import java.util.List;

public interface SimpleBoardService {
    public boolean insertBoard(SimpleBoardVO vo);
    public List getList(int pageNum, int criteria);
    public SimpleBoardVO read(int sbno);
}
