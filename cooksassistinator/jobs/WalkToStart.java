package cooksassistinator.jobs;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;

import cooksassistinator.stuff.*;

public class WalkToStart extends Node implements Data {

	@Override
	public boolean activate() {
		return (LUMBRIDGE_SQUARE
				.contains(Players.getLocal().getLocation()));
	}

	@Override
	public void execute() {
		Methods.status="Walking to start";
		Methods.walkPath(SQUARE_TO_COOK);
	}
}
