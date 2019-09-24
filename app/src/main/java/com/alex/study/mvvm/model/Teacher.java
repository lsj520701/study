package com.alex.study.mvvm.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Teacher extends BaseObservable {


    String major;
    String school;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;

    @Bindable
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Bindable
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
