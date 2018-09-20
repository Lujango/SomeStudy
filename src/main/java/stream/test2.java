package stream;

import java.util.stream.LongStream;

public class test2 {
    public static void main(String[] args){
        long startTime=System.currentTimeMillis();   //获取开始时间
        LongStream.rangeClosed(1L, 10000L)
                .parallel()
                .forEach(in->{
                    Thread thread = Thread.currentThread();
                    System.out.println("thread: "+thread.getName()+", value: "+in);
                    try{
                        Thread.sleep(5);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                });
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

    }
}
