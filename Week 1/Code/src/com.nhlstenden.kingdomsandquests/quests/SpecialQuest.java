package com.nhlstenden.kingdomsandquests.quests;

import com.nhlstenden.kingdomsandquests.Item;
import com.nhlstenden.kingdomsandquests.Quest;

public class SpecialQuest extends Quest
{
	private Item itemReward;

	public SpecialQuest(String title, int xpReward, int difficulty, Item itemReward)
	{
		super(title, xpReward, difficulty);
		this.itemReward = itemReward;
	}

	public Item getItemReward()
	{
		return itemReward;
	}
}