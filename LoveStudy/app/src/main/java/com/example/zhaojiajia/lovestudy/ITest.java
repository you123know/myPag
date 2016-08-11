package com.example.zhaojiajia.lovestudy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by zhaojiajia on 2016/7/5.
 */
public interface ITest {
    @GET("HopeServlet?where=select")
    Call<List<Hope>> getAllHope();

    @GET("HopeServlet")
    Call<Hope> deleteHope(@Query("where") String where, @Query("id") String id);
}
