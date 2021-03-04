package com.mygdx.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.mygdx.game.MyGdxGame;

public abstract class BasicScreen extends ScreenAdapter {
    private final MyGdxGame game;

    public BasicScreen(MyGdxGame game) {
        this.game = game;
    }

    public void changeScreen(Screens screenId) {
        Screen screen;
        switch (screenId) {
            case LOADING:
                screen = game.loadingScreen;
                break;
            case GAME:
                screen = game.gameScreen;
                break;
            case MENU:
                screen = game.menuScreen;
                break;
            case SETTINGS:
                screen = game.settingsScreen;
                break;
            default:
                throw new IllegalArgumentException("screen id must be set.");
        }
        game.setScreen(screen);
    }
}
