package com.vidvels.registercrm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    String TAG = "MainActivity";
    String mobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");
         mobile  = "7838479";

    }




    public void  registerUser()
    {
       // String registeredId = mFirebaseDatabase.push().getKey();
        RegisterShop registerShop = new RegisterShop("Ganesh","8080593361","acharya.ganesh2@gmail.com","Ganesh Jewellers","Dharavi","12345678");
        mFirebaseDatabase.child(mobile).child("customer").child(registerShop.getMobile()).setValue(registerShop);
        addUserChangeListener(registerShop);
    }


    private void addUserChangeListener(   RegisterShop registerShop) {
        // User data change listener
        mFirebaseDatabase.child("customer").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                RegisterShop registerShop = dataSnapshot.getValue(RegisterShop.class);

                // Check for null
                if (registerShop == null) {
                    Log.e(TAG, "User data is null!");
                    return;
                }

                Log.e(TAG, "User data is changed!" + registerShop.name + ", " + registerShop.email);
               // getData();


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", error.toException());
            }
        });
    }

    public void Register(View view) {
        registerUser();
    }



    public void getData()
    {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("shops");
        ref.orderByChild("mobile").equalTo("8080593361").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot
                        showData((HashMap<String,RegisterShop>)(dataSnapshot.getValue()));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });
    }


    public void showData(HashMap<String,RegisterShop> data)
    {
        Log.e(TAG, "User data !" + data.size());

    }
}
