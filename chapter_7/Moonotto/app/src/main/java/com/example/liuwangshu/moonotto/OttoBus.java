package com.example.liuwangshu.moonotto;

import com.squareup.otto.Bus;

/**
 * Created by Administrator on 2016/11/17 0017.
 */

public class OttoBus extends Bus{
    private volatile static OttoBus bus;
    private OttoBus (){
    }
    public static OttoBus getInstance() {
        if (bus == null) {
            synchronized (OttoBus.class){
             if(bus==null){
                 bus = new OttoBus();
             }
            }
        }
        return bus;
    }
}
