package concurrent.threadMessage.produer_consumer_model.definition;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/30
 * Time: 下午11:16
 */
public interface Model {
    Runnable newProducer();

    Runnable newConsumer();
}