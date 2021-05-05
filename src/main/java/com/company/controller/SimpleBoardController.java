package com.company.controller;

import com.company.domain.ReplyVO;
import com.company.domain.SimpleBoardVO;
import com.company.service.SimpleBoardReplyService;
import com.company.service.SimpleBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Controller
@RequestMapping(value="/simpleBoard")
public class SimpleBoardController {

    @Autowired
    SimpleBoardService simpleBoardService;
    @Autowired
    SimpleBoardReplyService simpleBoardReplyService;
    @RequestMapping("/simpleBoard1")
    public String goSimpleBoard(String pageNum,String criteria , Model model){
        System.out.println("go in simpleBoard");

        if (pageNum==null){
            pageNum="1";
        }
        if(criteria==null){
            criteria="10";
        }
        List<SimpleBoardVO> list= simpleBoardService.getList(Integer.parseInt( pageNum),Integer.parseInt( criteria));
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
        model.addAttribute("boardList",list);


        return "/simpleboard/simpleBoard1";
    }
    @RequestMapping("/simpleBoard2")
    public String goSimpleBoard2(){

        return "simpleboard/simpleBoard1";
    }

    @RequestMapping(value="/goWrite",method = RequestMethod.GET)
    public String goWrite(){
        System.out.println("go write ");


        return "/simpleboard/write";
    }

    @RequestMapping(value="/write", method = RequestMethod.POST)
    public String simpleBoardWrite(SimpleBoardVO vo, HttpSession session){
        System.out.println("simpleBoard write submit :"+vo);
        String writer=(String) session.getAttribute("loginId");
        System.out.println(writer);
        vo.setWriter(writer);
        boolean result= simpleBoardService.insertBoard(vo);
        System.out.println(result);
        if(result) {

            return "redirect:/simpleBoard/simpleBoard1";
        }
        return "redirect:/simpleBoard/write";
    }

    @RequestMapping(value="read",method =RequestMethod.GET)
    public String simpleBoardRead(int sbno,String criteria,String pageNum,String type ,Model model){
        System.out.println(sbno);
        System.out.println(criteria);
        System.out.println(pageNum);
        System.out.println(type);
        SimpleBoardVO vo= simpleBoardService.read(sbno);
        model.addAttribute("boardVO",vo);
        model.addAttribute("sbno",sbno);
        model.addAttribute("criteria",criteria);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("type",type);


        return "/simpleboard/read";
    }

    @RequestMapping("/insertReplyAjax")
    public @ResponseBody String insertReplyAjax(ReplyVO vo) throws IOException {
        System.out.println("insert reply vo:"+vo);

        if(simpleBoardReplyService.insertReply(vo)){
            return "success";
        }


        return "false";
    }


    @RequestMapping(value = "/getReplyListAjax" ,method = RequestMethod.POST)
    public @ResponseBody List getReplyListAjax(int sbno,int replyPage){

        System.out.println("getReplyListAjax sbno="+sbno+"replyPage="+replyPage);
        List list= simpleBoardReplyService.getReplyList(sbno,replyPage);

        return list;

    }
    @RequestMapping("/getReplyCountAjax")
    public @ResponseBody int getReplyCountAjax(int sbno){
        System.out.println("getReplyCountAjax sbno="+sbno );
        int result=simpleBoardReplyService.getReplyCount(sbno);
        System.out.println(" pageCount ="+result);
        return result;

    }
 }
