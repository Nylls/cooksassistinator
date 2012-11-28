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
import org.powerbot.game.api.wrappers.widget.ChatOption;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import cooksassistinator.stuff.Data;
import cooksassistinator.stuff.Methods;

public class Start extends Node implements Data {
	
	private boolean started;
	
	public Start(boolean started){
		this.started=started;
	}

	@Override
	public boolean activate() {
		return KITCHEN.contains(Players.getLocal().getLocation()) && !started && Inventory.getCount(15414)==0;
	}

	@Override
	public void execute() {
		// Locate cook
		NPC cook = NPCs.getNearest(278);
		while (!ChatOptions.canContinue()) {
			Methods.status="Locating cook";
			if(Players.getLocal().getLocation().getY()==3218){
				Methods.status="Trying to open door to kitchen";
				SceneEntities.getNearest(12348).click(true);
				Task.sleep(3000,4000);
			}
			while (!cook.isOnScreen()) {
				Camera.turnTo(cook);
			}
			cook.click(true);
			System.out.println("sleep");
			Task.sleep(1000, 2000);
		}

		// Talk to cook
		Methods.status="Talking to cook";
		Methods.continueChat();
		ChatOption wrongOption = ChatOptions.getOption("wrong");
		for (int i = 0; i < 10 && wrongOption == null; i++) {
			Task.sleep(1000);
			wrongOption = ChatOptions.getOption("wrong");
		}
		if (wrongOption != null) {
			wrongOption.select(true);
			Methods.continueChat();
			Methods.continueChat();
			WidgetChild acceptQuest = Widgets.get(190, 441);
			while (!acceptQuest.isOnScreen()) {
				Task.sleep(1000);
			}
			acceptQuest.click(true);
			Methods.continueChat();
			Methods.continueChat();
			Methods.continueChat();
			Methods.continueChat();
		}
		this.started=true;
	}

}
