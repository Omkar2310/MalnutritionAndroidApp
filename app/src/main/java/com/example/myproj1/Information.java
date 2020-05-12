package com.example.myproj1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Information extends AppCompatActivity {

    RecyclerView recycler_view;
    private List<InfoData> dataList = new ArrayList<>();
    RecyclerAdapter adapter;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
//
//        viewPager=(ViewPager)findViewById(R.id.viewpager);
//
//        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this);
//        viewPager.setAdapter(viewPagerAdapter);

        t1=(TextView)findViewById( R.id.textview );
        recycler_view = findViewById(R.id.recycler_view);
        adapter = new RecyclerAdapter(dataList);
        prepareDataData();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager horizontalLayoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL)); // add this line to get default divider.
        recycler_view.setAdapter(adapter);

    }

    private void prepareDataData() {

        InfoData data = new InfoData("Ages 2 to 3 : \nDaily guidelines for girls and boys\n\n\n" +
                "Calories : 1,000-1,400\n" +
                "Protein : 2-4 ounces\n" +
                "Fruits : 1-1.5 cups\n" +
                "Vegetables : 1-1.5 cups\n" +
                "Grains : 3-5 ounces\n" +
                "Dairy : 2 cups\n", R.drawable.slide4);
        dataList.add(data);


        data = new InfoData(
                "Visit following Links for more Information\n\n" +
                        "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4232244/\n\n" +
                        "https://en.wikipedia.org/wiki/Malnutrition_in_India\n\n" +
                        "https://www.who.int/nutrition/double-burden-malnutrition/en/",  R.drawable.slide2);
        dataList.add(data);

        data = new InfoData("Nearly half of all deaths in children under 5 are attributable to undernutrition; undernutrition puts children at greater risk of dying from common infections, increases the frequency and severity of such infections, and delays recovery.",  R.drawable.slide1);
        dataList.add(data);

        data = new InfoData("You can't change who you are, but you can change what you have in your head, you can refresh what you're thinking about, you can put some fresh air in your brain.",  R.drawable.slide3);
        dataList.add(data);


        adapter.notifyDataSetChanged();

    }
}
