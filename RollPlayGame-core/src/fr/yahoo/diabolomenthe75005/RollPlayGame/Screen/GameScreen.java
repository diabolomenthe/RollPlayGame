package fr.yahoo.diabolomenthe75005.RollPlayGame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import fr.yahoo.diabolomenthe75005.RollPlayGame.MessageServer.MessageServer;

public class GameScreen implements Screen, InputProcessor {
	private ScreenManager manager = null;
	private Stage stage = null;
	private Skin skin = null;	
	private InputMultiplexer inputmultiplexer;

	TextArea chatRec=null;
	TextArea chatSend=null;
	
	public GameScreen(ScreenManager manager,Skin skin){
		this.manager = manager;
		this.skin = skin;
		
		
		stage = new Stage();
		
		
		


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
		
		this.inputmultiplexer = new InputMultiplexer();
		this.inputmultiplexer.addProcessor(this);
		this.inputmultiplexer.addProcessor(stage);
		
		Gdx.input.setInputProcessor(inputmultiplexer);

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

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		System.out.println("Test");
		// TODO Auto-generated method stub
		if(this.manager.getGame().getScreen() instanceof GameScreen){
			System.out.println((int) character);
			if((int) character == 13){
				String message = ((GameScreen)this.manager.getGame().getScreen()).getchatSend().getText();
				if(message != "" && message != "\n"){
					this.manager.getGame().getNetworkManager().send(new MessageServer(message));
				}
			}
		}
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
