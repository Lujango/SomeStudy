package lambdaDemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * All rights Reserved, Designed By Migu.cn
 *
 * @version V1.0
 * @Title: SomeStudy  .java
 * @Package lambdaDemo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: lujango
 * @date: 2016年11月16/11/19日 下午20: 30
 * @updater: lujango
 * @updates: TODO
 */
@AllArgsConstructor
@Getter
@Setter
public class Person {
    private String firstName, lastName, job, gender;
    private int salary, age;
}
