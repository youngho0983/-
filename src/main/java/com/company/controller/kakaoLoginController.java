package com.company.controller;

import org.apache.http.HttpConnection;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/kakao")
public class kakaoLoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String goKakaoLoginPage(){
        System.out.println("go KakaoLoginPage");

        return "/signin/kakaoLogin";
    }

    @RequestMapping(value = "/kakaoRedirect")
    public String kakaoRedirect(String code,String error,String error_description,String state) throws IOException {
        //리스폰스 온것들 null 아닌것들 출력
        showresponse(code,error,error_description,state);

        RestTemplate template=new RestTemplate();

        URI uri=URI.create("https://kauth.kakao.com/oauth/token");
//        URI uri=URI.create("http://localhost:8081/kakao/conform");
        HttpHeaders headers=new HttpHeaders();

        headers.add("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        MultiValueMap<String,String> parameters=new LinkedMultiValueMap<String,String>();
        parameters.set("grant_type","authorization_code");
        parameters.set("client_id","717a41d2ccaa9fefc80e68c8d2678a81");
        parameters.set("redirect_uri","http://localhost:8081/kakao/kakaoRedirect");
        parameters.set("code",code);

        HttpEntity<MultiValueMap<String,String>> request=new HttpEntity<MultiValueMap<String,String>>(parameters,headers);
        System.out.println(uri.toString());
        ResponseEntity<JSONObject> apiResonse=template.postForEntity(uri,request,JSONObject.class);

        JSONObject responseBody= apiResonse.getBody();
        String accessToken=(String)responseBody.get("access_token");
        String reFrashToken=(String)responseBody.get("refresh_token");
//        String hello=(String)responseBody.get("hello");
//        System.out.println("hello:"+hello);
        System.out.println("accessTk");
        System.out.println(accessToken);
        System.out.println("refrashTk");
        System.out.println(reFrashToken);



        URL getKakaoInfoUri=new URL("https://kapi.kakao.com/v1/user/access_token_info");
        HttpURLConnection con=(HttpURLConnection) getKakaoInfoUri.openConnection();
        con.setRequestMethod("GET");
        System.out.println("여기서 부터입니다");
        con.setRequestProperty("Authorization","Bearer "+accessToken);


        int responseCode =con.getResponseCode();
        InputStream isr=con.getInputStream();
        Map<String,List<String>> temp=con.getHeaderFields();
        Iterator<String> it= temp.keySet().iterator();
        while(it.hasNext()){
            String key=it.next();
            System.out.println(key+":"+temp.get(key).toString());
        }
        byte[] arr=new byte[1024];
        int leng=0;
        String result=null;
        while((leng=isr.read(arr))!=-1  ){

            result=new String(arr);

        }
        
        System.out.println(result);

//
//
//        CloseableHttpClient httpClient= HttpClients.createDefault();
//        HttpPost post= new HttpPost("kauth.kakao.com/oauth/token");
//
//        List<NameValuePair> nvpr=new ArrayList<NameValuePair>();
//        nvpr.add(new BasicNameValuePair("Content-Type","application/x-www-form-urlencoded;charset=utf-8"));
//        nvpr.add(new BasicNameValuePair("grant_type","authorization_code"));
//        nvpr.add(new BasicNameValuePair("client_id","717a41d2ccaa9fefc80e68c8d2678a81"));
//        nvpr.add(new BasicNameValuePair("redirect_uri","http://localhost:8081/kakao/kakaoRedirect"));
//        nvpr.add(new BasicNameValuePair("code",code));
//
//        CloseableHttpResponse response=null;
//
//        try{
//            post.setEntity(new UrlEncodedFormEntity(nvpr));
//            response= httpClient.execute(post);
//            System.out.println(response.getStatusLine());
//            HttpEntity entity=response.getEntity();
//            InputStream is=entity.getContent();
//            InputStreamReader isr=new InputStreamReader(is);
//            char[] arr=new char[1024];
//            int length= isr.read();
//
//            for(int i=0;i<length;i++){
//                System.out.println(arr[i]);
//            }
//
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
        return "redirect:/";
    }


    
    public void showresponse(String code,String error,String error_description,String state){
        if(code!=null){
            System.out.println("code");
            System.out.println(code);
        }
        if(error!=null){
            System.out.println("error");
            System.out.println(error);

        }
        if (error_description != null){
            System.out.println("error_description");

            System.out.println(error_description);
        }
        if(state!=null){
            System.out.println("state");
            System.out.println(state);
        }



    }


    @RequestMapping(value = "/conform",method = RequestMethod.POST)
    public @ResponseBody String conform(){
        System.out.println("일단 여긴 들어오네요");
        return "{\"hello\":\"hello\"}";

    }

}
