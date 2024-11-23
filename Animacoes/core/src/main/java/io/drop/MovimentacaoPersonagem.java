package io.drop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MovimentacaoPersonagem extends ApplicationAdapter {
    private Texture sheetIdle, sheetWalk;
    private TextureRegion[] framesIdle, framesWalk;
    private Animation<TextureRegion> animationIdle, animationWalk;
    private float stateTime;
    private SpriteBatch batch;

    private float positionX = 50f;
    private boolean isFacingRight = true;

    private enum State {
        IDLE, WALKING
    }

    private State currentState = State.IDLE;
    private State previousState = State.IDLE;

    @Override
    public void create() {
        batch = new SpriteBatch();

        // Idle Animation
        sheetIdle = new Texture(Gdx.files.internal("idle.png"));
        TextureRegion[][] tmp = TextureRegion.split(sheetIdle, 100, 100);
        framesIdle = new TextureRegion[6];
        for (int i = 0; i < 6; i++) {
            framesIdle[i] = tmp[0][i];
        }
        animationIdle = new Animation<>(0.1f, framesIdle);

        // Walk Animation
        sheetWalk = new Texture(Gdx.files.internal("walk.png"));
        tmp = TextureRegion.split(sheetWalk, 100, 100);
        framesWalk = new TextureRegion[8];
        for (int i = 0; i < 8; i++) {
            framesWalk[i] = tmp[0][i];
        }
        animationWalk = new Animation<>(0.1f, framesWalk);

        stateTime = 0f;
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            currentState = State.WALKING;
            if (positionX + 256f < Gdx.graphics.getWidth()) {
                positionX += 4f;
            }
            if (!isFacingRight) {
                for (TextureRegion frame: framesWalk) {
                    frame.flip(true, false);
                }
                isFacingRight = true;
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            currentState = State.WALKING;
            if (positionX > 0) {
                positionX -= 4f;
            }
            if (isFacingRight) {
                for (TextureRegion frame: framesWalk) {
                    frame.flip(true, false);
                }
                isFacingRight = false;
            }
        } else {
            currentState = State.IDLE;
        }

        if (currentState != previousState) {
            stateTime = 0f;
            previousState = currentState;
        }

        TextureRegion currentFrame;
        if (currentState == State.WALKING) {
            currentFrame = animationWalk.getKeyFrame(stateTime, true);
        } else {
            currentFrame = animationIdle.getKeyFrame(stateTime, true);
        }

        float characterWidth = 256f, characterHeight = 256f;
        if (positionX + characterWidth  > Gdx.graphics.getWidth()) {
            positionX = Gdx.graphics.getWidth() - characterWidth;
        }
        if (positionX < 0) {
            positionX = 0;
        }
        System.out.println(positionX +" " + Gdx.graphics.getWidth());

        batch.begin();
        batch.draw(currentFrame, positionX, 50f, characterWidth, characterHeight);
        batch.end();
    }

    @Override
    public void dispose() {
        sheetIdle.dispose();
        batch.dispose();
    }
}
