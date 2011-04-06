package org.mcteam.ancientgates.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class PluginBlockListener extends BlockListener {
	@Override
	public void onBlockPhysics(BlockPhysicsEvent event) {
		if (event.isCancelled()) {
			return;
		}
		
		if (event.getBlock().getType() != Material.PORTAL) {
			return;
		}
		
		if (isBlockInPortal(event.getBlock())) {
			event.setCancelled(true);
		}
	}
	
	public boolean isBlockInPortal(Block block) {
		if (block.getFace(BlockFace.UP).getType() == Material.AIR) {
			return false;
		}
		
		if (block.getFace(BlockFace.DOWN).getType() == Material.AIR) {
			return false;
		}
		
		if ( block.getFace(BlockFace.NORTH).getType() != Material.AIR && block.getFace(BlockFace.SOUTH).getType() != Material.AIR ) {
			return true;
		}
		
		if ( block.getFace(BlockFace.WEST).getType() != Material.AIR && block.getFace(BlockFace.EAST).getType() != Material.AIR ) {
			return true;
		}
		
		return false;
	}
}
