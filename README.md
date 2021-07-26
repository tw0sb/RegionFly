# RegionFly
1.8.x Spigot plugin to allow flying in specific areas for specific players.

## Warning
Its been a couple years since I even tested this plugin, let alone wrote the code for it.
I do remember it working just fine on a server with ~20 players online.

## Depends
- WorldGuard
- WGRegionEvents
- Tested on Spigot 1.8.x

## Permissions
- ``regionfly.admin or op`` - Allows the use of /regionfly.
- ``regionfly.fly`` - Allows flying in specified regions.

## Config

```
#Prefix is shown at the start of each message.
prefix: "&6RegionFly &8>> &e"

#This messages are shown while configurating the plugin through minecraft commands. Only players with the "regionfly.admin" can execute such commands.
regionAdded: "Players with the correct permission can now fly in &6{REGION}&e."
regionRemoved: "Players can no longer fly in &6{REGION}&e."
reloadConfigMessage: "Config has been reloaded!"
invalidUsage: "Invalid Usage! Try &6/regionfly help&e."
helpCommand:
 - "Available Commands:"
 - "&6RegionFly add <region> &7- &e Adds a region as fly region."
 - "&6RegionFly remove <Region> &7- &e Removes a region from being a fly region."
 - "&6RegionFly list &7- &e List of fly regions."
 - "&6RegionFly reload &7- &e Reloads the config."
 - "&6RegionFly help &7- &e This menu."


#Players that try to run an admin command but don't have permission will see this message.
noPermissionMesage: "No permission."

#The message players will see when their flight is activated/deactivated"
flyActivated: "Your fly mode has been activated."
flyDeactivated: "Your fly mode has been deactivated."

#The list of the regions that players with the "regionfly.fly" permission can fly in.
#Note: this are strings so put them inside "".
regionList:
 - "exampleregion"
 ```


# Legal
### License
RegionFly

Copyright (C) 2015-2021 Tw0sb

This program Is free software: you can redistribute it And/Or modify it under the terms Of the GNU General Public License As published by the Free Software Foundation, either version 3 Of the License, Or (at your option) any later version.

This program Is distributed In the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty Of MERCHANTABILITY Or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License For more details.

You should have received a copy Of the GNU General Public License along with this program. If Not, see http://www.gnu.org/licenses/.
