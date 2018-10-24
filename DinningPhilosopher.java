class Philosopher extends Thread { 
     int idNumber; 

     Chopstick left; 
     Chopstick right; 
  
 Philosopher(int idNumber, Chopstick left, Chopstick right){ 
    this.idNumber = idNumber; 
    this.left = left; 
    this.right = right; 
 } 
  
 public void run() { 
   /*for(int i = 0; i < 50; i++) {*/
   try { 
    while(true){
    System.out.println("Philosopher " + idNumber  + " thinks..."); 
    sleep(5);  
    System.out.println("Philosopher " + idNumber  + " is hungry..."); 
    right.get();   
    left.get();  
    System.out.println("Philosopher " + idNumber  + " eats..."); 
    sleep(5) ;  
    right.put();  
    left.put(); 
    }
   } catch (InterruptedException e) {  
        System.out.println(e); 
      } 
 
   //}
System.out.println("Philosopher number " + idNumber  + " died with a full stomach");   

}
} 
 
class Chopstick { 
 
 boolean taken=false;  
 
 synchronized void put() {   
  taken=false; 
 } 
 
 synchronized void get() throws InterruptedException {   

 
   while (taken)
     {
   Thread.currentThread().sleep(100); 
   taken=true;  
}

 } 
} 
 
public class DinningPhilosopher { 
  
 public static void main(String[] args) { 
   
  int numberOfPhilosophers = 5; 
   
  Philosopher phil[] = new Philosopher[numberOfPhilosophers]; 
  Chopstick stick[] = new Chopstick[numberOfPhilosophers]; 
   
  for (int i =0; i<numberOfPhilosophers; i++) {
   stick[i] = new Chopstick(); 
  }
   
  for (int i =0; i<numberOfPhilosophers; i++){ 
 
  // phil[i]=new Philosopher(i,  stick[(i-1+numberOfPhilosophers)%numberOfPhilosophers], stick[i]); 
    
     phil[i] = new Philosopher(i, stick[i], stick[(i+1)%numberOfPhilosophers]);

      phil[i].start(); 
    
  } 
 } 
}
