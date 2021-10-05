package com.example.greenday;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostingActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;               //파이어베이스 인증처리
    private DatabaseReference mDatabaseRef;   //실시간데이터 베이스
    private EditText editTitle, editcontents;         //게시글 내용 입력
    private Button posting;                   //게시물 게시 버튼

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);

        mAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("GreenDay");

        editTitle = findViewById(R.id.titleEditText);
        editcontents = findViewById(R.id.contentsEditText);
        posting = findViewById(R.id.postingButton);

        posting.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //게시글 저장 시작
                String strTitle = editTitle.getText().toString();
                String strContents = editcontents.getText().toString();

                FirebaseUser firebaseUser = mAuth.getCurrentUser();
                PostAccount account = new PostAccount();
                account.setTitle(strTitle);
                account.setContents(strContents);

                mDatabaseRef.child("PostingAccount").child(strTitle).setValue(account);
                
            }
        }));
    }
}
