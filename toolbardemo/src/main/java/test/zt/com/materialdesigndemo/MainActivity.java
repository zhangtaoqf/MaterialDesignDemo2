package test.zt.com.materialdesigndemo;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 *
 * Toolbar的使用
 * 1.去掉actionbar
 *
 */
public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = ((Toolbar) findViewById(R.id.activity_main_toolbarId));
        setSupportActionBar(toolbar);
        drawerLayout = ((DrawerLayout) findViewById(R.id.activity_main_drawerLayoutId));
        /**
         * 参数一：activity
         * 参数二：drawerLayout
         * 参数三：toolbar
         * 参数四：打开的状态
         * 参数五：关闭的状态
         */
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        //设置打开监听
        drawerLayout.addDrawerListener(drawerToggle);

        drawerToggle.syncState();
    }
}
