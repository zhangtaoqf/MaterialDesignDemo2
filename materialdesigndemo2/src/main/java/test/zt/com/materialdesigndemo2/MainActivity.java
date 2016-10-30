package test.zt.com.materialdesigndemo2;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    RVAdapter adapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = ((Toolbar) findViewById(R.id.activity_main_toolbarId));

        CoordinatorLayout.LayoutParams layoutParams1 = (CoordinatorLayout.LayoutParams) toolbar.getLayoutParams();

        layoutParams1.setBehavior(new MBToolbarBahavior());

        toolbar.setLayoutParams(layoutParams1);

        recyclerView = ((RecyclerView) findViewById(R.id.activity_main_recyclerViewId));
        fab = ((FloatingActionButton) findViewById(R.id.activity_main_fabId));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RecyclerView滚动到顶部
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                layoutManager.smoothScrollToPosition(recyclerView,null,0);

            }
        });
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();

        layoutParams.setBehavior(new MBFABBahavior());

        fab.setLayoutParams(layoutParams);

        //设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //实例化适配器
        adapter = new RVAdapter(this);
        //设置适配器
        recyclerView.setAdapter(adapter);
        //加载数据
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
