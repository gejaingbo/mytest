package com.example.demo.Controller;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/5/29
 * @mail jiangbo.ge@kuwo.cn
 */
public class Practic {
    private static Practic d = new Practic();
    private SubClass t = new SubClass();
    static {
        System.out.println("3");
    }
    public Practic(){
        System.out.println(4);
    }
    public static void main(String[] args){
        System.out.println("hello");
    }
}

class SuperClass{
    SuperClass(){
        System.out.println("构造Superclass");
    }
}
class SubClass extends SuperClass{

    static{
        System.out.println("1");
    }
    public SubClass(){
        System.out.println("2");
    }

}