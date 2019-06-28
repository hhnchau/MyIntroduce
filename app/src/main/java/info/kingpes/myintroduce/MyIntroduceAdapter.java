package info.kingpes.myintroduce;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class MyIntroduceAdapter extends FragmentStatePagerAdapter {
    private List<Object> lst;

    public MyIntroduceAdapter(FragmentManager fm, List<Object> lst) {
        super(fm);
        this.lst = lst;
    }

    @Override
    public Fragment getItem(int i) {
        String s = lst.get(i).toString();
        return IntroduceFragment.newInstance(s);
    }

    @Override
    public int getCount() {
        return lst.size();
    }
}
