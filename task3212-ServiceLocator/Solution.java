package com.codegym.task.task32.task3212;

import com.codegym.task.task32.task3212.service.Service;

/* 
Service locator

Read about the Service Locator pattern.

Implement the getService(String jndiName) method in ServiceLocator.
It will implement logic for working with the context and cache.

1) Return the required service from the cache.
2) If the cache doesn't have the required service, then:
2.1) Create the context.
2.2) Get the required service from the context.
2.3) Add the service to the cache and return it.

*/

public class Solution {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();

    }

}
