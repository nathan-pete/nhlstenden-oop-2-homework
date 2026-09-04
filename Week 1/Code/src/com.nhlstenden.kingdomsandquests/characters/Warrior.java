package com.nhlstenden.kingdomsandquests.characters;

import com.nhlstenden.kingdomsandquests.Character;

public class Warrior extends Character
{

	private static final int ATTACK_BOOST = 5;

	private boolean nextAttackBoosted;

	public Warrior(String name, int attackPower, int defense)
	{
		super(name, attackPower, defense);
		this.nextAttackBoosted = false;
	}

	@Override
	public void useSpecialAbility()
	{
		nextAttackBoosted = true;
	}

	@Override
	protected int calculateAttackDamage()
	{
		int damage = getAttackPower();

		if (nextAttackBoosted)
		{
			damage += ATTACK_BOOST;
			nextAttackBoosted = false;
		}

		return damage;
	}

	public boolean isNextAttackBoosted()
	{
		return nextAttackBoosted;
	}

	public static int getAttackBoost()
	{
		return ATTACK_BOOST;
	}
}