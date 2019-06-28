package info.kingpes.myintroduce;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.util.List;

public abstract class MyIntroduceActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private MyIntroduceAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_introduce);

        viewPager = findViewById(R.id.viewpager);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.setOffscreenPageLimit(3);

        TextView btnSkip = findViewById(R.id.tvSkip);
        btnSkip.setOnClickListener(this);
        final TextView btnNext = findViewById(R.id.tvNext);
        btnNext.setOnClickListener(this);
        final TextView btnDone = findViewById(R.id.tvDone);
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

    public void startIntroduce(List<Object> lst) {
        adapter = new MyIntroduceAdapter(getSupportFragmentManager(), lst);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        boolean isInLastPage = viewPager.getCurrentItem() == adapter.getCount() - 1;
        if (i == R.id.tvNext && !isInLastPage) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        } else if (i == R.id.tvSkip) {
            onSkipButtonPressed();
        } else if (i == R.id.tvDone && isInLastPage) {
            onFinishButtonPressed();
        }
    }

    protected void onSkipButtonPressed() {
        viewPager.setCurrentItem(adapter.getCount());
    }

    abstract public void onFinishButtonPressed();

}
