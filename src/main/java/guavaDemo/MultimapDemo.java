package guavaDemo;

import com.google.common.base.Function;
import com.google.common.collect.*;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * All rights Reserved, Designed By Migu.cn
 *
 * @version V1.0
 * @Title: SomeStudy  .java
 * @Package guavaDemo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: lujango
 * @date: 2016年11月16/11/22日 下午13: 24
 * @updater: lujango
 * @updates: TODO
 */
public class MultimapDemo {

    public static void main(String[] args) {
        testmultiMap();
    }

    public static void testmultiMap() {
        Multimap<String, Integer> scoreMultimap = ArrayListMultimap.create();
        for (int i = 10; i < 20; i++) {
            scoreMultimap.put("peida", i);
        }
        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.keys());
        List<Integer> hehe = Lists.newArrayList();
        hehe.add(null);
        hehe.add(1);
        hehe.add(1);
        hehe.add(1);
        Integer[] haha = Iterables.toArray(hehe, Integer.class);
    }
}
