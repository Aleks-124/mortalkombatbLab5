package com.mycompany.laba5.fabrics;

import com.mycompany.laba5.enemy.LiuKang;
import com.mycompany.laba5.player.Player;






public class LiuKangFabric implements EnemyFabricInterface {

    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new LiuKang(1, 70, 20, 1);
        return enemy;
    }
}
