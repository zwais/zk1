package demo.bw.com.week.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import demo.bw.com.week.R;
import demo.bw.com.week.adapter.ViewPagerAdapter;

public class ImageActivity extends AppCompatActivity {

    private Unbinder bind;
    @BindView(R.id.viewpage)
    ViewPager viewpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        EventBus.getDefault().register(this);
    }



    @Subscribe(sticky = true)
    public void getImage(String[] image){

        bind = ButterKnife.bind(this);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this,image);
        viewpage.setAdapter(viewPagerAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
