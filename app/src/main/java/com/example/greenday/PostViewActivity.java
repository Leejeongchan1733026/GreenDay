package com.example.greenday;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostViewActivity extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();   //데이터 베이스
    private ChildEventListener mChild;
    private RecyclerView mPostRecyclerView;
    private PostViewAdapter mAdapter;
    private List<PostAccount> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postview);

        mPostRecyclerView = findViewById(R.id.main_recyclerview);

        Button posting = (Button) findViewById(R.id.posting);
        Button MBTItest = (Button) findViewById(R.id.MBTItest);
        Button MBTIrecommend = (Button) findViewById(R.id.MBTIrecommend);


        MBTItest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.16personalities.com/ko/"));
                startActivity(intent);
            }
        });

        MBTIrecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        posting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostingActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onStart(){
        super.onStart();
        mData = new ArrayList<>();
        mStore.collection("board")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            if(task.getResult() != null){
                                for (DocumentSnapshot snap : task.getResult()){
                                    Map<String, Object> shot = snap.getData();
                                    String title = String.valueOf(shot.get("title"));
                                    String contents = String.valueOf(shot.get("contents"));
                                    PostAccount data = new PostAccount(title, contents, "null");
                                    mData.add(data);
                                }

                                mAdapter = new PostViewAdapter(mData);
                                mPostRecyclerView.setAdapter(mAdapter);
                            }
                        }
                    }
                });
    }
}