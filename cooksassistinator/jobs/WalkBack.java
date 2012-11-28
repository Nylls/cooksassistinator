package cooksassistinator.jobs;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.node.SceneObject;

import cooksassistinator.stuff.Data;
import cooksassistinator.stuff.Methods;


public class WalkBack extends Node implements Data {

	@Override
	public boolean activate() {
		SceneObject bin=SceneEntities.getNearest(36880);
		return bin!=null && Inventory.getCount(15414)>0;
	}

	@Override
	public void execute() {
		Methods.status="Exiting mill";
		//Go through door
		Methods.passGate(45966,new Tile(3166, 3300, 0));
		Methods.status="Walking to cook";
		//Walk to cook
		Methods.walkPath(MILL_TO_COOK);

	}

}
