package com.nhlstenden.kingdomsandquests.characters;

import com.nhlstenden.kingdomsandquests.Character;

public class Archer extends Character
{

	private boolean nextAttackDoubled;

	public Archer(String name, int attackPower, int defense)
	{
		super(name, attackPower, defense);
		this.nextAttackDoubled = false;
	}

	@Override
	public void useSpecialAbility()
	{
		nextAttackDoubled = true;
	}

	@Override
	protected int calculateAttackDamage()
	{
		int damage = getAttackPower();

		if (nextAttackDoubled)
		{
			damage *= 2;
			nextAttackDoubled = false;
		}

		return damage;
	}

	public boolean isNextAttackDoubled()
	{
		return nextAttackDoubled;
	}
}