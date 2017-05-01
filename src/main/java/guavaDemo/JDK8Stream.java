package guavaDemo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * All rights Reserved, Designed By Migu.cn
 *
 * @version V1.0
 * @Title: SomeStudy  .java
 * @Package guavaDemo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: lujango
 * @date: 2017年05月5/1/17日 下午15: 45
 * @updater: lujango
 * @updates: TODO
 */
public class JDK8Stream {
    public static void main(String[] args) {

        List<Integer> nums = Lists.newArrayList(1, null, 3, 4, null, 6);

        long count = nums.stream().filter(num -> num != null).count();
        System.out.println("count ；:" + count);

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
        Stream<String> stringStream = Stream.of("taobao");


        Stream.generate(() -> Math.random());

        Stream.generate(Math::random);

        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);


        nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);

        System.out.println("sum is " + nums.stream()
                .filter(num -> num != null)
                .distinct()
                .mapToInt(num -> num * 2)
                .peek(System.out::println)
                .skip(2)
                .limit(4).sum());


        List<Integer> numsWithoutNull = nums.stream()
                .filter(num -> num != null)
                .collect(() -> new ArrayList<Integer>(), (list, item) -> list.add(item), (list1, list2) -> list1.addAll(list2));

        numsWithoutNull = nums.stream()
                .filter(num -> num != null)
                .collect(Collectors.toList());

        List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("ints sum is:" + ints.stream().reduce(0, (sum, item) -> sum + item));
    }
}
