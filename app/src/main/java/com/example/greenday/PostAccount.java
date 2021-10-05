package com.example.greenday;

/*
    게시물 정보 모델 클래스
 */
public class PostAccount {
    private String title;       //제목
    private  String contents;   //내용

    public PostAccount(){ }     //모델클래스 리얼타임 베이스 사용 시 빈 생성자 필요


    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getContents() { return contents; }

    public void setContents(String contents) { this.contents = contents; }
}

