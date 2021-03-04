package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.LoadingScreen;
import com.mygdx.game.screens.MenuScreen;
import com.mygdx.game.screens.SettingsScreen;

public class MyGdxGame extends Game {
    public LoadingScreen loadingScreen = new LoadingScreen(this);
    public GameScreen gameScreen = new GameScreen(this);
    public MenuScreen menuScreen = new MenuScreen(this);
    public SettingsScreen settingsScreen = new SettingsScreen(this);

    @Override
    public void create() {
        setScreen(loadingScreen);
    }
}
