package com.brentaureli.mariobros.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.brentaureli.mariobros.MarioBros;
import com.brentaureli.mariobros.Screens.PlayScreen;
import com.brentaureli.mariobros.Sprites.Other.FireBall;

/**
 * Created by a.lam.tuan on 16. 9. 2016.
 */
public class Ball extends Sprite {

    public World world;
    public Body b2body;
    private PlayScreen screen;
    private Texture texture;
    public Ball(PlayScreen screen)
    {
        this.world = screen.getWorld();
        this.screen = screen;
        texture = new Texture(Gdx.files.internal("ball/03.png"));
        defineBall();
        setBounds(0, 0, 70 / MarioBros.PPM, 70 / MarioBros.PPM);
        setRegion(texture);

    }
    public void update(float dt){
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
        setOriginCenter();
        setRotation(b2body.getAngle()*180/3.14f);
     /*   if(Gdx.input.isTouched())
        {
            Vector2 touchPoint = new Vector2(Gdx.input.getX(),Gdx.input.getY());
            b2body.applyLinearImpulse(new Vector2(MarioBros.V_WIDTH/2,0), touchPoint, true);
        }*/
    }
    private void defineBall()
    {
        BodyDef bdef = new BodyDef();
        bdef.position.set(128 / MarioBros.PPM, MarioBros.V_HEIGHT / MarioBros.PPM);
        //    bdef.position.set(MarioBros.V_WIDTH/2,MarioBros.V_HEIGHT/2);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(32 / MarioBros.PPM);
        fdef.friction = 0.7f;
        fdef.restitution = 0.8f;
        fdef.density = 3;
        fdef.filter.categoryBits = MarioBros.BALL_BIT;
        fdef.filter.maskBits = MarioBros.MARIO_BIT|
                MarioBros.GROUND_BIT |
                MarioBros.OBJECT_BIT ;


        fdef.shape = shape;
        fdef.friction = 0.1f;
        fdef.restitution = 0.9f;

        b2body.createFixture(fdef).setUserData(this);
    }
    public void draw(Batch batch){
        super.draw(batch);
    }
}
