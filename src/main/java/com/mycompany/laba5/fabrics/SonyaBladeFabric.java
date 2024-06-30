package com.mycompany.laba5.fabrics;

import com.mycompany.laba5.enemy.SonyaBlade;
import com.mycompany.laba5.player.Player;






public class SonyaBladeFabric implements EnemyFabricInterface {

    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new SonyaBlade(1, 80, 16, 1);
        return enemy;
    }

}
