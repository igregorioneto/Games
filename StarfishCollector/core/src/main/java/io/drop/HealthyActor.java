package io.drop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class HealthyActor extends Actor {
    private int HP;
    private Texture healthyImage;
    private Texture damagedImage;
    private Texture deceasedImage;

    public HealthyActor() { super(); }

    public void draw(Batch b) {
        if (HP > 50)
            b.draw(healthyImage, getX(), getY());
        else if (HP > 0 && HP < 50)
            b.draw(damagedImage, getX(), getY());
        else
            b.draw(deceasedImage, getX(), getY());
    }
}
