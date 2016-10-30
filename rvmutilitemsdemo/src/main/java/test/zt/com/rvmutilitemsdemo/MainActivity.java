package test.zt.com.rvmutilitemsdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = ((RecyclerView) findViewById(R.id.activity_main_recyclerViewId));
        //设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //实例化适配器
        adapter = new RVAdapter(this);

        //添加头部和尾部布局一定要在设置适配器之前
        RelativeLayout headerView = new RelativeLayout(this);
        headerView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,250));
        headerView.setBackgroundColor(Color.RED);

        RelativeLayout headerView1 = new RelativeLayout(this);
        headerView1.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,250));
        headerView1.setBackgroundColor(Color.BLUE);

        adapter.addHeaderView(headerView);
        adapter.addHeaderView(headerView1);

        adapter.setOnItemClickListener(new RVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "点击了第"+position+"个条目", Toast.LENGTH_SHORT).show();
            }
        });

        //设置尾部
        View footerView = getLayoutInflater().inflate(R.layout.item_footerview, recyclerView, false);

        View footerView1 = getLayoutInflater().inflate(R.layout.item_footerview, recyclerView, false);
        adapter.addFooterView(footerView);
        adapter.addFooterView(footerView1);

        //一定要在设置适配器之前加载
        recyclerView.setAdapter(adapter);
        loadData();
    }

    private void loadData() {
        ArrayList<String> dd = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            dd.add("item:"+i);
        }
        adapter.addAll(dd);
    }
}
