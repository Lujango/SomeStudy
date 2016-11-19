package elasticjobDemo;

import com.dangdang.ddframe.job.api.JobConfiguration;
import com.dangdang.ddframe.job.schedule.JobController;
import com.dangdang.ddframe.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.reg.zookeeper.ZookeeperRegistryCenter;

/**
 * All rights Reserved, Designed By Migu.cn
 *
 * @version V1.0
 * @Title: untitled3  .java
 * @Package PACKAGE_NAME
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: lujango
 * @date: 2016年11月16/11/18日 下午11: 24
 * @updater: lujango
 * @updates: TODO
 */
public class JobDemo {
    // 定义Zookeeper注册中心配置对象
    private ZookeeperConfiguration zkConfig = new ZookeeperConfiguration("localhost:2181", "elastic-job-example1", 1000, 3000, 3);

    // 定义Zookeeper注册中心
    private CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(zkConfig);

    // 定义作业1配置对象
    private JobConfiguration jobConfig1 = new JobConfiguration("elasticjobDemo.oneOffElasticDemoJob", oneOffElasticDemoJob.class, 10, "0/5 * * * * ?");

    // 定义作业2配置对象
    private JobConfiguration jobConfig2 = new JobConfiguration("perpetualElasticDemoJob", PerpetualElasticDemoJob.class, 10, "0/5 * * * * ?");

    // 定义作业3配置对象
 //   private JobConfiguration jobConfig3 = new JobConfiguration("sequencePerpetualElasticDemoJob", SequencePerpetualElasticDemoJob.class, 10, "0/5 * * * * ?");

    public static void main(final String[] args) {
        new JobDemo().init();
    }

    private void init() {
        // 连接注册中心
        regCenter.init();
        // 启动作业1
        new JobController(regCenter, jobConfig1).init();
        // 启动作业2
       // new JobController(regCenter, jobConfig2).init();
        // 启动作业3
   //     new JobController(regCenter, jobConfig3).init();
    }
}
