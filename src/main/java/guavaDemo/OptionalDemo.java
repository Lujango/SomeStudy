package guavaDemo;

import com.google.common.base.Optional;

/**
 * All rights Reserved, Designed By Migu.cn
 *
 * @version V1.0
 * @Title: SomeStudy  .java
 * @Package guavaDemo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: lujango
 * @date: 2016年11月16/11/19日 下午21: 52
 * @updater: lujango
 * @updates: TODO
 */
public class OptionalDemo {

    public static void main(String[] args) {
        new OptionalDemo().testOptional();
    }
    public void testOptional(){
        Optional<Integer> possible=Optional.of(6);
        Optional<Integer> absentOpt=Optional.absent();
        Optional<Integer> NullableOpt=Optional.fromNullable(null);
        Optional<Integer> NoNullableOpt= Optional.fromNullable(10);
        if(possible.isPresent()){
            System.out.println("possible isPresent:"+possible.isPresent());
            System.out.println("possible value:"+possible.get());
        }
        if(absentOpt.isPresent()){
            System.out.println("absentOpt isPresent:"+absentOpt.isPresent()); ;
        }
        if(NullableOpt.isPresent()){
            System.out.println("fromNullableOpt isPresent:"+NullableOpt.isPresent());
            System.out.println(NullableOpt.get());

        }

        if (NullableOpt.orNull() == null){
            System.out.println("NullableOpt : null");
        }
        if(NoNullableOpt.isPresent()){
            System.out.println("NoNullableOpt isPresent:"+NoNullableOpt.isPresent()); ;
        }
    }
}
