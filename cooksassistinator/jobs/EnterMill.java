package cooksassistinator.jobs;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.Tile;

import cooksassistinator.stuff.Data;
import cooksassistinator.stuff.Methods;

public class EnterMill extends Node implements Data{

	@Override
	public boolean activate() {
		return WHEATFIELD.contains(Players.getLocal()) && Inventory.getCount(1947)>0 && Inventory.getCount(15412)>0;
	}

	@Override
	public void execute() {
		//Walk to gate
		Methods.status="Walking to the fence";
		Methods.walkLocal(new Tile(3163,3296,0));
		//Pass gate
		Methods.status="Exiting wheat field";
		Methods.passGate(45210, new Tile(3167, 3295, 0));
		//Walk to door
		Methods.status="Walking to the mill";
		Methods.walkLocal(new Tile(3166,3302,0));
		//Pass door
		Methods.status="Entering mill";
		Methods.passGate(45966, new Tile(3166, 3305, 0));
	}

}
