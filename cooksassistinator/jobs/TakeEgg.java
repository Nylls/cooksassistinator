package cooksassistinator.jobs;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.Tile;

import cooksassistinator.stuff.Methods;

public class TakeEgg extends Node {

	@Override
	public boolean activate() {
		Methods.status="Taking egg";
		return Calculations.distance(Players.getLocal().getLocation(),new Tile(3227, 3300, 0))<3 && Inventory.getCount(15413)>0 && Inventory.getCount(15412)==0;
	}

	@Override
	public void execute() {
		//Take the super large egg
		Methods.pickUp(15412);
	}

}
