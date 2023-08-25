package com.cj.design_pattern.behavioral_11.Observer.demo1;

import java.util.ArrayList;
import java.util.List;

// 天气主题
interface Weather {
    void addUnit(Unit unit);
    void removeUnit(Unit unit);
    void notifyUnit(String message);
}
class WeatherStation implements Weather {
    List<Unit> units = new ArrayList<>();
    @Override
    public void addUnit(Unit unit) {
        units.add(unit);
    }

    @Override
    public void removeUnit(Unit unit) {
        units.remove(unit);
    }

    @Override
    public void notifyUnit(String message) {
        for (Unit unit : units) {
            unit.updateWeather(message);
        }
    }
}

interface Unit {
    void updateWeather(String message);
}
// 政府单位
class GovernmentUnit implements Unit {
    @Override
    public void updateWeather(String message) {
        System.out.println("政府部门接收到一条天气消息：" + message);
    }
}
// 航空部门
class AviationUnit implements Unit {
    @Override
    public void updateWeather(String message) {
        System.out.println("航空部门接收到一条天气消息：" + message);
    }
}

public class Test {
    public static void main(String[] args) {
        Weather weatherStation = new WeatherStation();
        Unit governmentUnit = new GovernmentUnit();
        Unit aviationUnit = new AviationUnit();
        // 天气预报机构添加相关部门
        weatherStation.addUnit(governmentUnit);
        weatherStation.addUnit(aviationUnit);
        // 天气预报机构通知相关部门
        weatherStation.notifyUnit("明天即将电闪雷鸣，请各位做好防护安全！");
    }
}
//政府部门接收到一条天气消息：明天即将电闪雷鸣，请各位做好防护安全！
//航空部门接收到一条天气消息：明天即将电闪雷鸣，请各位做好防护安全！