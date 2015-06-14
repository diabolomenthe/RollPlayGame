package fr.yahoo.diabolomenthe75005.RollPlayGame.Network;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import fr.yahoo.diabolomenthe75005.RollPlayGame.RollPlayGame;
import fr.yahoo.diabolomenthe75005.RollPlayGame.Player.Player;
import fr.yahoo.diabolomenthe75005.RollPlayGameServer.MessageServer.MessageServer;

public class NetworkManager {
	RollPlayGame game = null;
	Client client = null;
	Boolean connected = false;

	public NetworkManager(RollPlayGame g) {
		this.game = g;
		client = new Client();
		client.start();
		/* on enregistre les objets ...attention à l'ordre !!!*/
		Kryo kryo = client.getKryo();
		kryo.register(MessageServer.class);
		client.addListener(new Listener() {
			public void connected (Connection connection) {
				System.out.println("CLIENT - le joueur est connecté");
				connected = true;
			}
			public void received (Connection connection, Object object){
				System.out.println("Objbjet reçu");
				if (object instanceof Player) {
					Player response = (Player)object;
					System.out.println(response.message);
				}
				if (object instanceof MessageServer) {
					String response = ((MessageServer)object).getMessage();
					System.out.println("String reçu");
					game.getScreenManager().updateScreen(response);
				}

			}
			public void disconnected(Connection connection){
				System.out.println("Disconnected");
			}

		});
	}

	public boolean connectToServer(final String ip,final int port){
		try{
			client.connect(20000, ip, port,port+1);
			System.out.println("Connected!");
			client.setKeepAliveTCP(Thread.NORM_PRIORITY);
		} catch (IOException ex) {
			ex.printStackTrace();
		}


		return false;
	}

	public void sendMessage(String text) {
		client.sendTCP(text);
	}

	public void sendMessage(MessageServer messageServer) {
		// TODO Auto-generated method stub
		if(!client.isConnected()){
			try {
				client.reconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		client.sendTCP(messageServer);

	}

}