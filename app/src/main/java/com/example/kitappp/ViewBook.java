package com.example.kitappp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewBook extends AppCompatActivity {

    TextView bname , bprice, bdescription;
    Button show, insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_view);

        bname = findViewById(R.id.name_book);
        bprice = findViewById(R.id.book_price);
        bdescription = findViewById(R.id.bookdescription);
        show = findViewById(R.id.quebtn);
        insert = findViewById(R.id.addbtn);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("View").child("b1");
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.hasChildren()) {
                            bname.setText(snapshot.child("BookName").getValue().toString());
                            bprice.setText(snapshot.child("Price").getValue().toString());
                            bdescription.setText(snapshot.child("Description").getValue().toString());
                        } else {
                            Toast.makeText(getApplicationContext(), "No data to display", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });






        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                    CartView st = new CartView(

                            bname.getText().toString().trim(),
                            Float.parseFloat(bprice.getText().toString().trim())

                    );


                   FirebaseDatabase.getInstance().getReference().child("Cart").child("c6").child("b8").setValue(st);
                       //  FirebaseDatabase.getInstance().getReference().child("Cart").child("c5").child("b1").push().setValue(st);
                    Toast.makeText(ViewBook.this, "Added to the Cart", Toast.LENGTH_SHORT).show();

                }


        });

    }





}

