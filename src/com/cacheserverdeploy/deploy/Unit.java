package com.cacheserverdeploy.deploy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.filetool.main.Main;

public class Unit {

	int cost;
	int size; // 需要随机的服务器个数
	int range; // 随机范围，即网络节点数
	List<Integer> server_location = new ArrayList<>();

	public Unit() {
		size = Main.NUM_CONSUMER - 1;
		range = Main.NUM_NET;
		initLocation();
		while (!checkValid()) {
			initLocation();
		}
		calculateCost();
	}

	public void initLocation() {
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			int tmp = random.nextInt(range);
			while (server_location.contains(tmp)) {
				tmp = random.nextInt(range);
			}
			server_location.add(tmp);
		}
	}

	public boolean checkValid() {
		return true;
	}

	public void calculateCost() {
		for (int location : server_location) {
			cost += location;
		}
	}

	public void printUnit(int n) {
		System.out.println(n);
		for (int location : server_location) {
			System.out.print(location + " ");
		}
		System.out.println();
	}

}
