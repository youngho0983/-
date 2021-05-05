package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RequestMapping ("/photoBoard")
@Controller
public class PhotoBoardController {

    @RequestMapping(value = "/photoBoard" ,method = RequestMethod.GET)
    public String goPhotoBoard(){
        System.out.println("go photoBoard");

        return "/photoboard/photoBoard";
    }

    @RequestMapping(value="/write",method = RequestMethod.GET)
    public String goWrite(){
        System.out.println("go write photoBoard");
        return "/photoboard/write";
    }

    @RequestMapping(value = "/photoAjax" ,method = RequestMethod.POST)
    public @ResponseBody String photoAjax(HttpServletRequest request) throws IOException {
        System.out.println("request photo Ajax");
        InputStream is=request.getInputStream();
        String separator=File.separator;
        String path=request.getServletContext().getRealPath(separator);
        System.out.println(path);
        File file=new File(path+separator);
        return "hello";
    }
}
