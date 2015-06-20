package fr.yahoo.diabolomenthe75005.RollPlayGame;

import com.badlogic.gdx.Game;

import fr.yahoo.diabolomenthe75005.RollPlayGame.Database.DatabaseManager;
import fr.yahoo.diabolomenthe75005.RollPlayGame.Network.NetworkManager;
import fr.yahoo.diabolomenthe75005.RollPlayGame.Screen.ScreenManager;

public class RollPlayGame extends Game {
	private ScreenManager screenManager = null;
	private NetworkManager networkManager = null;
	private DatabaseManager databaseManager = null;
	public boolean connected = false;
	
	@Override
	public void create () {
		//Lance le screen manager
		screenManager = new ScreenManager(this);
		networkManager = new NetworkManager(this);
		databaseManager = new DatabaseManager();
		new Thread(networkManager).start();
		

		
	}

	@Override
	public void render () {
		super.render();


	}


	public final ScreenManager getScreenManager() {
		return screenManager;
	}

	public NetworkManager getNetworkManager() {
		return networkManager;
	}




	

}
