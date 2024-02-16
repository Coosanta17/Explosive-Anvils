#Resets score if >= 3
execute if score Coosanta atick_delay matches 3.. run scoreboard players set Coosanta atick_delay 0

#runs function explosive_anvils:falling_default_anvil_tick if score <= 0
execute if score Coosanta atick_delay matches ..0 run function explosive_anvils:falling_default_anvil_tick

#adds 1 to score
execute run scoreboard players add Coosanta atick_delay 1