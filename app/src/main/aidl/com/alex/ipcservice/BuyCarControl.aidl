// BuyCarControl.aidl
package com.alex.ipcservice;

// Declare any non-default types here with import statements

import com.alex.ipcservice.Car;
interface BuyCarControl {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
     String lookCar();
     Car buyCar(in int money);
}
