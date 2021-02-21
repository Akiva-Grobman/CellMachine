# CellMachine
This is base off of the idea Sam hogen used in this video

## Rules
### The Mover Cell:
Has a movement direction (up, down, right, left).
Will move all pieces in its path.
Blue.
### The Pushed Cell:
Can be pushed.
Gray.
### The Generator Cell:
Will make a copy of the cell behind it and paste it in front of itself.
If there's already a piece in front of this cell is will push is one over and then paste in the copy.
Green.
### The Enemy Cell:
When a different cell collides with this cell both will be destroyed(removed),
If all enemies are destroyed the level is over.
Red.
The Rotator Cell:
Will cause all cells near it to rotate (90 deg) in the counterclockwise.
Orange.
### The Slider Cell:
Will only be pushed in the direction indicated.
Gray and white.

## Contributors
![Akiva's profile picture](https://avatars1.githubusercontent.com/u/44336769?v=3&s=80)
![Yoni's profile picture](https://avatars1.githubusercontent.com/u/64780479?v=3&s=80)