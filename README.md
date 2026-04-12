# 🎰 Gambler's Luck
A text-based RPG dungeon crawler built in Java using OOP principles.
Fight your way through a deadly casino, collect coins and survive!

## Features
* 🎲 4 enemy types — Dice, Bodyguard, Blackjack Cards, Slot Machine
* 👑 2 Boss fights — the Dealer and the Kingpin
* ⚔️ Turn-based combat — Normal and Heavy attacks
* 💰 Coin-based damage system — more coins = more damage
* 🛒 NPCs — Merchant, Bartender, Croupier and Janitor
* 🏢 7 floors — each harder than the last
* 💀 Game Over screen — ASCII art on death

## Tech Stack
Language  | Java
Paradigm  | Object-Oriented Programming (OOP)
IDE       | Eclipse

## Project Structure
gamblers-luck/
├── Enemy.java   # Enemy types and AI
├── Game.java    # Game loop, rooms, NPCs and loot
└── Player.java  # Player stats, attacks and coin management

## Getting Started
Java installed. No dependencies required.

### Installation
1. Clone the repository
git clone https://github.com/NinoMarinkovic/GamblersLuck.git
2. Open in Eclipse and run `Game.java`

## How to Play
| Action | Description |
|--------|-------------|
| Type `ja` | Start the game |
| Press `1` | Normal attack |
| Press `2` | Heavy attack (costs 3 coins) |

## How the Combat Works
damagePlayer = attackPlayer
+ (HeavyActive × HeavyAttack × HeavyAttackMultiplier)
+ (coinDamageMultiplier × coins)
+ (CraneActive × (attackPlayer × PaperCutMultiplier))
