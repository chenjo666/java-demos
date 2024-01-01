package com.cj;


import lombok.Data;

import java.util.*;

public class KmeansDemo {

    private static final double MAX_DISTANCE = 0.0001;

    public static List<double[]> data1 = new ArrayList<>(Arrays.asList(new double[]{1, 2, 3}, new double[]{2, 2, 3},
            new double[]{3, 3, 4},

            new double[]{100, 100, 100}, new double[]{98, 100, 92},

            new double[]{1000, 1000, 1000}));

    public static List<double[]> data2 = new ArrayList<>(Arrays.asList(new double[]{1, 2, 3}, new double[]{3, 3, 3},
            new double[]{3, 4, 4}, new double[]{5, 6, 5}, new double[]{8, 9, 6}, new double[]{4, 5, 4}, new double[]{6, 4, 2},
            new double[]{3, 9, 7}, new double[]{5, 9, 8}, new double[]{4, 2, 10}, new double[]{1, 9, 12}, new double[]{7, 8, 4},
            new double[]{7, 8, 112}));


    public static void main(String[] args) {
        kMeans(3, data2);
        kMeans(3, data1);
    }

    /**
     * 初始化数据点集
     *
     * @param data 数据
     * @return 点集合
     */
    public static List<Point> initPoints(List<double[]> data) {
        List<Point> points = new ArrayList<>(data.size());
        for (int i = 0; i < data.size(); i++) {
            String id = String.format("%02d", i);
            points.add(new Point(id, data.get(i)));
        }
        return points;
    }


    /**
     * 随机选择 k 个聚簇中心
     *
     * @param k 数值 k
     * @return 聚簇中心集合
     */
    public static Set<Cluster> randomCenterCluster(int k, List<Point> points) {
        Random random = new Random();
        Map<String, Point> centerPoints = new HashMap<>();

        while (centerPoints.size() < k) {
            int index = random.nextInt(points.size());
            String randomId = points.get(index).getId();
            if (!centerPoints.containsKey(randomId)) {
                centerPoints.put(randomId, points.get(index));
            }
        }

        Set<Cluster> clusters = new HashSet<>();
        for (Map.Entry<String, Point> entry : centerPoints.entrySet()) {
            clusters.add(new Cluster(entry.getValue()));
        }

        return clusters;
    }

    /**
     * 计算聚簇中心的点集合平均值到聚簇中心点的距离是否大于阈值
     *
     * @param clusters 聚簇集合
     * @return 是否需要再次计算
     */
    public static boolean reCalculateCenterCluster(Set<Cluster> clusters) {
        boolean ans = false;
        for (Cluster cluster : clusters) {
            List<Point> pointList = cluster.getPoints();

            // 计算平均值
            double[] avgData = new double[pointList.get(0).getData().length];
            for (Point point : pointList) {
                for (int i = 0; i < point.getData().length; i++) {
                    avgData[i] += point.getData()[i];
                }
            }
            for (int i = 0; i < avgData.length; i++) {
                avgData[i] = avgData[i] / pointList.size();
            }

            // 计算新聚簇点和旧聚簇点之间的距离
            Point newPoint = new Point(avgData);
            if (getDistance(newPoint, cluster.getCenterPoint()) > MAX_DISTANCE) {
                ans = true;
            }

            // 设置新点
            cluster.setCenterPoint(newPoint);
        }
        return ans;
    }


    /**
     * 计算两个点的距离
     *
     * @param p1 点1
     * @param p2 点2
     * @return 距离
     */
    public static double getDistance(Point p1, Point p2) {
        int length = p1.getData().length;

        double distance = 0;
        for (int i = 0; i < length; i++) {
            distance += Math.pow(p1.getData()[i] - p2.getData()[i], 2);
        }
        return Math.sqrt(distance);
    }

    /**
     * k-means算法启动
     *
     * @param k    k类
     * @param data 数据集
     */
    public static void kMeans(int k, List<double[]> data) {
        int count = 0;
        List<Point> points = initPoints(data);
        Set<Cluster> clusters = randomCenterCluster(k, points);
        do {
            reChooseCenterCluster(clusters, points);
            count++;
        } while (reCalculateCenterCluster(clusters));

        System.out.println("迭代次数: " + count);
        for (Cluster cluster : clusters) {
            System.out.println(cluster);
        }
    }

    /**
     * 重新选择聚簇中心
     *
     * @param clusters 聚簇集合
     * @param points   点集合
     */
    public static void reChooseCenterCluster(Set<Cluster> clusters, List<Point> points) {
        // 清除聚簇原有点集合，换新
        for (Cluster cluster : clusters) {
            cluster.setPoints(new ArrayList<>());
        }

        // 计算每个点到聚簇的距离，并进入最近一个聚簇中
        for (Point point : points) {
            double dis = Double.MAX_VALUE;
            Cluster minCluster = null;
            for (Cluster cluster : clusters) {
                double tempDis = getDistance(point, cluster.getCenterPoint());
                if (tempDis < dis) {
                    dis = tempDis;
                    minCluster = cluster;
                    point.setDistance(dis);
                }
            }
            if (minCluster != null) {
                minCluster.getPoints().add(point);
            }
        }
    }

}

/**
 * 点
 */
@Data
class Point {
    /**
     * 数据
     */
    private double[] data;
    /**
     * 标识
     */
    private String id;

    /**
     * 距离聚簇中心点的距离
     */
    private double distance;

    public Point(double[] data) {
        this.data = data;
    }

    public Point(String id, double[] data) {
        this.id = id;
        this.data = data;
    }
}

/**
 * 聚簇
 */
@Data
class Cluster {
    /**
     * 聚簇中心
     */
    private Point centerPoint;
    /**
     * 成员列表
     */
    private List<Point> points;

    public Cluster(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder("Cluster{" + "centerPoint=" + centerPoint + "}");
        for (Point point : points) {
            ans.append("\n").append(point);
        }
        return ans.toString();
    }
}
