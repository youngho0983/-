package com.company.service;

import com.company.domain.PhotoBoardVO;

import java.util.List;

public interface PhotoBoardService {
    public List getList();
    public boolean insertVO(PhotoBoardVO vo);
}
