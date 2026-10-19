tag @s remove pa_new
scoreboard players operation @s pa_slot = #next pa_t
scoreboard players add #next pa_t 1
execute if score #next pa_t matches 141.. run scoreboard players set #next pa_t 0
item replace entity @s armor.head with netherite_helmet[enchantments={protection:4,unbreaking:3},trim={material:"minecraft:netherite",pattern:"minecraft:flow"}]
item replace entity @s armor.chest with netherite_chestplate[enchantments={protection:4,unbreaking:3},trim={material:"minecraft:quartz",pattern:"minecraft:flow"}]
item replace entity @s armor.legs with netherite_leggings[enchantments={protection:4,unbreaking:3},trim={material:"minecraft:netherite",pattern:"minecraft:flow"}]
item replace entity @s armor.feet with netherite_boots[enchantments={protection:4,unbreaking:3},trim={material:"minecraft:netherite",pattern:"minecraft:flow"}]
item replace entity @s weapon.mainhand with netherite_sword[enchantments={sharpness:5,unbreaking:3}]
