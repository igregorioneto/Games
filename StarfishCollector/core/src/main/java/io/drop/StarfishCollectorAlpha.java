package io.drop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class StarfishCollectorAlpha extends Game {
    private SpriteBatch batch;

    private Texture turtleTexture;
    private float turtleX;
    private float turtleY;
    private Rectangle turtleRectangle;

    private Texture starfishTexture;
    private float starfishX;
    private float starfishY;
    private Rectangle starfishRectangle;

    private Texture oceanTexture;
    private Texture winMessageTexture;

    private boolean win;

    @Override
    public void create() {
        batch = new SpriteBatch();

        // Turtle
        turtleTexture = new Texture(Gdx.files.internal("turtle-1.png"));
        turtleX = 20;
        turtleY = 20;
        turtleRectangle = new Rectangle(
            turtleX,
            turtleY,
            turtleTexture.getWidth(),
            turtleTexture.getHeight()
        );

        // Starfish
        starfishTexture = new Texture(Gdx.files.internal("starfish.png"));
        starfishX = 380;
        starfishY = 380;
        starfishRectangle = new Rectangle(
            starfishX,
            starfishY,
            starfishTexture.getWidth(),
            starfishTexture.getHeight()
        );

        oceanTexture = new Texture(Gdx.files.internal("water.jpg"));
        winMessageTexture = new Texture(Gdx.files.internal("you-win.png"));

        win = false;
    }

    @Override
    public void render() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            turtleX--;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            turtleX++;
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            turtleY++;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            turtleY--;

        // Update turtle rectangle location
        turtleRectangle.setPosition(turtleX, turtleY);

        // check win condition: turtle must be overlapping starfish
        if (turtleRectangle.overlaps(starfishRectangle))
            win = true;

        // clean screen
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // draw graphics
        batch.begin();
        batch.draw(oceanTexture, 0, 0);
        if (!win)
            batch.draw(starfishTexture, starfishX, starfishY);
        batch.draw(turtleTexture, turtleX, turtleY);
        if (win)
            batch.draw(winMessageTexture, 180, 180);
        batch.end();
    }
}
