package com.mycompany.laba5.fabrics;

import com.mycompany.laba5.enemy.Baraka;
import com.mycompany.laba5.player.Player;





public class BarakaFabric implements EnemyFabricInterface {

    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new Baraka(1, 100, 12, 1);
        return enemy;
    }
}
