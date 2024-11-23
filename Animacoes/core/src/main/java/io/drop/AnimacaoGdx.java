package io.drop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimacaoGdx extends ApplicationAdapter {
    private Texture sheet;
    private TextureRegion[] frames;
    private Animation<TextureRegion> animation;
    private float stateTime;
    private SpriteBatch batch;

    @Override
    public void create() {
        sheet = new Texture(Gdx.files.internal("idle.png"));

        TextureRegion[][] tmp = TextureRegion.split(sheet, 100, 100);
        frames = new TextureRegion[6];
        for (int i = 0; i < 6; i++) {
            frames[i] = tmp[0][i];
        }

        animation = new Animation<>(0.1f, frames);
        stateTime = 0f;

        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        stateTime += Gdx.graphics.getDeltaTime();

        TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(currentFrame, 50f, 50f, 256f, 256f);
        batch.end();
    }

    @Override
    public void dispose() {
        sheet.dispose();
        batch.dispose();
    }
}
