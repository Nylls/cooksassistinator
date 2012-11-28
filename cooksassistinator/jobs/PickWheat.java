package cooksassistinator.jobs;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import cooksassistinator.stuff.Data;
import cooksassistinator.stuff.Methods;

public class PickWheat extends Node implements Data{

	@Override
	public boolean activate() {
		return WHEATFIELD.contains(Players.getLocal()) && Inventory.getCount(1947)==0 && Inventory.getCount(15412)>0;
	}

	@Override
	public void execute() {
		Methods.status="Picking wheat";
		while(Inventory.getCount(1947)==0){
			Methods.clickObject(15506,15507,15508);
		}
	}

}
