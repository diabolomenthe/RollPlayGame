package fr.yahoo.diabolomenthe75005.RollPlayGame.Screen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameScreen implements Screen {
	ScreenManager manager = null;
	Stage stage = null;
	Skin skin = null;

	TextArea chatRec=null;
	TextArea chatSend=null;
	
	public GameScreen(ScreenManager manager,Skin skin){
		this.manager = manager;
		this.skin = skin;
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		chatRec=new TextArea("Affichage du texte",skin);
		chatSend=new TextArea("Réception du texte",skin);
		
		Table chat = new Table();
		
		chat.add(chatRec).width(Gdx.graphics.getWidth()*3/5).height(Gdx.graphics.getHeight()/5-30f);
		chat.row();
		chat.add(chatSend).width(Gdx.graphics.getWidth()*3/5).height(30f);
		chat.row();
		
		chat.setWidth(Gdx.graphics.getWidth()*3/5);
		chat.setHeight(Gdx.graphics.getHeight()/5);
		chat.setPosition(0,0);
		
		stage.addActor(chat);

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		stage.act(delta);
		stage.draw();
		
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
			manager.getGame().getNetworkManager().sendMessage(chatSend.getText());
			chatSend.setText("");
		}
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

	}
	
	public final TextArea getchatSend(){
		return chatSend;
	}
	
	public final TextArea getchatRec(){
		return chatRec;
	}
	

}
