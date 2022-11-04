class Foo {

    // public Foo {
        int lock = 0;
    // }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        lock++;
        this.notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        while(lock < 1) wait();
        printSecond.run();
        lock++;
        this.notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        while(lock < 2) wait();
        printThird.run();
    }
}