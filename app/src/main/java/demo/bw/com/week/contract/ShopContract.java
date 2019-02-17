package demo.bw.com.week.contract;

import java.util.HashMap;

import demo.bw.com.week.bean.ShopBean;
import demo.bw.com.week.bean.ShopYiang;
import demo.bw.com.week.model.ShopModel;

public interface ShopContract {
    abstract class conPresenter{
        public abstract void getshopData(HashMap<String,String> params);
        public abstract void getshopYiang(String id);
    }

    interface conModel{
        void getshopData(HashMap<String,String> params,ShopModel.getResponceDataCallback callback);
        void getshopYiang(String id,ShopModel.getResponceDataCallback callback);

    }
    interface conView{
        void shopDataSuccess(ShopBean shopBean);
        void shopYiangSuccess(ShopYiang shopYiang);
        void Frailure(String msg);
    }
}
