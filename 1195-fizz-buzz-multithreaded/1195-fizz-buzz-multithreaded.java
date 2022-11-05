class FizzBuzz {
    private int n;
    private int counter = 1;
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while(n >= counter){
            if(counter % 3 != 0 || counter % 5 == 0){
                wait(); continue;
            }
            
            printFizz.run();
            counter++;
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while(n >= counter){
            if(counter % 3 == 0 || counter % 5 != 0){
                wait(); continue;
            }
            
            printBuzz.run();
            counter++;
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(n >= counter){
            if(counter % 3 != 0 || counter % 5 != 0){
                wait(); continue;
            }
            
            printFizzBuzz.run();
            counter++;
            notifyAll();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while(n >= counter){
            if(counter % 3 == 0 || counter % 5 == 0){
                wait(); continue;
            }
            
            printNumber.accept(counter);
            counter++;
            notifyAll();
        }
    }
}