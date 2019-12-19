package com.tgy.threadpoolexecutor;

import com.tgy.threadpoolexecutor.policy.PolicyHandler;

import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-12-11 15:19
 **/

public class TgyTheadPoolExecutor implements TgyExecutorService {
    /**
     * 记录当前alive的线程数
     */
    private AtomicInteger ctl=new AtomicInteger();
    /**
     * 拒绝策略
     */
    private volatile PolicyHandler handler;
    /**
     * 核心线程数
     */
    private int poolSize;
    /**
     * 阻塞队列，保存任务
     */
    private final BlockingQueue<Runnable> workQueue;
    //是否允许核心线程超时，释放无用线程
    private volatile boolean allowThreadTimeOut=false;
    //线程超时时间
    private final long keepAliveTime;
    //并发场景使用线程池
    private ReentrantLock mainLock=new ReentrantLock();
    //关注线程池当前的运行状态
    private volatile boolean isShutDown=false;
    //记录线程池执行的总的任务量
    private volatile long comletedTaskCount=0;
    //记录当前线程
    private final HashSet<Worker> workers=new HashSet<>();

    public TgyTheadPoolExecutor(int poolSize,int queuesize,long keepAliveTime,PolicyHandler hander){
        if (poolSize<=0)throw new IllegalArgumentException("核心线程数不能为空");
        this.poolSize=poolSize;
        this.handler=hander;
        this.keepAliveTime=keepAliveTime;
        if (keepAliveTime>0)allowThreadTimeOut=true;
        this.workQueue=new ArrayBlockingQueue<>(5);

    }

    @Override
    public void execute(Runnable task) {
        int c=ctl.get();
        if (c<poolSize){
            if(true){}//创建新的工人，核心线程数
        }
    }

    public boolean addWorker(Worker worker){
        

        return false;
    }

    @Override
    public void shutdown() {

    }

    public Runnable getTask(){
       return this.workQueue.poll();
    }

    AtomicInteger counter=new AtomicInteger();

    class Worker implements Runnable{
        final Thread thread;

        Runnable firstTask;

        public Worker(Runnable task){
            this.firstTask=task;
            this.thread=new Thread(this,"thread-Id-"+counter.incrementAndGet());
        }

        @Override
        public void run() {
            while (firstTask!=null||getTask()!=null){

            }
        }
    }
}
