package cooksassistinator.jobs;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.methods.widget.ChatOptions;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import cooksassistinator.stuff.Methods;

public class TalkToCook extends Node {

	@Override
	public boolean activate() {
		NPC cook = NPCs.getNearest(278);
		return cook != null && Inventory.getCount(15414) > 0;
	}

	@Override
	public void execute() {
		// Locate cook
		NPC cook = NPCs.getNearest(278);
		while (!ChatOptions.canContinue()) {
			if (Players.getLocal().getLocation().getY() == 3218) {
				Methods.status="Re-entering kitchen";
				SceneEntities.getNearest(12348).click(true);
				Task.sleep(3000, 4000);
			}
			Methods.status="Getting cook's attention";
			while (!cook.isOnScreen()) {
				Camera.turnTo(cook);
			}
			cook.click(true);
			Task.sleep(1000);
		}

		Methods.status="Talking to cook";
		Methods.continueChat();
		giveItem();
		Methods.continueChat();
		giveItem();
		Methods.continueChat();
		giveItem();
		// Talk to cook
		for (int i = 0; i < 6; i++) {
			Methods.continueChat();
		}
		
		Methods.status="Finishing quest";
		WidgetChild finishButton = Widgets.get(1244, 23);
		if (finishButton != null && !finishButton.isOnScreen()) {
			Task.sleep(2000, 3000);
			finishButton = Widgets.get(1244, 23);
		}
		finishButton.click(true);
		Task.sleep(3000, 4000);
		Methods.status="Finished";
	}

	public void giveItem() {
		for (int i = 0; i < 3; i++) {
			WidgetChild continueButton = Widgets.get(1189, 10);
			if (continueButton != null && !continueButton.isOnScreen()) {
				Task.sleep(2000, 3000);
				continueButton = Widgets.get(1189, 11);
			}
			continueButton.click(true);
		}
	}

}
