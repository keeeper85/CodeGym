package com.codegym.task.task32.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI (part 2)

Implement the run() method on SERVER_THREAD. It will simulate the server:
1) Initialize the registry field. It will accept and process requests on port 2099.
2) Create two objects: a Cat and a Dog.
3) Use the UnicastRemoteObject class to create Remote objects for the Cat and Dog objects you've created.
The Remote objects will be able to receive method calls using the chosen port (2099).
4) For Cat and Dog, add to the registry a mapping between a unique text key and the Remote object. Make up your own text key.
5) If an exception occurs, output its stack trace to the System.err stream.
The main() method is not tested.

*/

public class Solution {
    public static Registry registry;
    public static final String UNIC_BINDING_NAME = "server.animal";

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //write your code here
            try {
                final Cat cat = new Cat("Kocioł");
                final Dog dog = new Dog("Pieseł");

                registry = LocateRegistry.createRegistry(2099);
                Remote stubCat = UnicastRemoteObject.exportObject(cat, 0);
                Remote stubDog = UnicastRemoteObject.exportObject(dog, 0);

                registry.bind(UNIC_BINDING_NAME, stubCat);
                registry.bind(UNIC_BINDING_NAME, stubDog);

            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (AlreadyBoundException e) {
                e.printStackTrace();
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}
