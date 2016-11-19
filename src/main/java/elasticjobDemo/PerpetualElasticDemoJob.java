package elasticjobDemo;

import com.dangdang.ddframe.job.api.AbstractPerpetualElasticJob;
import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By Migu.cn
 *
 * @version V1.0
 * @Title: untitled3  .java
 * @Package PACKAGE_NAME
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: lujango
 * @date: 2016年11月16/11/18日 下午11: 45
 * @updater: lujango
 * @updates: TODO
 */
public class PerpetualElasticDemoJob extends AbstractPerpetualElasticJob<List<Integer>> {
    @Override
    protected List fetchData(JobExecutionMultipleShardingContext jobExecutionMultipleShardingContext) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<10;i++){
            list.add(i);
        }
        return list;
    }

    @Override
    protected boolean processData(JobExecutionMultipleShardingContext jobExecutionMultipleShardingContext, List<Integer> integers) {
        System.out.println("elasticjobDemo.PerpetualElasticDemoJob:processData: "+integers.size());
        return true;
    }
}
