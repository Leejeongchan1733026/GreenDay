package com.example.greenday;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class PostActivity extends AppCompatActivity {

    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();

    private TextView mTitleText, mContentsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        mTitleText = findViewById(R.id.title);
        mContentsText = findViewById(R.id.contents);

        mStore.collection("board").document("title")
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            if (task.getResult() != null){
                                Map<String, Object> snap = task.getResult().getData();
                                String title = String.valueOf(snap.get("title"));
                                String contents = String.valueOf(snap.get("contents"));

                                mTitleText.setText(title);
                                mContentsText.setText(contents);
                            }
                        }
                    }
                });
    }
}
