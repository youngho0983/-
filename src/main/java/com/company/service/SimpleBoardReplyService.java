package com.company.service;

import com.company.domain.ReplyVO;

import java.util.List;

public interface SimpleBoardReplyService {
    public List getReplyList(int sbno,int replyPage);
    public boolean insertReply(ReplyVO vo);
    public int getReplyCount(int sbno);
}
