package com.nhlstenden.kingdomsandquests;

public abstract class Character
{

	private String name;
	private int level;
	private int xp;
	private int attackPower;
	private int defense;
	private boolean defending;
	private int lastDamageDealt;

	public Character(String name, int attackPower, int defense)
	{
		this.name = name;
		this.level = 1;
		this.xp = 0;
		this.attackPower = attackPower;
		this.defense = defense;
		this.defending = false;
		this.lastDamageDealt = 0;
	}

	public void attack(Character target)
	{
		int damage = calculateAttackDamage();

		if (target.consumeDefending())
		{
			damage = damage / 2;
		}

		damage = Math.max(0, damage - target.getDefense());
		lastDamageDealt = damage;
	}

	public void defend()
	{
		defending = true;
	}

	public abstract void useSpecialAbility();

	protected int calculateAttackDamage()
	{
		return attackPower;
	}

	protected boolean consumeDefending()
	{
		boolean wasDefending = defending;
		defending = false;
		return wasDefending;
	}

	public int getLastDamageDealt()
	{
		return lastDamageDealt;
	}

	public boolean isDefending()
	{
		return defending;
	}

	public String getName()
	{
		return name;
	}

	public int getLevel()
	{
		return level;
	}

	public int getXp()
	{
		return xp;
	}

	public int getAttackPower()
	{
		return attackPower;
	}

	public void setAttackPower(int attackPower)
	{
		this.attackPower = attackPower;
	}

	public int getDefense()
	{
		return defense;
	}

	public void setDefense(int defense)
	{
		this.defense = defense;
	}
}