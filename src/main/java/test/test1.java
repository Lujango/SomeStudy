package test;

/**
 * All rights Reserved, Designed By Migu.cn
 *
 * @version V1.0
 * @Title: SomeStudy  .java
 * @Package test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: lujango
 * @date: 2016年12月16/12/16日 下午23: 14
 * @updater: lujango
 * @updates: TODO
 */
public class test1 {
    public static void main(String[] args) {
        String hehe = "三百";

        int sum = 0;
        int tmp = 0;
        for (int i = 0; i < hehe.toCharArray().length; i++) {
            String str = String.valueOf(hehe.toCharArray()[i]);
            if (str.equals("三")){
                tmp = 3;
            }
            if (str.equals("八")){
                tmp = 8;
            }
            if (str.equals("五")){
                tmp = 5;
            }
            if (str.equals("百")){
                sum += tmp*100;
                tmp=0;
            }
            if (str.equals("十")){
                sum += tmp*10;
                tmp=0;
            }
        }
        sum+=tmp;
        System.out.println(sum);
    }
}
