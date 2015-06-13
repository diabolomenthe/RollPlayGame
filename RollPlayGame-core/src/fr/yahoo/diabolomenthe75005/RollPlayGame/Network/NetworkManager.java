package fr.yahoo.diabolomenthe75005.RollPlayGame.Network;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import fr.yahoo.diabolomenthe75005.RollPlayGame.RollPlayGame;
import fr.yahoo.diabolomenthe75005.RollPlayGame.Player.Player;

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
		kryo.register(Player.class);
		kryo.register(String.class);
		client.addListener(new Listener() {
			public void connected (Connection connection) {
				System.out.println("CLIENT - le joueur est connecté");
				connected = true;
			}
			public void received (Connection connection, Object object){
				if (object instanceof Player) {
					Player response = (Player)object;
					System.out.println(response.message);
				}
				if (object instanceof String) {
					String response = (String)object;
					System.out.println("String reçu");
					game.getScreenManager().updateScreen(response);
				}

			}

		});
	}
	
	public boolean connectToServer(final String ip,final int port){
		new Thread("Connect"){
            public void run () {
                try {
                    client.connect(5000, ip, port);
                    System.out.println("Connected!");
                    client.setKeepAliveTCP(NORM_PRIORITY);
                    while(connected) {
                        //System.out.println(client.isIdle());
                    }
                    client.run();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }.start();
		return false;
	}

	public void sendMessage(String text) {
		client.sendTCP(text);
	}
}
