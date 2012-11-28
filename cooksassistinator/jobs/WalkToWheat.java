package cooksassistinator.jobs;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.node.SceneObject;


import cooksassistinator.stuff.Data;
import cooksassistinator.stuff.Methods;

public class WalkToWheat extends Node implements Data{

	@Override
	public boolean activate() {
		SceneObject pen = SceneEntities.getNearest(36952);
		if(pen!=null && Calculations.distance(pen, Players.getLocal())<5 && Inventory.getCount(15412)>0){
			return true;
		}
		return false;
	}

	@Override
	public void execute() {
		//Walk to chicken fence
		Methods.status="Walking to the fence";
		Methods.walkLocal(new Tile(3235, 3296, 0));
		//Go through chicken fence
		Methods.status="Going through the fence";
		Methods.passGate(45206, new Tile(3239, 3295, 0));
		//Walk to Mill
		Methods.status="Walking to the wheat field";
		Methods.walkPath(CFENCE_TO_WFENCE);
		//Go through wheat fence
		Methods.status="Entering wheat field";
		Methods.passGate(45210, new Tile(3162, 3295, 0));
	}

}
