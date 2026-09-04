package com.nhlstenden.kingdomsandquests.characters;

import com.nhlstenden.kingdomsandquests.Character;

public class Mage extends Character
{
	private static final int DEFENSE_BOOST = 5;

	public Mage(String name, int attackPower, int defense)
	{
		super(name, attackPower, defense);
	}

	@Override
	public void useSpecialAbility()
	{
		setDefense(getDefense() + DEFENSE_BOOST);
	}
}
