advancement revoke @s only pearlarmy:tick
scoreboard objectives add pa_t dummy
scoreboard objectives add pa_slot dummy
tag @s add pa_me
execute as @e[type=fishing_bobber,tag=!pa_hook] if function pearlarmy:is_new run function pearlarmy:hook_new
execute as @e[type=marker,tag=pa_rider] at @s run function pearlarmy:rider_check
tag @s remove pa_me
