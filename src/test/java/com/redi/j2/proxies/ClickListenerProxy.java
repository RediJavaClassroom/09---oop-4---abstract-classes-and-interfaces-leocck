package com.redi.j2.proxies;

import com.redi.j2.utils.ReflectionProxy;

public class ClickListenerProxy extends ReflectionProxy {
    @Override
    public String getTargetClassName() {
        return "com.redi.j2.ClickListener";
    }
}
