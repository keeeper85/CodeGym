package com.codegym.task.task37.task3708.retrievers;

import com.codegym.task.task37.task3708.cache.LRUCache;
import com.codegym.task.task37.task3708.storage.RemoteStorage;
import com.codegym.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{

    OriginalRetriever originalRetriever;
    LRUCache cache;
    Storage storage;

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        originalRetriever = new OriginalRetriever(storage);
        cache = new LRUCache<>(16);
    }

    @Override
    public Object retrieve(long id) {

        Object obj = null;
        obj = cache.find(id);
        if (obj != null) return obj;

        obj = originalRetriever.retrieve(id);
        cache.set(id, obj);
        return obj;
    }
}
