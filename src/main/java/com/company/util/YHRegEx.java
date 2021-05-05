package com.company.util;

import java.util.regex.Pattern;

public class YHRegEx {
    private String nameReg="^[가-힇][가-힇][가-힇]$";
    private String idReg="^[a-z0-9]{4,20}$";
    private String passwordReg="(?=.*\\d{1,50})(?=.*[~`!@#$%\\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$";

    public boolean nameRegCheck(String name){
        boolean result=false;
        result=Pattern.compile(nameReg).matcher(name).find();
        System.out.println("name result ="+result);
        return result;
    }
//    public boolean passwordRegCheck(String password){
//        boolean result=false;
//        result=Pattern.compile(passwordReg).matcher(password).find();
//        System.out.println("password result="+password+" :=>"+result);
//        return result;
//    }

    public boolean idRegCheck(String id){
        boolean result = false;
        result=Pattern.compile(idReg).matcher(id).find();
        System.out.println("id result="+result);
        return result;
    }
}
