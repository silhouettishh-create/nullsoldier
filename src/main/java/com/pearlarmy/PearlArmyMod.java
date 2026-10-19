package com.pearlarmy;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PearlArmyMod implements ModInitializer {
	public static final String MOD_ID = "pearlarmy";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEntityTypes.register();
		LOGGER.info("Pearl Army loaded");
	}
}
