package com.example.greenday;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PostViewActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference = FirebaseDatabase.getInstance().getReference();
    private ChildEventListener mChild;
    private RecyclerView mPostRecyclerView;
    private PostViewAdapter mAdapter;
    private List<PostAccount> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postview);

        mPostRecyclerView = findViewById(R.id.main_recyclerview);

        mData = new ArrayList<>();

        mAdapter = new PostViewAdapter(mData);
        mPostRecyclerView.setAdapter(mAdapter);

        Button posting = (Button) findViewById(R.id.posting);
        Button MBTItest = (Button) findViewById(R.id.MBTItest);

        ValueEventListener mValueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot postSnapshot: snapshot.getChildren()){
                    PostAccount info_each = postSnapshot.getValue(PostAccount.class);
                    mData.add(new PostAccount("d", "d", "null"));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        MBTItest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.16personalities.com/ko/"));
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
    private void initDatabase() {

        mDatabase = FirebaseDatabase.getInstance();

        mReference = mDatabase.getReference("log");
        mReference.child("log").setValue("check");

        mChild = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mReference.addChildEventListener(mChild);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mReference.removeEventListener(mChild);
    }
}