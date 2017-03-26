package design.material.com.twoviewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager2;
    private ViewPager viewPager1;
    private CustomPagerAdapter1 customPagerAdapter1;
    private CustomPagerAdapter2 customPagerAdapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager1 = (ViewPager) findViewById(R.id.viewpager1);
        viewPager2 = (ViewPager) findViewById(R.id.viewpager2);

        customPagerAdapter1 = new CustomPagerAdapter1(this);
        customPagerAdapter2 = new CustomPagerAdapter2(this);

        viewPager1.setAdapter(customPagerAdapter1);
        viewPager2.setAdapter(customPagerAdapter2);

        viewPager1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                viewPager2.onTouchEvent(event);
                return false;
            }
        });

        viewPager2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                viewPager1.onTouchEvent(event);
                return false;
            }
        });


    }


}
