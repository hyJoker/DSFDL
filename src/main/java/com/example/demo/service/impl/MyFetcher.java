package com.example.demo.service.impl;

import com.example.demo.service.Fetcher;
import com.example.demo.service.FetcherCallback;
import com.example.demo.vo.Data;

/**
 * @ClassName MyFetcher
 * @Description
 * @Author Rex
 * @Date 2020-03-28 20:10
 * @Version 1.0
 **/
public class MyFetcher implements Fetcher {

    final Data data;

    public MyFetcher(Data data) {
        this.data = data;
    }

    @Override
    public void fetchData(FetcherCallback callback) {
        try {
            System.out.println("data..........");
            callback.onDate(data);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
