package org.mcteam.ancientgates.commands;

public class CommandOpen extends BaseCommand {
	
	public CommandOpen() {
		aliases.add("open");
		
		requiredParameters.add("id");		
		
		helpDescription = "Open that gate";
	}
	
	public void perform() {
		if (gate.getFrom() == null) {
			sendMessage("You must set the from location first. To fix that:");
			sendMessage(new CommandSetFrom().getUseageTemplate(true, true));
			return;
		}
		
		if (gate.getTo() == null) {
			sendMessage("Sure, but note that this gate does not point anywhere :P");
			sendMessage("To fix that: " + new CommandSetTo().getUseageTemplate(true, true));
		}
		
		if (gate.open()) {
			sendMessage("The gate was opened.");
		} else {
			sendMessage("Failed to open the gate. Have you built a frame?");
			sendMessage("More info here: " + new CommandHelp().getUseageTemplate(true, true));
		}
	}
}

