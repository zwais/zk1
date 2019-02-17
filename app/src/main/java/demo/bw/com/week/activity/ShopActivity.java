package demo.bw.com.week.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.bw.com.week.R;
import demo.bw.com.week.bean.ShopYiang;

public class ShopActivity extends AppCompatActivity {


    private Unbinder bind;

    @BindView(R.id.image)
    SimpleDraweeView image;
    @BindView(R.id.tv_name)
    TextView tv_name;
    private String[] split;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        EventBus.getDefault().register(this);
    }

    @Subscribe(sticky = true)
    public void getShopData(ShopYiang shopYiang){

        bind = ButterKnife.bind(this);
        split = shopYiang.result.picture.split(",");
        Uri uri = Uri.parse(split[0]);
        tv_name.setText(shopYiang.result.commodityName);

        DraweeController controller =  Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        image.setController(controller);

    }

    @OnClick(R.id.image)
    public void onClickImage(View view){
        EventBus.getDefault().postSticky(split);
        startActivity(new Intent(ShopActivity.this,ImageActivity.class));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
