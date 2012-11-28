package cooksassistinator.jobs;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.Tile;


import cooksassistinator.stuff.Data;
import cooksassistinator.stuff.Methods;

public class WalkToCow extends Node implements Data {

	@Override
	public boolean activate() {
		return KITCHEN.contains(Players.getLocal().getLocation()) && Inventory.getCount(15413)==0 && Inventory.getCount(15414)==0;
	}

	@Override
	public void execute() {
		Methods.status="Walking to cow fence";
		Methods.walkPath(COOK_TO_FENCE);
		Methods.status="Trying to pass the fence";
		Methods.passGate(45210, new Tile(3255, 3267, 0));
		Methods.status="Walking to dairy cow";
		Methods.walkPath(FENCE_TO_COW);
	}

}
