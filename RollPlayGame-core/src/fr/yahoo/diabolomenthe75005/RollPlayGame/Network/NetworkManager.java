package fr.yahoo.diabolomenthe75005.RollPlayGame.Network;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import fr.yahoo.diabolomenthe75005.RollPlayGame.RollPlayGame;
import fr.yahoo.diabolomenthe75005.RollPlayGame.Database.Player;
import fr.yahoo.diabolomenthe75005.RollPlayGame.MessageServer.MessageServer;

public class NetworkManager extends Client{
	private RollPlayGame game = null;
	private String ip = "";
	private int port = 0;

	public NetworkManager(RollPlayGame g) {
		super();
		this.game = g;

		/* on enregistre les objets ...attention à l'ordre !!!*/
		Kryo kryo = this.getKryo();
		kryo.register(MessageServer.class);
		this.addListener(new Listener() {
			public void connected (Connection connection) {
				System.out.println("CLIENT - le joueur est connecté");
			}
			public void received (Connection connection, Object object){
				if (object instanceof MessageServer) {
					String response = ((MessageServer)object).getMessage();
					game.getScreenManager().updateScreen(response);
				}

			}
			public void disconnected(Connection connection){
				System.out.println("Disconnected");
			}

		});
		
	}

	public boolean connect(){
		try{
			this.connect(20000, ip, port,port+1);
			System.out.println("Connected!");
		} catch (IOException ex) {
			ex.printStackTrace();
		}


		return false;
	}

	public void send(Object object) {
		// TODO Auto-generated method stub
		if(!this.isConnected()){
			try {
				this.reconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.sendTCP(object);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}