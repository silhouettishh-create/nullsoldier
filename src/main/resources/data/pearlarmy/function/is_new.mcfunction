execute on origin if entity @s[tag=pa_me] if items entity @s weapon.* fishing_rod[custom_data~{army_rod:"yes"}] run return 1
execute on origin if entity @s[tag=pa_me] if items entity @s weapon.* fishing_rod[custom_data~{form_rod:"yes"}] run return 1
return 0
