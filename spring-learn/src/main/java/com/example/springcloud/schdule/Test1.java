package com.example.springcloud.schdule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: kevin yang
 * @Description:
 * @Date: create in 2020/10/21 10:32
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test1 implements Runnable {

    String s;
    @Override
    public void run() {
        System.out.println(s);
    }
}
