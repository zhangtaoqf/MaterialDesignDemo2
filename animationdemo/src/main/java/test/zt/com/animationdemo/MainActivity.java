package test.zt.com.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

/**
 *
 * 动画：
 *
 * View的动画
 *
 * 注意：api>=21(android 5.0)
 */
public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = ((ImageView) findViewById(R.id.activity_main_imageViewId));

    }

    public void showImgClick(View view)
    {
        /**
         * 参数一：执行动画的控件
         * 参数二三：动画的中心点
         * 参数四：动画开始的半径
         * 参数五：动画结束的半径
         */
        Animator animator = ViewAnimationUtils.createCircularReveal(imageView, imageView.getWidth() / 2, imageView.getHeight() / 2, 0, imageView.getWidth() / 2);
        //设置时间间隔
        animator.setDuration(5000);

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                imageView.setVisibility(View.VISIBLE);
            }
        });
        //执行动画
        animator.start();
    }

    public void hideImgClick(View view)
    {
        /**
         * 参数一：执行动画的控件
         * 参数二三：动画的中心点
         * 参数四：动画开始的半径
         * 参数五：动画结束的半径
         */
        Animator animator = ViewAnimationUtils.createCircularReveal(imageView, imageView.getWidth() / 2, imageView.getHeight() / 2, imageView.getWidth() /2 , 0);
        //设置时间间隔
        animator.setDuration(5000);

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                imageView.setVisibility(View.INVISIBLE);
            }
        });
        //执行动画
        animator.start();
    }

    /**
     * activity跳转动画
     * @param view
     */
    public void startToAc2Click(View view) {
        startActivity(new Intent(this,Main2Activity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}

