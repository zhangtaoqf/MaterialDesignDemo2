package test.zt.com.materialdesigndemo2;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/10/27.
 */

public class MBFABBahavior extends CoordinatorLayout.Behavior {
    public MBFABBahavior() {
    }

    public MBFABBahavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 是否接收滚动控件的滚动
     * @param coordinatorLayout
     * @param child
     * @param directTargetChild
     * @param target
     * @param nestedScrollAxes
     * @return
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    /**
     * 处理它的滚动
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dx
     * @param dy
     * @param consumed
     */
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if(dy>0)//控件向下
        {
            ViewCompat.animate(child).translationY(child.getHeight()).start();
        }else
        {
            ViewCompat.animate(child).translationY(0).start();
        }
    }
}
