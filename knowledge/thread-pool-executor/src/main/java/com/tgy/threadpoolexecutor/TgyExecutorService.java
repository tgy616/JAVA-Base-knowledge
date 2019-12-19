package com.tgy.threadpoolexecutor;

/**
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-12-11 15:17
 **/
public interface TgyExecutorService {

    void execute(Runnable task);

    void shutdown();


}
