package fr.yahoo.diabolomenthe75005.RollPlayGame.Screen;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class JoinScreen implements Screen {
	ScreenManager manager = null;
	Stage stage = null;
	Skin skin = null;

	public JoinScreen(final ScreenManager manager,Skin skin){
		this.manager = manager;
		this.skin = skin;
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		Table table = new Table();
		final TextArea ipaddress = new TextArea("localhost",skin);
		final TextArea port = new TextArea("25565",skin);
		TextButton send=new TextButton("Send",skin);
		send.addListener(new ClickListener(){
	        @Override
	        public void clicked(InputEvent event, float x, float y) {
	        	manager.getGame().getNetworkManager().connectToServer(ipaddress.getText(),Integer.parseInt(port.getText()) );
	        	manager.setScreen("game");
	        }
	    });
		
		
		table.setWidth(200f);
		table.setHeight(90f);
		table.setPosition(Gdx.graphics.getWidth() /2 - 100f, Gdx.graphics.getHeight()/2 - 3*10f);
		
		table.add(ipaddress).width(200f).height(30f);
		table.row();
		table.add(port).width(200f).height(30f);
		table.row();
		table.add(send).width(200f).height(30f);
		table.row();

		table.setPosition(Gdx.graphics.getWidth() /2 - 100f, Gdx.graphics.getHeight()/2 - 3*10f);
		
		stage.addActor(table);

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();


	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
        stage.dispose();
        skin.dispose();
	}

}
