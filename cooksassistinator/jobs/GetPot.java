package cooksassistinator.jobs;

import java.awt.Point;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.methods.widget.ChatOptions;
import org.powerbot.game.api.wrappers.node.GroundItem;
import org.powerbot.game.api.wrappers.node.SceneObject;

import cooksassistinator.stuff.Data;
import cooksassistinator.stuff.Methods;

public class GetPot extends Node implements Data {
	
	@Override
	public boolean activate() {
		return Inventory.getCount(1931) == 0
				&& KITCHEN.contains(Players.getLocal()) && Inventory.getCount(15414)==0;
	}

	@Override
	public void execute() {
		Methods.status="Taking Pot";
		while (Inventory.getCount(1931) == 0) {
			GroundItem pot = GroundItems.getNearest(1931);
			if (pot != null) {
				if (!pot.isOnScreen()||ChatOptions.canContinue()) {
					Camera.turnTo(pot);
				}
				Point potPoint=getOnScreenPoint(pot);
				Mouse.click(potPoint, true);
				Task.sleep(1000, 1500);
			}
		}

	}

	private Point getOnScreenPoint(GroundItem gi) {
		if (gi == null || !gi.validate() || !gi.isOnScreen())
			return null;
		final int surfaceHeight = 500;
		SceneObject surface = SceneEntities.getAt(gi.getLocation());
		return (surface != null && surface.validate() && surface.getType() == SceneEntities.TYPE_INTERACTIVE) ? gi
				.getLocation().getPoint(.5d, .5d, -surfaceHeight) : gi
				.getCentralPoint();
	}

}
