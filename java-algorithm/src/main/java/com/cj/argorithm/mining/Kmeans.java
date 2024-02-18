package com.cj.argorithm.mining;

import lombok.Data;

import java.util.*;

/**
 * 平方误差和（Sum of Square Errors，SSE）
 *
 * @author chenjian
 * @datetime 2024-02-17 18:28
 */
public class Kmeans<T extends Number> {

    private final double MAX_DISTANCE;
    private final int k;
    private final Set<Cluster> clusters;
    private int count;
    private double sumOfSquaredErrors;

    public Kmeans(List<List<T>> dataList, int k, double maxDistance) {
        this.k = k;
        this.MAX_DISTANCE = maxDistance;
        List<Point> points = initPoints(dataList);
        this.clusters = randomCenterCluster(k, points);
        do {
            reChooseCenterCluster(this.clusters, points);
            count++;
        } while (reCalculateCenterCluster(this.clusters));
        this.sumOfSquaredErrors = calSumOfSquaredErrors(this.clusters);
    }

    public Set<Cluster> getClusters() {
        return this.clusters;
    }

    public int getCount() {
        return this.count;
    }

    public int getK() {
        return this.k;
    }

    public double getSumOfSquaredErrors() {
        return this.sumOfSquaredErrors;
    }

    /**
     * 初始化数据点集
     *
     * @param data 数据
     * @return 点集合
     */
    public List<Point> initPoints(List<List<T>> data) {
        List<Point> points = new ArrayList<>(data.size());
        for (int i = 0; i < data.size(); i++) {
            String id = String.format("%02d", i);
            points.add(new Point(id, data.get(i)));
        }
        return points;
    }

    /**
     * 计算 sse
     *
     * @return
     */
    public double calSumOfSquaredErrors(Set<Cluster> clusters) {
        double sse = 0.0F;
        for (Cluster cluster : clusters) {
            double s = 0.0F;
            for (Point point : cluster.getPoints()) {
                s += calSquaredErrors(point, cluster.getCenterPoint());
            }
            sse += s;
        }
        return sse;
    }

    /**
     * 计算误差平方
     *
     * @param p1 点1
     * @param p2 点2
     * @return 误差平方，SE
     */
    public double calSquaredErrors(Point p1, Point p2) {
        if (p1.getData().size() != p2.getData().size()) {
            throw new IllegalArgumentException("参数维度不一致");
        }
        double square = 0.0F;
        for (int i = 0; i < p1.getData().size(); i++) {
            square += Math.pow(p1.getData().get(i).doubleValue() - p2.getData().get(i).doubleValue(), 2);
        }
        return square;
    }

    /**
     * 随机选择 k 个聚簇中心
     *
     * @param k 数值 k
     * @return 聚簇中心集合
     */
    public Set<Cluster> randomCenterCluster(int k, List<Point> points) {
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
        centerPoints.forEach((key, value) -> clusters.add(new Cluster(value)));

        return clusters;
    }

    /**
     * 计算聚簇中心的点集合平均值到聚簇中心点的距离是否大于阈值
     *
     * @param clusters 聚簇集合
     * @return 是否需要再次计算
     */
    public boolean reCalculateCenterCluster(Set<Cluster> clusters) {
        boolean ans = false;
        for (Cluster cluster : clusters) {
            List<Point> pointList = cluster.getPoints();

            // 计算平均值
            List<Double> avgData = new ArrayList<>(pointList.get(0).getData().size());
            // 初始化avgData列表，添加与pointList数据长度相同的元素，初始值设为0
            for (int i = 0; i < pointList.get(0).getData().size(); i++) {
                avgData.add(0.0);
            }
            for (Point point : pointList) {
                for (int i = 0; i < point.getData().size(); i++) {
                    avgData.set(i, avgData.get(i) + point.getData().get(i).doubleValue());
                }
            }
            avgData.replaceAll(aDouble -> aDouble / pointList.size());

            // 计算新聚簇点和旧聚簇点之间的距离
            Point newPoint = new Point((List<T>) avgData);
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
    public double getDistance(Point p1, Point p2) {
        int length = p1.getData().size();

        double distance = 0;
        for (int i = 0; i < length; i++) {
            distance += Math.pow(p1.getData().get(i).doubleValue() - p2.getData().get(i).doubleValue(), 2);
        }
        return Math.sqrt(distance);
    }

    /**
     * 重新选择聚簇中心
     *
     * @param clusters 聚簇集合
     * @param points   点集合
     */
    public void reChooseCenterCluster(Set<Cluster> clusters, List<Point> points) {
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


    @Data
    public class Point {

        private List<T> data;
        /**
         * 标识
         */
        private String id;
        /**
         * 距离聚簇中心点的距离
         */
        private double distance;

        public Point(List<T> data) {
            this.data = data;
        }

        public Point(String id, List<T> data) {
            this.id = id;
            this.data = data;
        }
    }

    @Data
    public class Cluster {
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
            points.forEach(point -> ans.append("\n").append(point));
            return ans.toString();
        }
    }


    public static List<double[]> data2 = new ArrayList<>(Arrays.asList(
            new double[]{1, 2, 3}, new double[]{3, 3, 3},
            new double[]{3, 4, 4}, new double[]{5, 6, 5}, new double[]{8, 9, 6}, new double[]{4, 5, 4}, new double[]{6, 4, 2},
            new double[]{3, 9, 7}, new double[]{5, 9, 8}, new double[]{4, 2, 10}, new double[]{1, 9, 12}, new double[]{7, 8, 4},
            new double[]{7, 8, 112}));

    public static void main(String[] args) {
        List<List<Double>> data = new ArrayList<>();
        data.add(Arrays.asList(1.0, 2.0, 3.0));
        data.add(Arrays.asList(2.0, 2.1, 3.2));
        data.add(Arrays.asList(3.0, 3.1, 4.2));
        data.add(Arrays.asList(100.0, 100.0, 100.0));
        data.add(Arrays.asList(98.0, 100.0, 92.0));
        data.add(Arrays.asList(1000.0, 1000.1, 1000.2));
        Kmeans<Double> kmeans = new Kmeans<>(data, 3, 0.0001);
        System.out.println("##############聚类结果##############");
        kmeans.getClusters().forEach(System.out::println);
        System.out.println("聚类个数: " + kmeans.getK() + ", 迭代次数: " + kmeans.getCount() + ", SSE: " + kmeans.getSumOfSquaredErrors());
        System.out.println("##############聚类结果##############");
    }


}
