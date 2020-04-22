package com.example.demo.service;


import com.example.demo.vo.Data;

public interface FetcherCallback {
    void onDate(Data data);
    void onError(Throwable cause);
}
