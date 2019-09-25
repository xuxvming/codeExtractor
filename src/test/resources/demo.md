# This is a demo project for literate programming 

This file contians a hello world java demo program. It is made up of three components.
First, we want to write a function that print hello world for us. 

##Method-1
```
      public void print(){
   	    System.out.println("hello world");
       }
```
   
Next, we want to create a class and put that [method](##Method-1) in this class
```
     public class myClass{
      }
```
    

In the main function, we want to call this method inside that class
```
public static void main(String[] args){
	    myClass myclass = new myClass();
	    myclass.print();
    }

```
    
