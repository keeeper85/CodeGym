package com.codegym.task.task29.task2908;

import java.util.concurrent.*;

/* Argument and Value are generic types
*
* In CacheComputeManager, implement the logic of the empty method.
Guess what it should do based on the method name and the class's logic.
*
* */
public class CacheComputeManager<Argument, Value> implements Computable<Argument, Value> {
    private final ConcurrentHashMap<Argument, Future<Value>> cache = new ConcurrentHashMap<>();
    private final Computable<Argument, Value> computable;

    public CacheComputeManager(Computable<Argument, Value> computable) {
        this.computable = computable;
    }

    @Override
    public Value compute(final Argument arg) throws InterruptedException {
        Future<Value> f = cache.get(arg);
        if (f == null) {
            FutureTask<Value> ft = createFutureTaskForNewArgumentThatHasToComputeValue(arg);
            cache.putIfAbsent(arg, ft);
            f = ft;
            ft.run();
            System.out.print(arg + " will be cached  ");
        } else {
            System.out.print(arg + " taken from cache  ");
        }
        try {
            return f.get();
        } catch (CancellationException e) {
            cache.remove(arg, f);
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
        return null;
    }

    public FutureTask<Value> createFutureTaskForNewArgumentThatHasToComputeValue(final Argument arg) {

//        empty method.

        return new FutureTask<Value>(new Callable<Value>() {
            @Override
            public Value call() throws Exception {
                return computable.compute(arg);
            }
        });
    }
}
