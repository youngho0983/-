package com.company.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVO {
    private String name;
    private String id;
    private String password;
    private String email;
    private String phone;
}
