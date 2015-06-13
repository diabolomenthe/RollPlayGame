package fr.yahoo.diabolomenthe75005.RollPlayGame;

import com.badlogic.gdx.Game;
import com.esotericsoftware.kryonet.Client;
import fr.yahoo.diabolomenthe75005.RollPlayGame.Network.NetworkManager;
import fr.yahoo.diabolomenthe75005.RollPlayGame.Screen.ScreenManager;

public class RollPlayGame extends Game {
	ScreenManager screenManager = null;
	NetworkManager networkManager = null;
	Client client = null;
	
	@Override
	public void create () {
		//Lance le screen manager
		screenManager = new ScreenManager(this);
		networkManager = new NetworkManager(this);
	}

	@Override
	public void render () {
        super.render();
	}
	
	
	public final ScreenManager getScreenManager() {
		return screenManager;
	}
	
	public final NetworkManager getNetworkManager() {
		return networkManager;
	}
}
