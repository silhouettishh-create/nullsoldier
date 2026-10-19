tag @s add pa_hook
execute on origin if items entity @s weapon.* fishing_rod[custom_data~{army_rod:"yes"}] run function pearlarmy:summon_army
execute on origin if items entity @s weapon.* fishing_rod[custom_data~{form_rod:"yes"}] run function pearlarmy:formation
