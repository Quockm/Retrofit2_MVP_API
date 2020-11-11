package com.example.retrofit2_mvp_api.view.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit2_mvp_api.R;
import com.example.retrofit2_mvp_api.Adapter.LoadMore;
import com.example.retrofit2_mvp_api.Adapter.DynamicRvAdapter;
import com.example.retrofit2_mvp_api.Adapter.DynamicRvModel;
import com.example.retrofit2_mvp_api.Adapter.StaticRvAdapter;
import com.example.retrofit2_mvp_api.Adapter.StaticRvModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DashBoardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaticRvAdapter staticRvAdapter;

    List<DynamicRvModel> items = new ArrayList<>();
    DynamicRvAdapter dynamicRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        ArrayList<StaticRvModel> item = new ArrayList<>();
        item.add(new StaticRvModel(R.drawable.pizza, "pizza"));
        item.add(new StaticRvModel(R.drawable.burger, "burger"));
        item.add(new StaticRvModel(R.drawable.fries, "fries"));
        item.add(new StaticRvModel(R.drawable.hotdog, "hotdog"));
        item.add(new StaticRvModel(R.drawable.icecream, "icecream"));


        recyclerView = findViewById(R.id.rv_1);
        staticRvAdapter = new StaticRvAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(staticRvAdapter);

        items.add(new DynamicRvModel("burger"));
        items.add(new DynamicRvModel("fries"));
        items.add(new DynamicRvModel("hotdog"));
        items.add(new DynamicRvModel("burger"));
        items.add(new DynamicRvModel("icecream"));
        items.add(new DynamicRvModel("pizza"));
        items.add(new DynamicRvModel("hotdog"));
        items.add(new DynamicRvModel("pizza"));
        items.add(new DynamicRvModel("fries"));
        items.add(new DynamicRvModel("fries"));
        items.add(new DynamicRvModel("hotdog"));

        RecyclerView drv = findViewById(R.id.rv_2);
        drv.setLayoutManager(new LinearLayoutManager(this));
        dynamicRvAdapter = new DynamicRvAdapter(drv, this, items);
        drv.setAdapter(dynamicRvAdapter);

        dynamicRvAdapter.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {
                if (item.size() < 10) {
                    item.add(null);
                    dynamicRvAdapter.notifyItemInserted(item.size() - 1);
                    new Handler().postDelayed(() -> {
                        items.remove(item.size() - 1);
                        dynamicRvAdapter.notifyItemRemoved(items.size());

                        int index = item.size();
                        int end = index + 10;
                        for (int i = index; i < end; i++) {
                            String name = UUID.randomUUID().toString();
                            DynamicRvModel item1 = new DynamicRvModel(name);
                            items.add(item1);
                        }
                        dynamicRvAdapter.notifyDataSetChanged();
                        dynamicRvAdapter.setLoaded();
                    }, 4000);
                } else
                    Toast.makeText(DashBoardActivity.this, "Data Completed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}