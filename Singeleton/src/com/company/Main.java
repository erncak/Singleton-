package com.company;

public class Main
{
    public static void main(String[] args) {
        EagerObject object = EagerObject.getInstance();
        object.addCoins(3);
        object.decrease(2);
        LazyObject lazyObject= LazyObject.getInstance();
        lazyObject.addCoins(3);
        lazyObject.decrease(2);
        ThreadSafeObject threadSafeObject = ThreadSafeObject.getInstance();
        threadSafeObject.addCoins(3);
        threadSafeObject.decrease(2);
        System.out.println(object);
        System.out.println(lazyObject);
        System.out.println(threadSafeObject);



    }
}


class EagerObject {
    private int coins;
    private static EagerObject instance = new EagerObject(3);
    private EagerObject(int c){
        coins=c;
    }
    public static EagerObject getInstance(){
        return instance;
    }
    public void addCoins(int c){
        coins=coins+c;
        System.out.println("The number of coins is "+coins);
    }
    public void decrease(int c){
        coins=coins-c;
        System.out.println("The number of coins is "+coins);
    }
}
class LazyObject {
    private int coins;
    private static LazyObject instance;
    private LazyObject(int c){
        coins=c;
    }
    public static LazyObject getInstance(){
        if(instance == null){
            instance = new LazyObject(3);
        }
        return instance;
    }
    public void addCoins(int c){
        coins=coins+c;
        System.out.println("The number of coins is "+coins);
    }
    public void decrease(int c){
        coins=coins-c;
        System.out.println("The number of coins is "+coins);
    }
}
class ThreadSafeObject {
    private int coins;
    private static ThreadSafeObject instance;
    private ThreadSafeObject(int c){
        coins=c;
    }
    public static synchronized ThreadSafeObject getInstance(){
        if(instance == null){
            instance = new ThreadSafeObject(3);
        }
        return instance;
    }
    public void addCoins(int c){
        coins=coins+c;
        System.out.println("The number of coins is "+coins);
    }
    public void decrease(int c){
        coins=coins-c;
        System.out.println("The number of coins is "+coins);
    }
}
