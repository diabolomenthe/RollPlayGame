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

public class MainMenuScreen implements Screen {
	ScreenManager manager = null;
	Stage stage = null;
	Skin skin = null;

	public MainMenuScreen(final ScreenManager manager,Skin skin){
		this.manager = manager;
		this.skin = skin;
		
		stage = new Stage();
		

		Table table = new Table();
		
		TextButton create=new TextButton("Creer/Modifier Jeu",skin);
		create.addListener(new ClickListener(){
	        @Override
	        public void clicked(InputEvent event, float x, float y) {
	            manager.setScreen("create");
	        }
	    });
		
		TextButton hostGame=new TextButton("Accueillir",skin);
		hostGame.addListener(new ClickListener(){
	        @Override
	        public void clicked(InputEvent event, float x, float y) {
	            manager.setScreen("host");
	        }
	    });
		
		TextButton joinGame=new TextButton("Rejoindre",skin);
		joinGame.addListener(new ClickListener(){
	        @Override
	        public void clicked(InputEvent event, float x, float y) {
	            manager.setScreen("join");
	        }
	    });
		
		TextButton QuitGame=new TextButton("Quitter",skin);
		QuitGame.addListener(new ClickListener(){
	        @Override
	        public void clicked(InputEvent event, float x, float y) {
	            Gdx.app.exit();
	        }
	    });
		
		table.setWidth(200f);
		table.setHeight(20f);
		table.setPosition(Gdx.graphics.getWidth() /2 - 100f, Gdx.graphics.getHeight()/2 - 3*10f);
		
		table.add(create).width(200f).height(20f);
		table.row();
		table.add(hostGame).width(200f).height(20f);
		table.row();
		table.add(joinGame).width(200f).height(20f);
		table.row();
		table.add(QuitGame).width(200f).height(20f);
		table.row();
		
		table.setWidth(200f);
		table.setHeight(80f);
		table.setPosition(Gdx.graphics.getWidth() /2 - 100f, Gdx.graphics.getHeight()/2 - 3*10f);
		
		stage.addActor(table);
		
		Gdx.input.setInputProcessor(stage);

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
