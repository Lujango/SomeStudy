package rxjavaDemo;

import com.google.common.collect.Lists;
import rx.Observable;
import rx.Scheduler;
import rx.Single;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.List;

/**
 * All rights Reserved, Designed By Migu.cn
 *
 * @version V1.0
 * @Title: SomeStudy  .java
 * @Package PACKAGE_NAME
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: lujango
 * @date: 2016年11月16/11/22日 下午17: 49
 * @updater: lujango
 * @updates: TODO
 */
public class RxJavaDemo {
    public void simpleRxJava() {
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {

                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("Hello, world1!");
                        sub.onNext("Hello, world2!");
                        sub.onNext("Hello, world3!");
                        int i = 0 / 0;
                        sub.onCompleted();
                    }
                }
        );

        Subscriber<String> mySubscriber = new Subscriber<String>() {

            public void onNext(String s) {
                System.out.println(s);
            }

            public void onCompleted() {
                System.out.println("onCompleted");
            }

            public void onError(Throwable e) {
                System.out.println("onError: " + e.getMessage());
            }
        };

        myObservable.subscribe(mySubscriber);

    }

    public void simple2RxJava() {
        Observable<String> myObservable = Observable.just("Hello, world!");

        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("onNextAction: " + s);
            }
        };
        //myObservable.subscribe(onNextAction, onErrorAction, onCompleteAction);
        myObservable.subscribe(onNextAction);
        myObservable.subscribe((s) -> {
            System.out.println(s);
        });


        Observable.just("Hello, world!")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });

        //使用java8的lambda可以使代码更简洁
        Observable.just("Hello, world !").subscribe(s -> System.out.println(s));

    }


    //操作符
    public void OperatorsRxJava() {
/*
    创建操作 Create, Defer, Empty/Never/Throw, From, Interval, Just, Range, Repeat, Start, Timer
    变换操作 Buffer, FlatMap, GroupBy, Map, Scan和Window
    过滤操作 Debounce, Distinct, ElementAt, Filter, First, IgnoreElements, Last, Sample, Skip, SkipLast, Take, TakeLast
    组合操作 And/Then/When, CombineLatest, Join, Merge, StartWith, Switch, Zip
    错误处理 Catch和Retry
    辅助操作 Delay, Do, Materialize/Dematerialize, ObserveOn, Serialize, Subscribe, SubscribeOn, TimeInterval, Timeout, Timestamp, Using
    条件和布尔操作 All, Amb, Contains, DefaultIfEmpty, SequenceEqual, SkipUntil, SkipWhile, TakeUntil, TakeWhile
    算术和集合操作 Average, Concat, Count, Max, Min, Reduce, Sum
    转换操作 To
    连接操作 Connect, Publish, RefCount, Replay
    反压操作，用于增加特殊的流程控制策略的操作符

    这些操作符并不全都是ReactiveX的核心组成部分，有一些是语言特定的实现或可选的模块。 */


        //map操作符，就是用来把把一个事件转换为另一个事件的
        Observable.just("Hello, world!")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + " -Dan";
                    }
                })
                .subscribe(s -> System.out.println(s));

        Observable.just("Hello, world!")
                .map(s -> s + " -Dan")
                .subscribe(s -> System.out.println(s));


        Observable.just("Hello, world!")
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return s.hashCode();
                    }
                }).subscribe(i -> System.out.println(Integer.toString(i)));

        Observable.just("Hello, world!")
                .map(s -> s.hashCode())
                .map(i -> Integer.toString(i))
                .subscribe(s -> System.out.println(s));


        Observable.from(Lists.newArrayList("url1", "url2", "url3"))
                .subscribe(url -> System.out.println(url));


        //flatmap
        query("Hello, world!")
                .flatMap(new Func1<List<String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(List<String> urls) {
                        return Observable.from(urls);
                    }
                })
                .subscribe(url -> System.out.println(url));

        //多个flatmap
        query("Hello, world!")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String url) {
                        return getTitle(url);
                    }
                })
                .subscribe(title -> System.out.println(title));

        //filter
        query("Hello, world!")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> getTitle(url))
                .filter(title -> title != null)
                .subscribe(title -> System.out.println(title));


        // 如果我们只想要最多5个结果  ,take()输出最多指定数量的结果。
        query("Hello, world!")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> getTitle(url))
                .filter(title -> title != null)
                .take(5)
                .subscribe(title -> System.out.println(title));

        //doOnNext()允许我们在每次输出一个元素之前做一些额外的事情
        query("Hello, world!")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> getTitle(url))
                .filter(title -> title != null)
                .take(5)
                .doOnNext(title -> saveTitle(title))
                .subscribe(title -> System.out.println(title));
    }




    //Single是Observable变种
    public void simple3RxJava() {
        Single.just("hehe").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }

    // 调度器
    public void schedulerRxJava(){
        Scheduler.Worker worker = Schedulers.newThread().createWorker();
        worker.schedule(new Action0() {

            @Override
            public void call() {
                //
            }

        });



        // 递归调度器
        Scheduler.Worker worker1 = Schedulers.newThread().createWorker();
        worker.schedule(new Action0() {

            @Override
            public void call() {
               // yourWork();
                // recurse until unsubscribed (schedule will do nothing if unsubscribed)
                worker1.schedule(this);
            }

        });


        worker.unsubscribe();

    }


    void saveTitle(String title) {
        System.out.println(title);
    }

    Observable<List<String>> query(String text) {
        return Observable.just(Lists.newArrayList("url1", "url2", "url3"));
    }

    Observable<String> getTitle(String URL) {
        return Observable.just("hehe");
    }


    public static void main(String[] args) {
        new RxJavaDemo().simpleRxJava();
        //new RxJavaDemo().simple2RxJava();

    }
}
