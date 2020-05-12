package com.example.myproj1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    EditText searchtext;
    RecyclerView recyclerView;
    DatabaseReference mData;

    RecyclerViewAdapterFamInfo radapt;
    ArrayList<ChildInfo> cdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_search );

        searchtext=(EditText)findViewById( R.id.searc );
        recyclerView=(RecyclerView)findViewById( R.id.recyclerView );

        mData= FirebaseDatabase.getInstance().getReference().child( "DataChild").child( "FamInfo" );

        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        recyclerView.addItemDecoration( new DividerItemDecoration( this , LinearLayout.VERTICAL ) );

        cdata=new ArrayList<>(  );

        searchtext.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(!s.toString().isEmpty())
                {
                    setAdapter(s.toString());
                }
                else
                {
                    cdata.clear();
                    recyclerView.removeAllViews();
                }

            }

            private void setAdapter(final String searchedstring) {

                cdata.clear();
                recyclerView.removeAllViews();

                mData.addValueEventListener( new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int count=0;
                        for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren())
                        {

                            for(DataSnapshot myd : dataSnapshot1.getChildren())
                            {
                                String mn=myd.getKey().toString();
                                ChildInfo childData=myd.getValue(ChildInfo.class);
                                if(searchedstring.equals( mn ) || searchedstring.equals( childData.dob ));
                                {
                                    cdata.add( childData );
                                    count++;
                                }

                                if(count==10)
                                    break;


                            }

                        }
                        radapt=new RecyclerViewAdapterFamInfo( Search.this,cdata );
                        recyclerView.setAdapter( radapt );

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                } );
            }
        } );

    }
}
