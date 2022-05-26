package com.example.listood_v10.MainScreen_Fragments;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listood_v10.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Fragment_Read_Reminders extends Fragment {

    View rootview;
    AppCompatButton savebt;
    EditText nameRem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment__read__reminders, container, false);

        nameRem=rootview.findViewById(R.id.nameEDReminder);
        savebt = rootview.findViewById(R.id.but_rem_save);

        savebt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!nameRem.equals(null)){

                    String task = nameRem.getText().toString();
                    String USER_KEY = "User";
                    DatabaseReference mDataBase = FirebaseDatabase.getInstance("https://listood-v1-0-probably-default-rtdb.firebaseio.com/").getReference("reminders");
                    mDataBase.push().setValue(task);

                }else{

                    Toast.makeText(getContext(), "Заполните поле", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootview;
    }
}