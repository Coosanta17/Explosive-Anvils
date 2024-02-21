#summon armor_stand ~ ~ ~ {Invisible:1b,NoBasePlate:1b,DisabledSlots:4144959,Invulnerable:1b,Tags:["falling_exploding_anvils","creeper_fea"],ArmorItems:[{id:anvil,Count:1}],ArmorDropChances:[f]}
execute as @e[tag=creeper_fea] unless block ~ ~-0.01 ~ air run function explosive_anvils:explode_creeper_falling_explosive_anvil
execute as @e[tag=creeper_fea] if score @s catick_delay matches ..2 run scoreboard players add @s catick_delay 1
execute as @e[tag=creeper_fea] if score @s catick_delay matches 1 run function explosive_anvil:release_the_creepers