#summon armor_stand ~ ~ ~ {Invisible:1b,NoBasePlate:1b,DisabledSlots:4144959,Invulnerable:1b,Tags:["falling_exploding_anvils","default_fea"],ArmorItems:[{id:anvil,Count:1}],ArmorDropChances:[f]}
execute as @e[tag=default_fea] unless block ~ ~-0.1 ~ air run function explosive_anvils:explode_default_falling_explosive_anvil