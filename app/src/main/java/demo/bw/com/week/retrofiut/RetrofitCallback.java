package demo.bw.com.week.retrofiut;

public interface RetrofitCallback {
    void Success(String response);
    void Failure(String msg);
}
