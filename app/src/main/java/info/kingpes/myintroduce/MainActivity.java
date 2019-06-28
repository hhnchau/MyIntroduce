package info.kingpes.myintroduce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends /*MyIntroduceActivity*/ AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyIntroduce myIntroduce = findViewById(R.id.myIntro);

        List<Object> lst = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            lst.add("Demo" + i);
        myIntroduce.startIntroduce(getSupportFragmentManager(),lst);
        //startIntroduce(lst);

    }

//    @Override
//    protected void onSkipButtonPressed() {
//        super.onSkipButtonPressed();
//        Toast.makeText(this, "SKIP", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onFinishButtonPressed() {
//        Toast.makeText(this, "DONE", Toast.LENGTH_SHORT).show();
//    }

}
