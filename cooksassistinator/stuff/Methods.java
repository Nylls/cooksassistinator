package cooksassistinator.stuff;

import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.methods.widget.ChatOptions;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.map.TilePath;
import org.powerbot.game.api.wrappers.node.GroundItem;
import org.powerbot.game.api.wrappers.node.SceneObject;
import org.powerbot.game.api.wrappers.widget.ChatOption;


public class Methods {

	public static String status="Starting Script";
	// Walking
	// --Walk a path
	public static void walkPath(TilePath path) {
		while (Calculations.distance(Players.getLocal(), path.getEnd()) > 3) {
			path.traverse();
			Task.sleep(1000, 2000);
		}
	}

	// --Walk to a tile
	public static void walkLocal(Tile tile) {
		while (Calculations.distance(Players.getLocal(), tile) > 3) {
			Walking.walk(tile);
			Task.sleep(1000, 2000);
		}
	}

	// --Pass gate/door
	public static void passGate(int id, Tile destination) {
		while (Calculations.distance(Players.getLocal().getLocation(),
				destination) > 2) {
			SceneObject closedGate = SceneEntities.getNearest(id);
			if (closedGate != null && Calculations.distance(closedGate, destination)<4) {
				if (!closedGate.isOnScreen()) {
					Camera.turnTo(closedGate);
				}
				closedGate.click(true);
			} else {
				Walking.walk(destination);
			}
			Task.sleep(500, 1000);
		}
	}

	// Interact
	// --Pick up ground item
	public static void pickUp(int id) {
		while (Inventory.getCount(id) == 0) {
			GroundItem item = GroundItems.getNearest(id);
			if (item != null) {
				if (!item.isOnScreen()) {
					Camera.turnTo(item);
				}
				item.interact("Take");
			} else {
				Task.sleep(1050);
			}
		}
	}

	public static void clickObject(int... ids) {
		SceneObject so = SceneEntities.getNearest(ids);
		if (so != null) {
			Camera.turnTo(so);
			so.click(true);
		}
		Task.sleep(3000, 4000);
	}

	// Chat
	public static void continueChat() {
		while (!ChatOptions.canContinue()) {
			Task.sleep(1000);
		}
		ChatOptions.getContinueOption().select(true);
		Task.sleep(3000, 4000);
	}

	public static void chooseChatOption(String option) {
		ChatOption extraOption = ChatOptions.getOption(option);
		while (extraOption == null) {
			Task.sleep(1000);
			extraOption = ChatOptions.getOption(option);
		}
		extraOption.select(true);
	}
}
