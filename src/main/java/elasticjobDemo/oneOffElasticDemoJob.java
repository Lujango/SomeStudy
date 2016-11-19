package elasticjobDemo;

import com.dangdang.ddframe.job.api.AbstractOneOffElasticJob;
import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By Migu.cn
 *
 * @version V1.0
 * @Title: untitled3  .java
 * @Package PACKAGE_NAME
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: lujango
 * @date: 2016年11月16/11/18日 下午11: 22
 * @updater: lujango
 * @updates: TODO
 */
public class oneOffElasticDemoJob extends AbstractOneOffElasticJob {
    @Override
    protected void process(JobExecutionMultipleShardingContext jobExecutionMultipleShardingContext) {

        try{
            System.out.println("elasticjobDemo.oneOffElasticDemoJob:process start");
            TimeUnit.SECONDS.sleep(10);
            System.out.println("elasticjobDemo.oneOffElasticDemoJob:process stop");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
