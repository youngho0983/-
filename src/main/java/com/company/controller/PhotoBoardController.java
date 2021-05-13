package com.company.controller;

import com.company.domain.PhotoBoardVO;
import com.company.service.PhotoBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.List;

@RequestMapping ("/photoBoard")
@Controller
public class PhotoBoardController {

    @Autowired
    PhotoBoardService photoBoardService;

    @RequestMapping(value = "/photoBoard" ,method = RequestMethod.GET)
    public String goPhotoBoard(Model model){
        System.out.println("go photoBoard");
        List list= photoBoardService.getList();
        model.addAttribute("list",list);
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
        String fileName=request.getHeader("fileName");
        String decodedFileName=URLDecoder.decode(fileName,"UTF-8");

        System.out.println(path);
        String directory=path+separator+"resources"+separator+"img";
        //        String directory="C:\\for that\\helloworld\\target\\controller-1.0.0-BUILD-SNAPSHOT"+separator+"resources"+separator+"img";
        File dir=new File(directory);
        if(!dir.exists()){
            dir.mkdirs();
        }
        File file=new File(directory+separator+decodedFileName);
        FileOutputStream fos=new FileOutputStream(file);
        int length=0;
        byte[] arr=new byte[1024];
        while((length= is.read(arr))!=-1){
            fos.write(arr,0,length);
        }
        fos.close();
        is.close();
        String imgFile="resources"+separator+"img"+separator+fileName;
        return imgFile;
    }

    @RequestMapping(value = "/imgRemoveAjax",method = RequestMethod.POST)
    public @ResponseBody String imgRemoveAjax(HttpServletRequest request,String file){
        System.out.println("imgRemoveAjax "+file);
        System.out.println(file);
        String separator=File.separator;
        String path=request.getServletContext().getRealPath(separator);
        String directory=path+separator+"resources"+separator+"img";
        String realFile=directory+separator+file;
        File willDeleteFile=new File(realFile);
        willDeleteFile.delete();
        return "good";
    }

    @RequestMapping(value = "write" ,method = RequestMethod.POST)
    public String wrtier(PhotoBoardVO vo){
        System.out.println("photoBoard Write controller");
        System.out.println(vo);
        photoBoardService.insertVO(vo);
        return "redirect:/photoBoard/photoBoard";
    }
}
