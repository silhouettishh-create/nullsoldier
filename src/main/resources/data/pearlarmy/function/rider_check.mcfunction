scoreboard players set #has pa_t 0
execute on vehicle run scoreboard players set #has pa_t 1
execute if score #has pa_t matches 0 run function pearlarmy:land
