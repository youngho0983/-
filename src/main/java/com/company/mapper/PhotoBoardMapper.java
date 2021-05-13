package com.company.mapper;

import com.company.domain.PhotoBoardVO;

import java.util.List;

public interface PhotoBoardMapper {
    public List getList();
    public int insertVO(PhotoBoardVO vo);


}
