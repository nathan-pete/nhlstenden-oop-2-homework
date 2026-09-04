package com.nhlstenden.kingdomsandquests;

import com.nhlstenden.kingdomsandquests.quests.SpecialQuest;

import java.util.ArrayList;
import java.util.List;

public class Player
{

	private static final int XP_TO_LEVEL_UP = 200;

	private String name;
	private Character character;
	private int totalXP;
	private int level;
	private List<Quest> availableQuests;
	private List<Item> items;

	public Player(String name, Character character)
	{
		this.name = name;
		this.character = character;
		this.totalXP = 0;
		this.level = 1;
		this.availableQuests = new ArrayList<>();
		this.items = new ArrayList<>();
	}

	public List<Quest> viewAvailableQuests()
	{
		List<Quest> playable = new ArrayList<>();
		for (Quest quest : availableQuests)
		{
			if (totalXP >= quest.getRequiredXP())
			{
				playable.add(quest);
			}
		}
		return playable;
	}

	public void playQuest(Quest quest)
	{
		if (totalXP < quest.getRequiredXP())
		{
			return;
		}

		totalXP += quest.getXpReward();

		if (quest instanceof SpecialQuest)
		{
			SpecialQuest specialQuest = (SpecialQuest) quest;
			items.add(specialQuest.getItemReward());
		}

		if (totalXP >= XP_TO_LEVEL_UP)
		{
			levelUp();
		}
	}

	public void levelUp()
	{
		if (totalXP >= XP_TO_LEVEL_UP)
		{
			level++;
			totalXP -= XP_TO_LEVEL_UP;
		}
	}

	public void addAvailableQuest(Quest quest)
	{
		availableQuests.add(quest);
	}

	public String getName()
	{
		return name;
	}

	public Character getCharacter()
	{
		return character;
	}

	public int getTotalXP()
	{
		return totalXP;
	}

	public int getLevel()
	{
		return level;
	}

	public List<Item> getItems()
	{
		return items;
	}
}