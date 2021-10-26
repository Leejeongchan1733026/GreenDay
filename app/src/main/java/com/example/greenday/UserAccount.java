package com.example.greenday;

/*
    사용자 계정 정보 모델 클래스
 */
public class UserAccount {

    private  String name;
    private String emailId;     //이메일 아이디
    private  String password;   //비밀번호
    private String idToken;     //Firebase Uid(고유 토큰번호)

    public UserAccount(){ }     //모델클래스 리얼타임 베이스 사용 시 빈 생성자 필요

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}
