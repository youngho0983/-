package com.company.mapper;

import com.company.domain.ReplyPageVO;
import com.company.domain.ReplyVO;

import java.util.List;

public interface SimpleBoardReplyMapper {
    public List getReplyList(ReplyPageVO vo);
    public int insertReply(ReplyVO vo);
    public int getReplyCount(int sbno);
}
