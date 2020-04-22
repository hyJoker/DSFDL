package com.example.demo.vo;

/**
 * @ClassName Data
 * @Description
 * @Author Rex
 * @Date 2020-03-28 20:08
 * @Version 1.0
 **/
public class Data {

    private int m;
    private int n;

    public Data(int m, int n) {
        this.m = m;
        this.n = n;
    }

    @Override
    public String toString() {
        return "Data{" +
                "m=" + m +
                ", n=" + n +
                '}';
    }
}
