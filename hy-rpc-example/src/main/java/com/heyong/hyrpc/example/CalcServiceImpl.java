package com.heyong.hyrpc.example;

/**
 * Description
 *
 * @Author heyong
 * @Date 2022/3/12 13:39
 */
public class CalcServiceImpl implements CalcService{
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}
