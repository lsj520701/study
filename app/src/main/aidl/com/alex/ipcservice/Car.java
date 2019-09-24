package com.alex.ipcservice;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {

    String name ;
    int money;

    public Car(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    protected Car(Parcel in) {
        name = in.readString();
        money = in.readInt();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };
    public void readFromParcel(Parcel dest) {
        name = dest.readString();
        money=dest.readInt();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeLong(money);
    }
}
