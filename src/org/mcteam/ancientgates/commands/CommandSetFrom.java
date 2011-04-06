package org.mcteam.ancientgates.commands;

import org.mcteam.ancientgates.Gate;

public class CommandSetFrom extends BaseCommand {
	
	public CommandSetFrom() {
		aliases.add("setfrom");
		
		requiredParameters.add("id");		
		
		helpDescription = "Set \"from\" to your location.";
	}
	
	public void perform() {
		gate.setFrom(player.getLocation());
		sendMessage("From location for gate \""+gate.getId()+"\" is now where you stand.");
		sendMessage("Build a frame around that block and:");
		sendMessage(new CommandOpen().getUseageTemplate(true, true));
		
		Gate.save();
	}
	
}

