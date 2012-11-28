package cooksassistinator.jobs;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.methods.widget.ChatOptions;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.node.SceneObject;

import cooksassistinator.stuff.Methods;

public class MakeFlour extends Node {

	@Override
	public boolean activate() {
		return Players.getLocal().getLocation().getY() >= 3303
				&& Inventory.getCount(15414) == 0
				&& Inventory.getCount(15412) > 0;
	}

	@Override
	public void execute() {
		// Locate millie
		Methods.status="Getting Millie's attention";
		while (!ChatOptions.canContinue()) {
			NPC millie = NPCs.getNearest(3806);
			while (millie==null||!millie.isOnScreen()) {
				Camera.turnTo(millie);
			}
			millie.click(true);
			Task.sleep(3000, 4000);
		}

		Methods.status="Talking to Millie";
		// Talk to millie
		Methods.continueChat();
		Methods.chooseChatOption("extra");
		Methods.continueChat();
		Methods.continueChat();
		Methods.continueChat();
		Methods.chooseChatOption("thanks");

		// Go to the top of the mill
		Methods.status="Climbing to the top of the mill";
		SceneObject ladder2 = null;
		while (ladder2 == null || !ladder2.isOnScreen()) {
			Methods.clickObject(36795);
			Task.sleep(500, 1000);
			ladder2 = SceneEntities.getNearest(36796);
		}
		ladder2.interact("Climb-up");
		SceneObject ladder3 = SceneEntities.getNearest(36797);
		while (ladder3 == null || !ladder3.isOnScreen()) {
			Task.sleep(500, 1000);
			ladder3 = SceneEntities.getNearest(36797);
		}

		// Start grinding process
		Methods.status="Filling hopper";
		Inventory.selectItem(1947);
		while (!Inventory.isItemSelected()) {
			Task.sleep(250, 600);
		}
		while (Inventory.getCount(1947) != 0) {
			Methods.clickObject(70034);
		}
		Methods.status="Operating hopper";
		Methods.clickObject(2718);
		Task.sleep(5000);

		// Go to the bottom of the mill
		Methods.status="Climbing to the bottom of the mill";
		Methods.clickObject(36797);
		SceneObject ladder4 = SceneEntities.getNearest(36796);
		while (ladder4 == null || !ladder4.isOnScreen()) {
			Task.sleep(500, 1000);
			ladder4 = SceneEntities.getNearest(36796);
		}
		ladder4.interact("Climb-down");
		SceneObject ladder5 = SceneEntities.getNearest(36795);
		while (ladder5 == null || !ladder5.isOnScreen()) {
			Task.sleep(500, 1000);
			ladder5 = SceneEntities.getNearest(36795);
		}

		// Take the flour
		Methods.status="Taking the flour";
		while (Inventory.getCount(15414) == 0) {
			Methods.clickObject(36880);
		}

	}

}
