package com.example.kitchentvbeta;

import static com.example.kitchentvbeta.FBREF.refActive;
import static com.example.kitchentvbeta.FBREF.refBon;
import static com.example.kitchentvbeta.FBREF.refMeal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bons extends AppCompatActivity {
    int count=0;
    Queue<Bon> meal_order_main;
    ValueEventListener vel,vel2;
    ListView list1,list2,list3,list4,list5,list6,list7,list8;
    ArrayAdapter<String>[]all_adapters;
    ListView[] all_lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bons);
        list1=(ListView)findViewById(R.id.list1);
        list2=(ListView)findViewById(R.id.list2);
        list3=(ListView)findViewById(R.id.list3);
        list4=(ListView)findViewById(R.id.list4);
        list5=(ListView)findViewById(R.id.list5);
        list6=(ListView)findViewById(R.id.list6);
        list7=(ListView)findViewById(R.id.list7);
        list8=(ListView)findViewById(R.id.list8);
        all_lists= new ListView[]{list1, list2, list3, list4, list5, list6, list7, list8};
        meal_order_main = new LinkedList<>();
        all_adapters=new ArrayAdapter[8];
        Query query1=refActive.orderByChild("above");
        /**
         * gets the user object in the form of an object then casted to user.
         */
        vel=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot data:snapshot.getChildren()) {
                    count++;
                    Bon tmp=data.getValue(Bon.class);
                    meal_order_main.add(tmp);
                    if(count<9&&count>0){
                        int i=0;
                        while(i<9&&!meal_order_main.isEmpty()){
                            Bon foruse=meal_order_main.remove();
                            ArrayList<Meal>tmpl=foruse.getB();
                            ArrayList<String>bonmeal=new ArrayList<>();
                            bonmeal.add(foruse.getNote());
                            bonmeal.add(foruse.getDate());
                            for(int k=0;k<tmpl.size();k++){
                                bonmeal.add(tmpl.get(i).toString());
                            }
                            all_adapters[i]=new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,bonmeal);
                            i++;
                        }
                        int j=0;
                        while(j<9&&all_adapters[j]!=null){
                            all_lists[j].setAdapter(all_adapters[j]);
                            j++;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        query1.addValueEventListener(vel);
        Query query=refActive.orderByChild("time");
        /**
         * gets the user object in the form of an object then casted to user.
         */
        vel2=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot data:snapshot.getChildren()) {
                    count++;
                    Bon tmp=data.getValue(Bon.class);
                    meal_order_main.add(tmp);
                    if(count<9&&count>0){
                        int i=0;
                        while(i<9&&!meal_order_main.isEmpty()){
                            Bon foruse=meal_order_main.remove();
                            ArrayList<Meal>tmpl=foruse.getB();
                            ArrayList<String>bonmeal=new ArrayList<>();
                            bonmeal.add(foruse.getNote());
                            bonmeal.add(foruse.getDate());
                            for(int k=0;k<tmpl.size();k++){
                                bonmeal.add(tmpl.get(i).toString());
                            }
                            all_adapters[i]=new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,bonmeal);
                            i++;
                        }
                        int j=0;
                        while(j<9&&all_adapters[j]!=null){
                            all_lists[j].setAdapter(all_adapters[j]);
                            j++;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        query.addValueEventListener(vel2);
        }
    public Queue<Bon>clone(){
        Queue<Bon>q=new LinkedList<>();
        Queue<Bon>q2=new LinkedList<>();
        while(!meal_order_main.isEmpty()) {
            Bon tmp=meal_order_main.remove();
            q.add(tmp);
            q2.add(tmp);
        }
        meal_order_main=q;
        return q2;
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (vel!=null) {
            refActive.removeEventListener(vel);
        }

    }
    }
