//package com.pw.elastic.job;
//
//import org.apache.shardingsphere.elasticjob.api.ShardingContext;
//import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
//
///**
// * @author pengwei
// * @date 2021/3/28
// */
////@ElasticJobScheduler(
////        name = "AnnotationSimpleJob", // 定时器名称
////        cron = "0/8 * * * * ?", // 定时器表达式
////        shardingTotalCount = 1, // 作业分片总数 默认为1
////        shardingItemParameters = "0=Beijing,1=Shanghai,2=Guangzhou",  // 分片序列号和参数用等号分隔 不需要参数可以不加
////        jobParameters = "123", // 作业自定义参数 不需要参数可以不加
////        isEvent = true // 是否开启数据记录 默认为true
////)
//public class MyJob implements SimpleJob {
//
//    @Override
//    public void execute(ShardingContext context) {
//        switch (context.getShardingItem()) {
//            case 0:
//                System.out.println("sharding-0");
//                break;
//            case 1:
//                // do something by sharding item 1
//                System.out.println("sharding -1");
//                break;
//            case 2:
//                // do something by sharding item 2
//                System.out.println("sharding-2");
//                break;
//            // case n: ...
//        }
//    }
//}
