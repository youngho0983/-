package com.company.service;

import com.company.domain.ReplyPageVO;
import com.company.domain.ReplyVO;
import com.company.mapper.SimpleBoardReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SimpleBoardReplyServiceimpl implements SimpleBoardReplyService{
    @Autowired
    SimpleBoardReplyMapper simpleBoardReplyMapper;

    @Override
    public List getReplyList(int sbno,int replyPage)
    {
        System.out.println("sbno="+sbno+"replyPage="+replyPage);
        ReplyPageVO vo=new ReplyPageVO();
        vo.setReplyPage(replyPage);
        vo.setSbno(sbno);
        return simpleBoardReplyMapper.getReplyList(vo);
    }

    @Override
    public boolean insertReply(ReplyVO vo) {
        System.out.println("in insert Service"+vo);
        return simpleBoardReplyMapper.insertReply(vo)==1? true:false;
    }

    @Override
    public int getReplyCount(int sbno) {
        System.out.println("in getREplyCountService sbno="+sbno);
        return simpleBoardReplyMapper.getReplyCount(sbno);
    }
}
