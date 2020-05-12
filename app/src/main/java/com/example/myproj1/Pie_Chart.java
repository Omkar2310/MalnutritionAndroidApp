package com.example.myproj1;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.os.Bundle;


public class Pie_Chart extends AppCompatActivity {
    private DatabaseReference mData;

    List<ChildData> list=new ArrayList<>();
    ProgressDialog progressDialog;
    int s=0,m=0,n=0;
    PieChart pieChart;
    PieData pieData;
    PieDataSet pieDataSet;
    ArrayList pieEntries;
    ArrayList PieEntryLabels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pie_chart );
        pieChart = (PieChart)findViewById( R.id.pieChart );







        pieChart.setRotationEnabled(true);
        //pieChart.setUsePercentValues(true);
        //pieChart.setHoleColor(Color.BLUE);
        //pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Super Cool Chart");
        pieChart.setCenterTextSize(10);
        //pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
        //More options just check out the documentation!


//        pieChart.setData(pieData);
//        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
//        pieDataSet.setSliceSpace(2f);
//        pieDataSet.setValueTextColor(Color.WHITE);
//        pieDataSet.setValueTextSize(10f);
//        pieDataSet.setSliceSpace(5f);

        addData();


        progressDialog = new ProgressDialog(Pie_Chart.this);
        progressDialog.setMessage("Loading Pie_Chart");
        progressDialog.show();





    }

    private void addData() {
        mData = FirebaseDatabase.getInstance().getReference().child( "DataChild" );

        mData.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ChildData childData = new ChildData();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    for (DataSnapshot ds1 : dataSnapshot.getChildren()) {
                        try {
                            childData = ds1.getValue( ChildData.class );
                            // childData.Result = ds.getKey().toString();

                            if ("SAM".equals( childData.getResult() )) {
                                s++;
                            } else if ("MAM".equals( childData.getResult() )) {
                                m++;
                            } else if ("Normal".equals( childData.getResult() )) {
                                n++;
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        } );

        System.out.println("Data is " + s + m+ n);
        int data[]={s,m,n};
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        for(int i=0;i<3;i++)
        {
            yEntrys.add( new PieEntry(data[i] ,i) );
        }

        PieDataSet pieDataSet=new PieDataSet( yEntrys,"Malnutrished Kids" );
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.BLUE);
        colors.add(Color.RED);

        pieDataSet.setColors(colors);

        //add legend to chart
        Legend legend = pieChart.getLegend();
        legend.setForm( Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();


    }


}
