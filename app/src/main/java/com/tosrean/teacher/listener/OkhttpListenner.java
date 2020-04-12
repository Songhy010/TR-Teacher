package com.tosrean.teacher.listener;

public interface OkhttpListenner {
    void onSuccess(String response);
    void onError(String error);
}
