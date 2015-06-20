package fr.yahoo.diabolomenthe75005.RollPlayGame.Screen;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

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

public class CartesScreen implements Screen {
	ScreenManager manager = null;
	Stage stage = null;
	Skin skin = null;

	public CartesScreen(final ScreenManager manager,Skin skin){
		this.manager = manager;
		this.skin = skin;
		final JFileChooser filechooser = new JFileChooser();

		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		Table table = new Table();
		Table table2 = new Table();

		final TextArea mapfile = new TextArea("",skin);
		TextButton mapfilesearch=new TextButton("Browse",skin);
		mapfilesearch.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				FileFilter filter = new FileFilter() {
					@Override
					public boolean accept(File f) {
						if(f.getName().contains(".tmx")){
							return true;
						}
						return false;
					}

					@Override
					public String getDescription() {

						return "tmx";

					}
				};
				filechooser.setFileFilter(filter);
				if(filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					mapfile.setText(filechooser.getSelectedFile().getName());
					try {
						Files.copy(Paths.get(filechooser.getSelectedFile().getAbsolutePath()),Paths.get("./" + filechooser.getSelectedFile().getName()), REPLACE_EXISTING);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});

		TextButton cartes=new TextButton("Cartes",skin);
		cartes.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				manager.setScreen("cartes");
			}
		});
		TextButton retour=new TextButton("Retour",skin);
		retour.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				manager.setScreen("create");
			}
		});

		TextButton save = new TextButton("Sauvegarde",skin);
		save.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				manager.setScreen("create");
			}
		});

		mapfile.setWidth(Gdx.graphics.getWidth() - 100f);
		mapfilesearch.setWidth(15f);

		table.add(mapfile).width(Gdx.graphics.getWidth() - 100f).height(30f).pad(5f);
		table.add(mapfilesearch).width(80f).height(30f).pad(5f);
		table.row();


		table.setWidth(Gdx.graphics.getWidth());
		table.setHeight(Gdx.graphics.getHeight());
		table.setPosition(0, Gdx.graphics.getHeight()/2 - 20f);

		table2.add(save).width(80f).height(30f).pad(5f);
		table2.add(retour).width(80f).height(30f).pad(5f);
		table2.row();


		table2.setWidth(Gdx.graphics.getWidth());
		table2.setHeight(Gdx.graphics.getHeight());
		table2.setPosition(Gdx.graphics.getWidth()/2 - 100f, -Gdx.graphics.getHeight()/2 + 40f);

		stage.addActor(table);
		stage.addActor(table2);

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
