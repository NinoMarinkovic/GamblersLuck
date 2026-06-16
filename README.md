# Gambler's Luck

A text-based RPG dungeon crawler written in Java. Fight through 7 floors of a deadly casino, collect coins, and survive two boss encounters — built around OOP principles.

[![GitHub](https://img.shields.io/badge/GitHub-NinoMarinkovic%2FGamblersLuck-181717?logo=github)](https://github.com/NinoMarinkovic/GamblersLuck)
[![Language](https://img.shields.io/badge/language-Java-orange)](https://github.com/NinoMarinkovic/GamblersLuck)
[![License](https://img.shields.io/badge/license-MIT-blue)](LICENSE)

---

## Tech Stack

**Language:** Java  
**Paradigm:** Object-Oriented Programming (OOP)  
**IDE:** Eclipse  

---

## Features

- **4 enemy types** — Dice, Bodyguard, Blackjack Cards, Slot Machine
- **2 boss fights** — the Dealer and the Kingpin
- **Turn-based combat** — Normal and Heavy attacks
- **Coin-based damage system** — the more coins you carry, the harder you hit
- **4 NPCs** — Merchant, Bartender, Croupier, Janitor
- **7 floors** — each harder than the last
- **ASCII Game Over screen** on death

---

## Project Structure

```
gamblers-luck/
├── Enemy.java    # Enemy types and combat AI
├── Game.java     # Game loop, rooms, NPCs and loot
└── Player.java   # Player stats, attacks and coin management
```

---

## Getting Started

**Prerequisites:** Java installed. No external dependencies.

```bash
git clone https://github.com/NinoMarinkovic/GamblersLuck.git
```

Open the project in Eclipse and run `Game.java`.

---

## How to Play

| Input | Action |
|-------|--------|
| `ja` | Start the game |
| `1` | Normal attack |
| `2` | Heavy attack (costs 3 coins) |

---

## Combat System

Damage is calculated as:

```
damage = baseAttack
       + (heavyActive × heavyAttack × heavyAttackMultiplier)
       + (coinDamageMultiplier × coins)
       + (craneActive × (baseAttack × paperCutMultiplier))
```

Coins aren't just currency — they directly scale your damage output. Spending them on Heavy attacks trades resources for burst damage.

---

## License

MIT — see [LICENSE](LICENSE)
