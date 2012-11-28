package cooksassistinator.jobs;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.Tile;
import cooksassistinator.stuff.Methods;

public class MilkCow extends Node {

	@Override
	public boolean activate() {
		return Calculations.distance(Players.getLocal().getLocation(),new Tile(3262,3276,0))<=2 && 28-Inventory.getCount()+roundDown(Inventory.getCount(1931))>=4 && Inventory.getCount(15413)==0;
	}
	
	private int roundDown(int count) {
		return (count > 0 ? 1 : 0);
	}

	@Override
	public void execute() {
		//Pick the bucket up if you don't have one yet
		Methods.status="Taking bucket";
		Methods.pickUp(1925);
		//Milk the cow
		Methods.status="Milking cow";
		while (Inventory.getCount(15413)==0){
			Methods.clickObject(47721);
		}
	}

}
