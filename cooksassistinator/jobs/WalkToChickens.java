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

public class WalkToChickens extends Node implements Data{

	@Override
	public boolean activate() {
		SceneObject cow = SceneEntities.getNearest(47721);
		if(cow!=null && Calculations.distance(cow, Players.getLocal())<5 && Inventory.getCount(15413)>0){
			return true;
		}
		return false;
		}

	@Override
	public void execute() {
		//Walk to the cow fence
		Methods.status="Walking to the fence";
		Methods.walkPath(COW_TO_FENCE);
		Methods.status="Going through the fence";
		//Go through the cow fence
		Methods.passGate(45210, new Tile(3250, 3267, 0));
		//Walk to the chicken fence
		Methods.status="Walking to the chicken farm";
		Methods.walkPath(CFENCE_TO_CFENCE);
		//Go through chicken fence
		Methods.status="Going through the fence";
		Methods.passGate(45206, new Tile(3234, 3295, 0));
		//Walk to egg
		Methods.status="Walking to the egg";
		Methods.walkLocal(new Tile(3227, 3300, 0));
	}

}
