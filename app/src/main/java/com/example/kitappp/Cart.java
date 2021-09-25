package com.example.kitappp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class Cart extends AppCompatActivity {

    RecyclerView cartlist;
    CartAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartlist = (RecyclerView)findViewById(R.id.cart_list);

        cartlist.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<CartView> options =
                new FirebaseRecyclerOptions.Builder<CartView>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Cart").child("c6"), CartView.class)
                        .build();
        myAdapter = new CartAdapter(options);
        cartlist.setAdapter(myAdapter);










    }

    @Override
    protected void onStart() {
        super.onStart();
        myAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myAdapter.stopListening();
    }
}