summon pearlarmy:soldier ~ ~0.3 ~ {Tags:["pa_new"],PersistenceRequired:1b,DeathLootTable:"minecraft:empty",drop_chances:{head:0.0f,chest:0.0f,legs:0.0f,feet:0.0f,mainhand:0.0f,offhand:0.0f}}
execute as @e[type=pearlarmy:soldier,tag=pa_new,distance=..3] run function pearlarmy:equip
particle minecraft:portal ~ ~1 ~ 0.3 0.6 0.3 0.2 30
playsound minecraft:entity.enderman.teleport hostile @a ~ ~ ~ 0.3 1
