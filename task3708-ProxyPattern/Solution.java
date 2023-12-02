package com.codegym.task.task37.task3708;

import com.codegym.task.task37.task3708.retrievers.CachingProxyRetriever;
import com.codegym.task.task37.task3708.retrievers.OriginalRetriever;
import com.codegym.task.task37.task3708.retrievers.Retriever;
import com.codegym.task.task37.task3708.storage.RemoteStorage;
import com.codegym.task.task37.task3708.storage.Storage;

/* 
Caching proxy

The Proxy pattern provides an object that controls access to another object.

You need to create a CachingProxyRetriever class in the retrievers package.
It will provide the same functionality as the OriginalRetriever class, but with one important addition.
You need to always try to first get the object from a cache,
and only perform the expensive operation of loading it from storage if it is not in the cache.
After the required object is retrieved from storage, it must be cached using an LRUCache object.
For the client (in this case, the Solution class), using CachingProxyRetriever should be no different
than using the OriginalRetriever class.

P.S. You will need LRUCache and OriginalRetriever fields in the CachingProxyRetriever class.

*/

public class Solution {
    private static final int n = 10;

    public static void main(String[] args) {
        Storage storage = new RemoteStorage();

        fillStorage(storage);

        System.out.println("Testing OriginalRetriever: ");
        testRetriever(new OriginalRetriever(storage));

        System.out.println("\n\n\n\n\n\n\n\n\n\nTesting CachingProxyRetriever: ");
        testRetriever(new CachingProxyRetriever(storage));
    }

    private static void fillStorage(Storage storage) {
        for (int i = 0; i < n; i++) {
            storage.add("Resource #" + i);
        }
    }

    private static void testRetriever(Retriever retriever) {
        for (int i = 0; i < n * 4; i++) {
            System.out.println("Loaded value : " + retriever.retrieve((long) (Math.random() * n)));
        }
    }
}
