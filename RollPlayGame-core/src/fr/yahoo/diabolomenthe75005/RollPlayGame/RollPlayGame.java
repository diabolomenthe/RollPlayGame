package fr.yahoo.diabolomenthe75005.RollPlayGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.esotericsoftware.kryonet.Client;

import fr.yahoo.diabolomenthe75005.RollPlayGame.MessageServer.MessageServer;
import fr.yahoo.diabolomenthe75005.RollPlayGame.Network.NetworkManager;
import fr.yahoo.diabolomenthe75005.RollPlayGame.Screen.GameScreen;
import fr.yahoo.diabolomenthe75005.RollPlayGame.Screen.ScreenManager;

public class RollPlayGame extends Game {
	private ScreenManager screenManager = null;
	private NetworkManager networkManager = null;
	public boolean connected = false;
	
	@Override
	public void create () {
		//Lance le screen manager
		screenManager = new ScreenManager(this);
		networkManager = new NetworkManager(this);
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
