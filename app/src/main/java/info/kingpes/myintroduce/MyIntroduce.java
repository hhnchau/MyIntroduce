package info.kingpes.myintroduce;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

public class MyIntroduce extends FrameLayout implements View.OnClickListener {
    private ViewPager viewPager;
    private MyIntroduceAdapter adapter;

    public MyIntroduce(@NonNull Context context) {
        super(context);
        init(context);
    }

    public MyIntroduce(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyIntroduce(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.my_introduce, this, true);
        viewPager = v.findViewById(R.id.viewpager);

        TabLayout tabLayout = v.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.setOffscreenPageLimit(3);

        TextView btnSkip = v.findViewById(R.id.tvSkip);
        btnSkip.setOnClickListener(this);
        final TextView btnNext = v.findViewById(R.id.tvNext);
        btnNext.setOnClickListener(this);
        final TextView btnDone = v.findViewById(R.id.tvDone);
        btnDone.setOnClickListener(this);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                int currentPosition = adapter.getCount() - 1;
                btnNext.setVisibility(i == currentPosition ? View.GONE : View.VISIBLE);
                btnDone.setVisibility(i == currentPosition ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    public void startIntroduce(FragmentManager frg, List<Object> lst) {
        if (viewPager != null) {
            adapter = new MyIntroduceAdapter(frg, lst);
            viewPager.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        boolean isInLastPage = viewPager.getCurrentItem() == adapter.getCount() - 1;
        if (i == R.id.tvNext && !isInLastPage) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        } else if (i == R.id.tvSkip) {

        } else if (i == R.id.tvDone && isInLastPage) {

        }
    }
}
