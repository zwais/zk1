package demo.bw.com.week.model;

import java.util.HashMap;

import demo.bw.com.week.api.Api;
import demo.bw.com.week.contract.ShopContract;
import demo.bw.com.week.retrofiut.RetrofitCallback;
import demo.bw.com.week.retrofiut.RetrofitUtils;

public class ShopModel implements ShopContract.conModel {
    @Override
    public void getshopData( HashMap<String, String> params, final getResponceDataCallback callback ) {
        String keyword = params.get("keyword");
        String page = params.get("page");
        String count = params.get("count");
        RetrofitUtils.initRetrofitUtils().doGet(Api.selectUrl + "?keyword=" + keyword + "&page=" + page + "&count=" + count, new RetrofitCallback() {
            @Override
            public void Success(String response) {
                if (callback!=null){
                    callback.Success(response);
                }
            }

            @Override
            public void Failure(String msg) {
                if (callback!=null){
                    callback.Frailure(msg);
                }
            }
        });

    }

    @Override
    public void getshopYiang( String id, final getResponceDataCallback callback ) {
        RetrofitUtils.initRetrofitUtils().doGet(Api.shopUrl + "?commodityId=" + id, new RetrofitCallback() {
            @Override
            public void Success(String response) {
                if (callback!=null){
                    callback.Success(response);
                }
            }

            @Override
            public void Failure(String msg) {
                if (callback!=null){
                    callback.Frailure(msg);
                }
            }
        });

    }
    public interface getResponceDataCallback{
        void Success(String res);
        void Frailure(String msg);
    }
}
