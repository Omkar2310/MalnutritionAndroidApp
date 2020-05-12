package com.example.myproj1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class FunctionalActivity extends AppCompatActivity  implements  View.OnClickListener{


    FirebaseAuth mFirebaseAuth;
    private CardView addchild,addfam,searchindb,logut,dispc,dispf,piec;

    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
         setContentView( R.layout.activity_functional );

         addchild=(CardView)findViewById( R.id.insertchild );
        addfam=(CardView)findViewById( R.id.insertfam );
        searchindb=(CardView)findViewById( R.id.searchindb );
        dispc=(CardView)findViewById( R.id.dispchild );
        dispf=(CardView)findViewById( R.id.dispfam );
        logut=(CardView)findViewById( R.id.logingout );
        piec=(CardView)findViewById( R.id.piechar );
        addchild.setOnClickListener( this );
        addfam.setOnClickListener( this );
        searchindb.setOnClickListener( this );
        dispc.setOnClickListener( this );
        dispf.setOnClickListener( this );
        logut.setOnClickListener( this );
        piec.setOnClickListener( this );



//         add.setOnClickListener( new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 Intent i1=new Intent( FunctionalActivity.this,FamInformation.class );
//                 startActivity( i1 );
//             }
//         } );
//
//         addchil.setOnClickListener( new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 Intent i=new Intent( FunctionalActivity.this,HomeActivity.class );
//                 startActivity( i );
//             }
//         } );
//
//         display.setOnClickListener( new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 Intent i2=new Intent( FunctionalActivity.this,DisplayData.class );
//                 startActivity( i2 );
//             }
//         } );
//        btnlogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//
//                Intent i1=new Intent(FunctionalActivity.this,LoginActivity.class);
//                startActivity(i1);
//            }
//        });
//
//        sear.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i1=new Intent(FunctionalActivity.this,Search.class);
//                startActivity( i1 );
//            }
//        } );
//
//        dispfam.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i4=new Intent( FunctionalActivity.this,DisplayFamInfo.class );
//                startActivity( i4 );
//            }
//        } );

    }
    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId())
        {
            case R.id.insertchild : i =new Intent( FunctionalActivity.this,HomeActivity.class );startActivity(i);  break;
            case R.id.insertfam : i=new Intent( FunctionalActivity.this,FamInformation.class );startActivity(i);  break;
            case R.id.dispchild : i=new Intent( FunctionalActivity.this,DisplayData.class );startActivity(i);  break;
            case R.id.dispfam : i=new Intent( FunctionalActivity.this,DisplayFamInfo.class );startActivity(i);  break;
            case R.id.searchindb : i=new Intent( FunctionalActivity.this,Search.class );startActivity(i);  break;
            case R.id.logingout : i=new Intent( FunctionalActivity.this,LoginActivity.class );startActivity(i);  break;
            case R.id.piechar :i=new Intent( FunctionalActivity.this,Pie_Chart.class );startActivity(i);  break;
            default:break;
        }
    }
}
