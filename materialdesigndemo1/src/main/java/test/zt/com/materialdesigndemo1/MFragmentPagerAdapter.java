package test.zt.com.materialdesigndemo1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */

public class MFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private static final String[] TTILE_TEST={"TAB1","TAB2","TAB3","TAB4"};

    public MFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TTILE_TEST[position];
    }
}
