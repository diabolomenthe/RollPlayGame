package fr.yahoo.diabolomenthe75005.RollPlayGame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import fr.yahoo.diabolomenthe75005.RollPlayGame.RollPlayGame;

public class ScreenManager {
	private RollPlayGame game = null;
	private Skin skin = null;

	public ScreenManager(RollPlayGame g){
		this.game = g;
		skin = new Skin( Gdx.files.internal( "ui/uiskin.json" ));
		game.setScreen(new MainMenuScreen(this,skin));
	}

	public void setScreen(String menuCall){
		switch (menuCall) {
		case "host": game.setScreen(new HostScreen(this,skin));
		break;
		case "join": game.setScreen(new JoinScreen(this,skin));
		break;
		case "game": game.setScreen(new GameScreen(this,skin));
		break;
		default: game.setScreen(new MainMenuScreen(this,skin));
		}
	}
	
	public final RollPlayGame getGame(){
		return game;
	}

	public void updateScreen(String response) {
		// TODO Auto-generated method stub
		if(game.getScreen() instanceof GameScreen){
			((GameScreen) game.getScreen()).getchatRec().setText(response);
		}
	}
	
}
