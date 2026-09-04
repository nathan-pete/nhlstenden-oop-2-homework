package tests;

import com.nhlstenden.kingdomsandquests.Item;
import com.nhlstenden.kingdomsandquests.Quest;
import com.nhlstenden.kingdomsandquests.quests.NormalQuest;
import com.nhlstenden.kingdomsandquests.quests.SpecialQuest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestTest
{

	@Test
	public void getRequiredXP_difficultyThree_returnsThirty()
	{
		Quest quest = new NormalQuest("Slay the rat", 20, 3);
		assertEquals(30, quest.getRequiredXP());
	}

	@Test
	public void getRequiredXP_difficultyZero_returnsZero()
	{
		Quest quest = new NormalQuest("Tutorial quest", 10, 0);
		assertEquals(0, quest.getRequiredXP());
	}

	@Test
	public void getXpReward_normalQuest_returnsConstructorValue()
	{
		Quest quest = new NormalQuest("Slay the rat", 20, 3);
		assertEquals(20, quest.getXpReward());
	}

	@Test
	public void getTitle_normalQuest_returnsConstructorValue()
	{
		Quest quest = new NormalQuest("Slay the rat", 20, 3);
		assertEquals("Slay the rat", quest.getTitle());
	}

	@Test
	public void getItemReward_specialQuest_returnsConstructorValue()
	{
		Item item = new Item("Ancient shield");
		SpecialQuest quest = new SpecialQuest("Defeat the dragon", 50, 8, item);
		assertEquals(item, quest.getItemReward());
	}

	@Test
	public void getRequiredXP_specialQuest_returnsDifficultyTimesTen()
	{
		Item item = new Item("Ancient shield");
		SpecialQuest quest = new SpecialQuest("Defeat the dragon", 50, 8, item);
		assertEquals(80, quest.getRequiredXP());
	}
}