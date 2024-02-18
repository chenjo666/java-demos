package com.cj.tests.mining;

import com.cj.argorithm.mining.Kmeans;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenjian
 * @datetime 2024-02-17 19:11
 */
public class KmeansTest {

    @Test
    void test() {
        List<List<Double>> data = new ArrayList<>();
        data.add(Arrays.asList(1.0, 2.0, 3.0));
        data.add(Arrays.asList(1.0, 2.0, 3.0));
        data.add(Arrays.asList(1.0, 2.0, 3.0));
        data.add(Arrays.asList(100.0, 100.0, 100.0));
        data.add(Arrays.asList(98.0, 100.0, 92.0));
        data.add(Arrays.asList(1000.0, 1000.1, 1000.2));
        Kmeans<Double> kmeans = new Kmeans<>(data, 3, 0.0001);
        System.out.println("##############聚类结果##############");
        kmeans.getClusters().forEach(System.out::println);
        System.out.println("聚类个数: " + kmeans.getK() + ", 迭代次数: " + kmeans.getCount());
        System.out.println("##############聚类结果##############");
    }
}
