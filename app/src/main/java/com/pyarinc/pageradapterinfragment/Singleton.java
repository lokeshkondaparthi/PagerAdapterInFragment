package com.pyarinc.pageradapterinfragment;

import java.util.ArrayList;
import java.util.List;

class Singleton {
    private static final Singleton ourInstance = new Singleton();

    static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }

    public  static List<String> mUrls = new ArrayList<>();
}