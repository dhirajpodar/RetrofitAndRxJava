package com.example.retrofitandrxandroid.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.retrofitandrxandroid.R;
import com.example.retrofitandrxandroid.adapter.MyAdapter;
import com.example.retrofitandrxandroid.model.Hero;
import com.example.retrofitandrxandroid.remote.APIservice;
import com.example.retrofitandrxandroid.remote.RetrofitClass;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private  static  final String TAG = "Hero";

    private Button button;
    private RecyclerView recyclerView;
    APIservice apiservice;
    MyAdapter adapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiservice = RetrofitClass.getAPIservice();
        button = findViewById(R.id.button_id);
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                getdata();
            }

            private void getdata() {
                Observable<List<Hero>> heroesListObservable = apiservice.getHerolist();
                heroesListObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<List<Hero>>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(List<Hero> heroes) {
                                for(int i=0;i<heroes.size();i++) {
                                    adapter = new MyAdapter(heroes);
                                    recyclerView.setAdapter(adapter);
                                }
                            }


                            @Override
                            public void onError(Throwable e) {

                                Log.d(TAG, ""+e.getMessage());

                            }

                            @Override
                            public void onComplete() {
                                progressBar.setVisibility(View.INVISIBLE);
                                Log.d(TAG, "done");
                            }
                        });
            }
        });
    }
}

