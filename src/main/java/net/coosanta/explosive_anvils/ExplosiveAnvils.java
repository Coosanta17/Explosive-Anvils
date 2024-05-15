package net.coosanta.explosive_anvils;

import net.coosanta.explosive_anvils.item.ModItemGroups;
import net.coosanta.explosive_anvils.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExplosiveAnvils implements ModInitializer {
	public static final String MOD_ID = "explosive-anvils";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Anvils go boom boom!");
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}