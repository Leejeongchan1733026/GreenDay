package com.example.greenday;

/*
    게시물 정보 모델 클래스
 */
public class PostAccount {
    private String title;       //제목
    private  String contents;   //내용
    private String postToken;   //고유번호

    public PostAccount(){} //모델클래스 리얼타임 베이스 사용 시 빈 생성자 필요

    public PostAccount(String title, String contents, String postToken) {
        this.title = title;
        this.contents = contents;
        this.postToken = postToken;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getContents() { return contents; }

    public void setContents(String contents) { this.contents = contents; }

    public String getPostToken() { return postToken; }

    public void setPostToken(String postToken) { this.postToken = postToken; }

    @Override
    public String toString() {
        return "PostAccount{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", postToken='" + postToken + '\'' +
                '}';
    }
}

