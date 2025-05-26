package com.yedam.app.di2;

import com.yedam.app.annotation.LgTV;
import com.yedam.app.annotation.SamsungTV;

public class BeanFactory {
    public Object getBean(String beanName){
        if(beanName.equals("samsung")){
            return new SamsungTV(null);
        } else if(beanName.equals("lg")){
            return new LgTV();
        }
        return null;
    }

}
