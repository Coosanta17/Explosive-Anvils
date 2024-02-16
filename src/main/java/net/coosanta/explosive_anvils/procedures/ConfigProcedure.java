package net.coosanta.explosive_anvils.procedures;

import net.minecraft.client.Minecraft;

import net.coosanta.explosive_anvils.ExplosiveAnvilsMod;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class ConfigProcedure {
	public static void execute() {
		File file = new File("");
		com.google.gson.JsonObject mainObj = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subObj = new com.google.gson.JsonObject();
		file = (File) new File((Minecraft.getInstance().gameDirectory + "/config/"), File.separator + "explosive_anvils.json");
		if (!file.exists()) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			subObj.addProperty("default_explosive_anvil", true);
			subObj.addProperty("creeper_anvil", true);
			mainObj.add("allowed_blocks", subObj);
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(file);
					fileWriter.write(mainGSONBuilderVariable.toJson(mainObj));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		} else {
			ExplosiveAnvilsMod.LOGGER.error("Error loading config!");
		}
	}
}
