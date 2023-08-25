package com.cj.design_pattern.structural_07.adapter.Class.demo;

public class SocketAdapter extends ThreeHolesSocket implements ITwoHolesSocket {
    @Override
    public void twoHolesForCharge() {
        super.threeHolesCharge();
        System.out.println("正在使用双孔插座！");
    }
}
