package com.cj.design_pattern.Adapter.Object.demo;

public class SocketAdapter implements ITwoHolesSocket {
    private ThreeHolesSocket threeHolesSocket;
    public SocketAdapter() {
        this.threeHolesSocket = new ThreeHolesSocket();
    }

    @Override
    public void twoHolesCharge() {
        this.threeHolesSocket.threeHolesCharge();
        System.out.println("正在使用双孔插座！");
    }
}
