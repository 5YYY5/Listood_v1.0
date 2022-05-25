package com.example.listood_v10.app_2;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.myapplication.messages.MessagesAdapter;
//import com.example.myapplication.messages.MessagesList;
import com.example.listood_v10.R;
import com.example.listood_v10.app_2.messages.MessagesAdapter;
import com.example.listood_v10.app_2.messages.MessagesList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity_2 extends AppCompatActivity {

    private final List<MessagesList> messagesLists = new ArrayList<>();
    private String mobile, email, name;
    private RecyclerView messagesRecyclerView;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://chatapplication-fdcdb-default-rtdb.firebaseio.com/");

    private String lastMessage="";
    private  int unseenMessages=0;
    private String chatKey="";

    private boolean dataSet=false;


    private MessagesAdapter messagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        final CircleImageView userProfilePic = findViewById(R.id.userProfilePic);
        messagesRecyclerView = findViewById(R.id.messagesRecyclerView);

        //get intent data from Register.class activity
        mobile=getIntent().getStringExtra("mobile");
        email=getIntent().getStringExtra("email");
        name=getIntent().getStringExtra("name");

        messagesRecyclerView.setHasFixedSize(true);
        messagesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //set adapter to recyclerview
        messagesAdapter=new MessagesAdapter(messagesLists, MainActivity_2.this);
        messagesRecyclerView.setAdapter(messagesAdapter);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        //get profile pic from firebase database
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                final String profilePicUrl = snapshot.child("users").child(mobile).child("profile_pic").getValue(String.class);

                if (!profilePicUrl.isEmpty()){

                    //set profile pic to circle image view
                    Picasso.get().load(profilePicUrl).into(userProfilePic);

                }

                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                messagesLists.clear();
                unseenMessages=0;
                lastMessage="";
                chatKey="";

                Integer i=0;

                for (DataSnapshot dataSnapshot:snapshot.child("users").getChildren()){

                    final String getMobile = dataSnapshot.getKey();


                    i++;

                    dataSet=false;


                    if (!getMobile.equals(mobile)){

                        final String getName = dataSnapshot.child("name").getValue(String.class);
                        final String getProfilePic = dataSnapshot.child("profile_pic").getValue(String.class);


                        if (!dataSet){

                            chatKey=databaseReference.child("chat").child(i.toString()).getKey();

                            dataSet=true;
                            MessagesList messagesList = new MessagesList(getName, getMobile, lastMessage, getProfilePic, unseenMessages, chatKey);
                            messagesLists.add(messagesList);
                            messagesAdapter.updateData(messagesLists);
                        }


                        databaseReference.child("chat").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                int getChatCounts=(int)snapshot.getChildrenCount();

                                if (getChatCounts >0 ){



                                    for (DataSnapshot dataSnapshot1 : snapshot.getChildren()){


                                        final String getKey = dataSnapshot1.getKey();
                                        chatKey=getKey;



                                        if (dataSnapshot1.hasChild("user_1") && dataSnapshot1.hasChild("user_2") && dataSnapshot1.hasChild("messages")) {

                                            final String getUserOne = dataSnapshot1.child("user_1").getValue(String.class);
                                            final String getUserTwo = dataSnapshot1.child("user_2").getValue(String.class);

                                            if ((getUserOne.equals(getMobile) && getUserTwo.equals(mobile)) || (getUserOne.equals(mobile) && getUserTwo.equals(getMobile))) {

                                                for (DataSnapshot chatDataSnapshot: dataSnapshot1.child("messages").getChildren()){

                                                    final long getMessageKey= Long.parseLong(chatDataSnapshot.getKey());
                                                    final long getLastSeenMessage = Long.parseLong(MemoryData.getlastMsgTS(MainActivity_2.this, getKey));


                                                    lastMessage = chatDataSnapshot.child("msg").getValue(String.class);
                                                    if (getMessageKey>getLastSeenMessage){

                                                        unseenMessages++;
                                                    }

                                                }
                                            }

                                        }


//                                        if (!dataSet){
//
//                                            dataSet=true;
//                                            MessagesList messagesList = new MessagesList(getName, getMobile, lastMessage, getProfilePic, unseenMessages, chatKey);
//                                            messagesLists.add(messagesList);
//                                            messagesAdapter.updateData(messagesLists);
//                                        }



                                    }
                                }
//                                if (!dataSet){
//
//                                    dataSet=true;
//                                    MessagesList messagesList = new MessagesList(getName, getMobile, lastMessage, getProfilePic, unseenMessages, chatKey);
//                                    messagesLists.add(messagesList);
//                                    messagesAdapter.updateData(messagesLists);
//                                }



                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

//                        if (!dataSet) {
//                            dataSet = true;
//                            MessagesList messagesList = new MessagesList(getName, getMobile, lastMessage, getProfilePic, unseenMessages, chatKey);
//                            messagesLists.add(messagesList);
//                            messagesAdapter.updateData(messagesLists);
//                        }

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}