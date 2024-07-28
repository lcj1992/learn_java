package load_balance;

import load_balance.base.LoadBalancer;
import load_balance.base.Node;

import java.security.SecureRandom;
import java.util.*;


/**
 * 加权轮询算法，轮询指的是对节点的轮询，节点1-节点2-节点3
 * weighted round-robin
 */
public class WeightedRoundRobinLoadBalancer implements LoadBalancer {
    /**
     * 节点
     */
    private final List<Node> nodes;
    /**
     * 权重总和
     */
    private final int totalWeight;
    /**
     * 随机数
     */
    private final Random random;

    public WeightedRoundRobinLoadBalancer(List<Node> nodes) {
        this.nodes = nodes;
        this.totalWeight = nodes.stream().mapToInt(Node::getWeight).sum();
        this.random = new SecureRandom();
    }

    public Node next() {
        int hit = random.nextInt(totalWeight);
        int nodeId = nodes.size() - 1;
        for (Node node : nodes) {
            if (hit < 0) {
                break;
            }
            hit -= node.getWeight();
            nodeId++;
        }
        return nodes.get(nodeId - 1);
    }
}
