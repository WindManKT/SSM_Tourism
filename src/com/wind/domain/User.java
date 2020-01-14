package com.wind.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class User {
    private int id;
    @NotEmpty(message="邮箱不能为空")
    @Email(message="邮箱格式不正确")
    private String email;
    @NotEmpty(message="用户名不能为空")
    @Size(min = 6,max = 20,message = "用户名长度必须介于6~20")
    private String username;
    @NotEmpty(message="密码不能为空")
    @Size(min=6,message = "密码必须大于等于6位")
    private String password;

    public User(int id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class createUser{
        private int id;
        private String username;
        private String email;
        private String password;

        public createUser setId(int id) {
            this.id = id;
            return this;
        }

        public createUser setUsername(String username) {
            this.username = username;
            return this;
        }

        public createUser setEmail(String email) {
            this.email = email;
            return this;
        }

        public createUser setPassword(String password) {
            this.password = password;
            return this;
        }
        public User createUser(){
            return new User(id,email,username,password);
        }
    }
}
