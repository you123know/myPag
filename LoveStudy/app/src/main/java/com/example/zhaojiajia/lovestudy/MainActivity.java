package com.example.zhaojiajia.lovestudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ITest myTest;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.23.1/") //指定访问的IP地址
                .addConverterFactory(GsonConverterFactory.create())//指定以哪种格式解析接收到的数据
                .build();
        myTest = retrofit.create(ITest.class);
        listview = (ListView) findViewById(R.id.listview);
        setAdapter();
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final long myId =id;
                PopupMenu pop = new PopupMenu(MainActivity.this, view);
                pop.getMenuInflater().inflate(R.menu.menu, pop.getMenu());
                pop.show();
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.delete) {
                            Call<Hope> call = myTest.deleteHope("delete",myId + "");
                            call.enqueue(new Callback<Hope>() {
                                @Override
                                public void onResponse(Call<Hope> call, Response<Hope> response) {
                                    Toast.makeText(MainActivity.this, response.body().getUserName(), Toast.LENGTH_SHORT).show();
                                    setAdapter();
                                    Log.e("MainActivity", "删除成功");
                                }

                                @Override
                                public void onFailure(Call<Hope> call, Throwable t) {
                                    Log.e("MainActivity", "删除出现错误");
                                    t.printStackTrace();
                                }
                            });
                        }
                        return true;
                    }
                });
                return true;
            }
        });
    }


    private void setAdapter() {
        Call<List<Hope>> call = myTest.getAllHope();
        call.enqueue(new Callback<List<Hope>>() {
            @Override
            public void onResponse(Call<List<Hope>> call, Response<List<Hope>> response) {
                List<Hope> list = response.body();
                MyAdapter myAdapter = new MyAdapter(MainActivity.this, list);
                listview.setAdapter(myAdapter);
                Log.e("MainActivity", "list赋值成功");
            }

            @Override
            public void onFailure(Call<List<Hope>> call, Throwable t) {
                Log.e("MainActivity", "list赋值失败");
                t.printStackTrace();
            }
        });

    }
}
