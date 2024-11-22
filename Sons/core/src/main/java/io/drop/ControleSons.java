package io.drop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ControleSons extends ApplicationAdapter {
    private Sound jump;
    private Music background;
    private float volume = 1f;

    private ShapeRenderer shapeRenderer;
    private float barX = 50f;
    private float barY = 50f;
    private float barWidth = 200f;
    private float barHeight = 20f;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        jump = Gdx.audio.newSound(Gdx.files.internal("jump.mp3"));
        background = Gdx.audio.newMusic(Gdx.files.internal("background.ogg"));
    }

    @Override
    public void render() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            jump.play();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            if (background.isPlaying()) {
                background.pause();
            } else {
                background.setLooping(true);
                background.setVolume(volume);
                background.play();
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            background.stop();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            volume += 0.05f;
            if (volume >= 1f) {
                volume = 1f;
            }
            background.setVolume(volume);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            volume -= 0.05f;
            if (volume <= 0f) {
                volume = 0f;
            }
            background.setVolume(volume);
        }

        drawBar();
    }

    private void drawBar() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(.5f,.5f,.5f, 1f);
        shapeRenderer.rect(barX, barY, barWidth, barHeight);

        shapeRenderer.setColor(0f, 1f, 0f, 1f);
        shapeRenderer.rect(barX, barY, barWidth * volume, barHeight);

        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        jump.dispose();
        background.dispose();
        shapeRenderer.dispose();
    }
}
