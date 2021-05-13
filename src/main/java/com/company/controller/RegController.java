package com.company.controller;

import com.company.domain.UserVO;
import com.company.service.RegService;
import com.company.util.YHRegEx;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Controller
@RequestMapping("/reg")
public class RegController {
    @Autowired
    RegService regService;

    private Log log= LogFactory.getLog(this.getClass());

    @RequestMapping(value = "/signin",method = RequestMethod.GET)
    public String goSignIn(){
        log.info("로그인 페이지로 이동합니다");
        System.out.println("go login page");

        return "/signin/signin";
    }
    @RequestMapping(value="/signin",method=RequestMethod.POST)
    public String signin(UserVO vo){
        System.out.println("submit Signin "+vo);

        YHRegEx reg=new YHRegEx();

        log.info("get in :"+vo);
        if(reg.nameRegCheck(vo.getName())& reg.idRegCheck(vo.getId())){
            regService.insertUser(vo);

            return "redirect: /reg/login";

        }


        return "redirect:/reg/signin";
    }
    @RequestMapping(value="/idCheck",method = RequestMethod.POST)
    public ResponseEntity<String> idCheck(HttpServletRequest request,String userId) throws IOException {
        System.out.println( request.getInputStream().isReady());
        System.out.println("idCheck");
        log.info("idCheck");
        System.out.println(userId);
        boolean canUse= regService.fingSameId(userId);
        System.out.println(canUse);

        if(canUse){
            return new ResponseEntity<String>("canUse",HttpStatus.OK);
        }

        return new ResponseEntity<String>("don'tUse",HttpStatus.OK);

    }
    @RequestMapping(value = "/login")
    public String goLogin(){
        System.out.println("go to login page");

        return "/signin/login";
    }

//    @RequestMapping(value="/login" ,method = RequestMethod.POST)
//    public String login(UserVO vo, HttpSession session){
//        System.out.println("login :"+vo);
//        String id= regService.login(vo);
//        session.setAttribute("loginInfo",id);
//        return "redirect:/";
//
//    }
    @RequestMapping(value="/loginAjax",method = RequestMethod.POST)
    public @ResponseBody String loginAjax(UserVO vo){
        System.out.println("confirm by ajax "+vo);
        boolean result=regService.loginAjax(vo);

        if(result){
            System.out.println("success");
            return "success";
        }else{
            System.out.println("fail");
            return "fail";
        }

    }
    @RequestMapping(value="/submitLogin" ,method = RequestMethod.POST)
    public String login(UserVO vo,HttpSession session){
        System.out.println("login form submitted"+ vo);
        String loginId =regService.login(vo);
        session.setAttribute("loginId",loginId);
        return "redirect:/";
    }
    @RequestMapping(value="/logout" ,method=RequestMethod.GET)
    public String logout(HttpSession session){
        System.out.println((String)session.getAttribute("loginId") +"want to logOut");
        session.invalidate();
        return "redirect:/";
    }
    @RequestMapping(value="/goMyPage",method = RequestMethod.GET)
    public String goMyPage(HttpSession session, Model model){
        String id= (String)session.getAttribute("loginId");
        System.out.println("gomyPage controller +"+ id);
         UserVO vo=regService.mypage(id);
        System.out.println("goMyPage :" +vo);
        model.addAttribute("mypage",vo);
        return "/signin/myPage";
    }
    @RequestMapping(value="/changeInfo",method = RequestMethod.POST)
    public @ResponseBody String changeInfo(HttpSession session,String email,String password,String phone){
        System.out.println("ajax 요청 들어옴" +email+"  :" +password+"  :"+phone);
        String id=(String) session.getAttribute("loginId");
        UserVO vo=new UserVO();
        vo.setId(id);
        vo.setEmail(email);
        vo.setPassword(password);
        vo.setPhone(phone);
        if(regService.changeUserInfo(vo)){

            return "success";
        }else{
         return "fail";
        }
    }
}
