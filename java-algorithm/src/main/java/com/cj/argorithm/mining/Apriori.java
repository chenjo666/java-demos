package com.cj.argorithm.mining;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
 * Apriori 算法
 *
 * @author chenjian
 * @datetime 2024-02-14 20:37
 */
@Data
public class Apriori<T> {

    /**
     * 最小支持度
     */
    private final double MIN_SUPPORT;
    /**
     * 最小置信度
     */
    private final double MIN_CONFIDENCE;
    /**
     * 关联规则连接符
     */
    private final String RULE_SPLIT = "=>";
    /**
     * 基本项集
     */
    private final List<T> baseItems = new ArrayList<>();
    /**
     * 频繁项集及其支持度
     */
    private final Map<List<T>, Double> freqItemSetsSupport = new HashMap<>();
    /**
     * 频繁项集
     */
    private final List<ItemSet> freqItemSets = new ArrayList<>();
    /**
     * 关联规则
     */
    private final List<AssociationRule> associationRules = new ArrayList<>();

    public Apriori(List<List<T>> dataSet, double minSupport, double minConfidence) {
        this.MIN_SUPPORT = minSupport;
        this.MIN_CONFIDENCE = minConfidence;
        prepare(dataSet);
        calFreqItemSets(dataSet);
        calAssociationRules();
    }

    private void prepare(List<List<T>> dataSet) {
        Set<T> itemSet = new HashSet<>();
        for (List<T> data : dataSet) {
            itemSet.addAll(data);
        }
        this.baseItems.addAll(itemSet);
    }

    /**
     * 计算项集的支持度
     *
     * @param dataSet 数据集
     * @param itemSet 项集
     * @return 支持度
     */
    private double calSupport(List<List<T>> dataSet, List<T> itemSet) {
        // 数据集出现的次数
        int count = 0;
        for (List<T> data : dataSet) {
            if (new HashSet<>(data).containsAll(itemSet)) {
                count++;
            }
        }
        return count * 1.0F / dataSet.size();
    }

    /**
     * 计算频繁项集及其支持度
     *
     * @param dataSet 数据集
     */
    public void calFreqItemSets(List<List<T>> dataSet) {
        for (int i = 0; i < baseItems.size(); i++) {
            calFreqItemSetsHelper(dataSet, i, null);
        }
    }

    private void calFreqItemSetsHelper(List<List<T>> dataSet, int index, List<T> oldItemSet) {
        List<T> newItemSet = new ArrayList<>(CollectionUtils.emptyIfNull(oldItemSet));
        newItemSet.add(baseItems.get(index));
        double support = calSupport(dataSet, newItemSet);
        // 不是频繁项集则进行剪枝
        if (support < MIN_SUPPORT) {
            return;
        }
        // 满足频繁项集则进行递归组装新项集
        // 1. 存储【频繁项集 & 支持度】
        freqItemSets.add(new ItemSet(newItemSet, support));
        freqItemSetsSupport.put(newItemSet, support);
        // 2. 递归组成新项集继续进行尝试
        for (int i = index + 1; i < baseItems.size(); i++) {
            calFreqItemSetsHelper(dataSet, i, newItemSet);
        }
    }


    public void calAssociationRules() {
        this.freqItemSets.forEach(itemSet -> {
            List<T> freqItemSet = itemSet.getItemSet();
            if (freqItemSet.size() > 1) {
                List<T> leftItemSet = new ArrayList<>(freqItemSet.subList(0, 1));
                List<T> rightItemSet = new ArrayList<>(freqItemSet.subList(1, freqItemSet.size()));
                calAssociationRulesHelper(freqItemSet, 1, leftItemSet, rightItemSet);
            }
        });
    }

    private void calAssociationRulesHelper(List<T> freqItemSet, int index, List<T> leftItemSet, List<T> rightItemSet) {
        // 计算置信度
        List<T> newLeftItemSet = new ArrayList<>(leftItemSet);
        List<T> newRightItemSet = new ArrayList<>(rightItemSet);
        double confidence = calConfidence(freqItemSet, newRightItemSet);
        if (confidence >= MIN_CONFIDENCE) {
            associationRules.add(new AssociationRule(newLeftItemSet, newRightItemSet, confidence));
        }
        confidence = calConfidence(freqItemSet, newLeftItemSet);
        if (confidence >= MIN_CONFIDENCE) {
            associationRules.add(new AssociationRule(newRightItemSet, newLeftItemSet, confidence));
        }
        for (int i = index; i < freqItemSet.size() - 1; i++) {
            leftItemSet.add(freqItemSet.get(i));
            rightItemSet.remove(freqItemSet.get(i));
            calAssociationRulesHelper(freqItemSet, index + 1, leftItemSet, rightItemSet);
            leftItemSet.remove(freqItemSet.get(i));
            rightItemSet.add(freqItemSet.get(i));
        }
    }

    /**
     * 计算置信度
     *
     * @param freqItemSet 频繁项集
     * @param resItemSet  结果项集
     * @return 置信度
     */
    private double calConfidence(List<T> freqItemSet, List<T> resItemSet) {
        return freqItemSetsSupport.get(freqItemSet) / freqItemSetsSupport.get(resItemSet);
    }

    /**
     * 项集
     */
    @Data
    @AllArgsConstructor
    public class ItemSet {
        /**
         * 项集
         */
        private List<T> itemSet;
        /**
         * 支持度
         */
        private double support;

        @Override
        public String toString() {
            return itemSet + ", support=" + String.format("%.2f", support);
        }
    }

    /**
     * 关联规则
     */
    @Data
    @AllArgsConstructor
    public class AssociationRule {
        /**
         * 前置项集
         */
        private List<T> preItemSet;
        /**
         * 后置项集
         */
        private List<T> resItemSet;
        /**
         * 置信度
         */
        private double confidence;

        @Override
        public String toString() {
            return preItemSet + RULE_SPLIT + resItemSet +
                    ", confidence=" + String.format("%.2f", confidence);
        }
    }


    public static void main(String[] args) {
        List<List<String>> dataSetList = new ArrayList<>();
        dataSetList.add(Arrays.asList("苹果", "香蕉", "梨子", "草莓", "西红柿"));
        dataSetList.add(Arrays.asList("苹果", "香蕉", "梨子", "草莓", "菠萝"));
        dataSetList.add(Arrays.asList("香蕉", "梨子", "草莓", "菠萝"));
        dataSetList.add(Arrays.asList("苹果", "香蕉", "菠萝", "梨子"));
        dataSetList.add(Arrays.asList("苹果", "香蕉"));

        Apriori<String> apriori = new Apriori<>(dataSetList, 0.6, 0.8);
        System.out.println("=======频繁项集=======");
        apriori.getFreqItemSets().forEach(System.out::println);
        System.out.println("=======频繁项集=======");
        System.out.println();
        System.out.println("=======关联规则=======");
        apriori.getAssociationRules().forEach(System.out::println);
        System.out.println("=======关联规则=======");
    }
}
