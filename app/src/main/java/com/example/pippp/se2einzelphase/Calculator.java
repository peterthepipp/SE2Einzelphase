package com.example.pippp.se2einzelphase;

/**
 * Created by pippp on 12.03.2017.
 */

public class Calculator {

    public Calculator(){

    }

    public float divide(float dividend, float divisor) throws Exception{

        if(divisor==0){
            throw new Exception("Divison durch 0 nicht möglich");
        }
        return dividend/divisor;
    }
}
