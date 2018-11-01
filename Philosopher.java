class Philosopher extends Thread { 
    int idNumber; 
    Chopstick left; 
    Chopstick right; 
    final static int SLEEP_TIME =  5; 
  
    Philosopher(int idNumber, Chopstick left, Chopstick right){ 
        this.idNumber = idNumber; 
        this.left = left; 
        this.right = right; 
    } 
  
    public void run() { 
        try { 
            while(true){
                System.out.println("Philosopher " + idNumber  + " thinks..."); 
                sleep(SLEEP_TIME);  
                System.out.println("Philosopher " + idNumber  + " is hungry..."); 
                right.get();   
                left.get();  
                System.out.println("Philosopher " + idNumber  + " eats..."); 
                sleep(SLEEP_TIME) ;  
                right.put();  
                left.put(); 
            }
        } catch (InterruptedException e) {  
              System.out.println(e); 
            } 
        System.out.println("Philosopher number " + idNumber  + " died with a full stomach");   
    }
} 
 

 

