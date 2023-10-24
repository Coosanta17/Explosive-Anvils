package net.coosanta.explosive_anvils.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.coosanta.explosive_anvils.init.ExplosiveAnvilsModBlocks;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class CheckConfigExplosiveAnvilProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		File file = new File("");
		com.google.gson.JsonObject mainObj = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subObj = new com.google.gson.JsonObject();
		file = (File) new File((Minecraft.getInstance().gameDirectory + "/config/"), File.separator + "explosive_anvil.json");
		if (file.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					mainObj = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					subObj = mainObj.get("allowed_blocks").getAsJsonObject();
					if (blockstate.getBlock() == ExplosiveAnvilsModBlocks.EXPLOSIVE_ANVIL) {
						if (subObj.get("default_explosive_anvil").getAsBoolean() == false) {
							{
								BlockPos _pos = BlockPos.containing(x, y, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						} else {
							SpawnFallingExplosiveAnvilProcedure.execute(world, x, y, z);
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"tellraw @p {\"text\":\"Placing default explosive anvils aren't allowed!\",\"italic\":true,\"color\":\"red\"}");
						}
					} else if (blockstate.getBlock() == ExplosiveAnvilsModBlocks.CREEPER_EXPLOSIVE_ANVIL) {
						if (subObj.get("creeper_anvil").getAsBoolean() == false) {
							{
								BlockPos _pos = BlockPos.containing(x, y, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"tellraw @p {\"text\":\"Creeper explosive anvils aren't allowed!\",\"italic\":true,\"color\":\"red\"}");
						} else {
							ShouldSpawnFallingCreeperExplosiveAnvilProcedure.execute(world, x, y, z);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			ConfigProcedure.execute();
		}
	}
}
