package fr.yahoo.diabolomenthe75005.RollPlayGame.Model;

import com.badlogic.gdx.utils.Array;


public class Map {
	private String projectname;
	private int heighttiles;
	private int widthtiles;
	private String mapname;
	private Array<String> tilesetname;
	
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public int getHeighttiles() {
		return heighttiles;
	}
	public void setHeighttiles(int heighttiles) {
		this.heighttiles = heighttiles;
	}
	public int getWidthtiles() {
		return widthtiles;
	}
	public void setWidthtiles(int widthtiles) {
		this.widthtiles = widthtiles;
	}
	public String getMapname() {
		return mapname;
	}
	public void setMapname(String mapname) {
		this.mapname = mapname;
	}
	public Array<String> getTilesetname() {
		return tilesetname;
	}
	public void setTilesetname(Array<String> tilesetname) {
		this.tilesetname = tilesetname;
	}
}
