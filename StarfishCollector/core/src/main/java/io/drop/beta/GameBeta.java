package io.drop.beta;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class GameBeta extends Game {
    protected Stage mainStage;

    @Override
    public void create() {
        mainStage = new Stage();
        initialize();
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        mainStage.act(dt);

        update(dt);

        // Clear the screen
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainStage.draw();
    }

    // create method remains the same
    public abstract void initialize();
    // render method remains the same
    public abstract void update(float dt);
}
