package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;

public class MenuScreen extends BasicScreen {
    private Stage stage;

    public MenuScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Table table = new Table();
        table.setFillParent(true);
//        table.setDebug(true, true);

        Skin skin = new Skin(Gdx.files.internal("glassy/skin/glassy-ui.json"));
        TextButton newGameButton = new TextButton("New Game", skin);
        TextButton settingsButton = new TextButton("Settings", skin, "small");
        TextButton exitButton = new TextButton("Exit", skin);

        List<String> strings = new List<>(skin, "plain");
        strings.setItems("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "END");

        table.add(newGameButton).fillX();
        table.row().pad(10, 0, 10, 0);
        table.add(settingsButton);
        table.row().pad(10, 0, 10, 0);
        table.add(exitButton).fillX();
        table.row().pad(10, 0, 10, 0);
//        table.add(strings);
//        table.row().pad(10, 0, 10, 0);

        stage.addActor(table);

        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        addScrollable(table, skin);
    }

    private void addScrollable(Table container, Skin skin) {
        Table table = new Table();
        ScrollPane scrollPane = new ScrollPane(table, skin);
        scrollPane.setScrollingDisabled(true, false);

        table.pad(10).defaults().expandX().space(4);
        for (int i = 0; i < 100; i++) {
            table.row();
            Label label = new Label(i + "Process 'command '/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/bin/java'' finished with non-zero exit value 255", skin);
            label.setAlignment(Align.center);
            label.setWrap(true);
            table.add(label).width(Gdx.graphics.getWidth());
        }
        container.add(scrollPane).expand().fill();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }
}
