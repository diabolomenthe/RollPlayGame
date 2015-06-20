package fr.yahoo.diabolomenthe75005.RollPlayGame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class HostScreen implements Screen {
	ScreenManager manager = null;
	Stage stage = null;
	Skin skin = null;

	public HostScreen(ScreenManager manager,Skin skin){
		this.manager = manager;
		this.skin = skin;
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		Table table = new Table();
		TextButton hostGame=new TextButton("Joueurs",skin);
		hostGame.addListener(new ClickListener(){
	        @Override
	        public void clicked(InputEvent event, float x, float y) {
	            //game.setScreen();
	        }
	    });
		
		TextButton joinGame=new TextButton("Cartes",skin);
		TextButton QuitGame=new TextButton("Retour",skin);
		
		table.setWidth(200f);
		table.setHeight(20f);
		table.setPosition(Gdx.graphics.getWidth() /2 - 100f, Gdx.graphics.getHeight()/2 - 3*10f);
		
		table.add(hostGame).width(200f).height(20f);
		table.row();
		table.add(joinGame).width(200f).height(20f);
		table.row();
		table.add(QuitGame).width(200f).height(20f);
		table.row();
		
		table.setWidth(200f);
		table.setHeight(60f);
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
        
		stage.act(delta);
		stage.draw();
		//stage.setViewport(800,480,false);
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

}
