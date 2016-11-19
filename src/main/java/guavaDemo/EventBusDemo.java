package guavaDemo;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import elasticjobDemo.Foo;

/**
 * All rights Reserved, Designed By Migu.cn
 *
 * @version V1.0
 * @Title: SomeStudy  .java
 * @Package guavaDemo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: lujango
 * @date: 2016年11月16/11/19日 下午12: 47
 * @updater: lujango
 * @updates: TODO
 */
public class EventBusDemo {
    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        eventBus.register(new Object() {

            @Subscribe
            public void lister(Integer integer) {
                System.out.printf("%s from int%n", integer);
            }

            @Subscribe
            public void lister(Number integer) {
                System.out.printf("%s from Number%n", integer);
            }

            @Subscribe
            public void lister(Long integer) {
                System.out.printf("%s from long%n", integer);
            }
        });

        eventBus.register(new Object(){
            @Subscribe
            public void lister(Foo foo){
                System.out.println("Foo :"+foo.getTestName());
            }
        });

        eventBus.post(1);
        eventBus.post(1L);
        eventBus.post(new Foo("hehe","haha"));
    }
}
