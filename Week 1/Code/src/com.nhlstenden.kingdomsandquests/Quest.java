package com.nhlstenden.kingdomsandquests;

public abstract class Quest
{
	private String title;
	private int xpReward;
	private int difficulty;

	public Quest(String title, int xpReward, int difficulty)
	{
		this.title = title;
		this.xpReward = xpReward;
		this.difficulty = difficulty;
	}

	public int getRequiredXP()
	{
		return difficulty * 10;
	}

	public String getTitle()
	{
		return title;
	}

	public int getXpReward()
	{
		return xpReward;
	}

	public int getDifficulty()
	{
		return difficulty;
	}
}