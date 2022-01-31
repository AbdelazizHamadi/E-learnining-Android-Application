package com.example.myapplication455;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
/*
public class Main2Activity extends AppCompatActivity {

    ViewPager viewPager;

    Adapter adapter;
    List<Model>models;
    Integer[] colors = null;
    ArgbEvaluator ArgEvaluator = new ArgbEvaluator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      /*
        setContentView(R.layout.activity_main2);

        models=new ArrayList<>();
        models.add(new Model(R.id.imagecardView,"Brochure",""));
       /*
        models.add(new Model(R.id.,"Sticker",""));
        models.add(new Model(R.id.imagecardView,"Poster",""));
        models.add(new Model(R.id.imagecardView,"NameCard",""));




       adapter = new Adapter(models,this);

       viewPager.findViewById(R.id.viewPager);
       viewPager.setAdapter(adapter);
       viewPager.setPadding(130,0,130,0);

       Integer[] colorsTemp = {getResources().getColor(R.color.Color1),
               getResources().getColor(R.color.Color2),
               getResources().getColor(R.color.Color3),
               getResources().getColor(R.color.Color4)
       };

        colors=colorsTemp;

       viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int i, float v, int i1) {
               if (i<(adapter.getCount()-1) && i < (colors.length-1)){

                   viewPager.setBackgroundColor((Integer) ArgEvaluator.evaluate(

                           v,
                           colors[i],
                           colors[i+1])
                   );

               }else {

                   viewPager.setBackgroundColor(colors[colors.length-1]);
               }
           }

           @Override
           public void onPageSelected(int i) {

           }

           @Override
           public void onPageScrollStateChanged(int i) {

           }
       });


    }
}

*/
