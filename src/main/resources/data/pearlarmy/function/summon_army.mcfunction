kill @e[type=pearlarmy:soldier]
scoreboard players set #next pa_t 0
execute at @s positioned ~ ~30 ~ run function pearlarmy:ring
playsound minecraft:entity.enderman.teleport player @a ~ ~ ~ 2 1
schedule function pearlarmy:release 20t
