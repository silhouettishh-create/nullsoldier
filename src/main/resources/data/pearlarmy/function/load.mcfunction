tag @s add pa_me
execute as @e[type=fishing_bobber,tag=!pa_hook] if function pearlarmy:is_new run function pearlarmy:hook_new
tag @s remove pa_me
