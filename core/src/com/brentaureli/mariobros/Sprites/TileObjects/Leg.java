package com.brentaureli.mariobros.Sprites.TileObjects;

import com.badlogic.gdx.maps.MapObject;
import com.brentaureli.mariobros.Screens.PlayScreen;
import com.brentaureli.mariobros.Sprites.Mario;

/**
 * Created by a.lam.tuan on 16. 9. 2016.
 */
public class Leg extends InteractiveTileObject {

    public Leg(PlayScreen screen, MapObject object) {
        super(screen, object);
    }

    @Override
    public void onHeadHit(Mario mario) {

    }
}
