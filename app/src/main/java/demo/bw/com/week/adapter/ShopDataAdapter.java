package demo.bw.com.week.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import demo.bw.com.week.R;
import demo.bw.com.week.bean.ShopBean;

public class ShopDataAdapter extends XRecyclerView.Adapter<ShopDataAdapter.HolderView>{
    private List<ShopBean.shopData> list;
    private Context context;

    public ShopDataAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<ShopBean.shopData> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public void addList(List<ShopBean.shopData> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder( @NonNull ViewGroup viewGroup, int i ) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        HolderView holderView = new HolderView(view);
        return holderView;
    }

    @Override
    public void onBindViewHolder( @NonNull ShopDataAdapter.HolderView holderView, final int i ) {
        Uri url = Uri.parse(list.get(i).masterPic);
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(url)
                .setAutoPlayAnimations(true)
                .build();
        holderView.item_image.setController(controller);

        holderView.itemtv_name.setText(list.get(i).commodityName);
        holderView.itemtv_price.setText(list.get(i).price);
        holderView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onclickitem!=null){
                    onclickitem.getId(list.get(i).commodityId);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return  list.size()>0?list.size():0;
    }

    public class HolderView extends RecyclerView.ViewHolder {

        private SimpleDraweeView item_image;
        private TextView itemtv_name;
        private TextView itemtv_price;

        public HolderView(View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.item_image);
            itemtv_name = itemView.findViewById(R.id.itemtv_name);
            itemtv_price = itemView.findViewById(R.id.itemtv_price);
        }
    }


    public interface onClickitem{
        void getId(String id);
    }

    private onClickitem onclickitem;

    public void setOnclickitem(onClickitem onclickitem) {
        this.onclickitem = onclickitem;
    }
}
