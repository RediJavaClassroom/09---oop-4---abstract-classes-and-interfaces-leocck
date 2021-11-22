package com.redi.j2.proxies;

import com.redi.j2.utils.ReflectionProxy;

public class DisplayableProxy extends ReflectionProxy {
    @Override
    public String getTargetClassName() {
        return "com.redi.j2.Displayable";
    }
}
