package io.drop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class MyGdxSound extends ApplicationAdapter {
    private Sound jumpSound;
    private Music backgroundMusic;

    @Override
    public void create() {
        jumpSound = Gdx.audio.newSound(Gdx.files.internal("drop.mp3"));
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));

        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(.5f);
        backgroundMusic.play();
    }

    @Override
    public void render() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            jumpSound.play();
        }
    }

    @Override
    public void dispose() {
        jumpSound.dispose();
        backgroundMusic.dispose();
    }
}
