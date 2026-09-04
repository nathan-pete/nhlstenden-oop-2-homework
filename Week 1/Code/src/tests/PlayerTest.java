package tests;

import com.nhlstenden.kingdomsandquests.Item;
import com.nhlstenden.kingdomsandquests.Player;
import com.nhlstenden.kingdomsandquests.Quest;
import com.nhlstenden.kingdomsandquests.characters.Warrior;
import com.nhlstenden.kingdomsandquests.quests.NormalQuest;
import com.nhlstenden.kingdomsandquests.quests.SpecialQuest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest
{

	@Test
	public void constructor_newPlayer_startsAtLevelOneWithZeroXP()
	{
		Player player = new Player("Nate", new Warrior("Conan", 10, 5));
		assertEquals(1, player.getLevel());
		assertEquals(0, player.getTotalXP());
		assertTrue(player.getItems().isEmpty());
	}

	@Test
	public void viewAvailableQuests_playerLacksXP_excludesQuest()
	{
		Player player = new Player("Nate", new Warrior("Conan", 10, 5));
		Quest quest = new NormalQuest("Kill rats", 20, 1);
		player.addAvailableQuest(quest);

		List<Quest> playable = player.viewAvailableQuests();

		assertTrue(playable.isEmpty());
	}

	@Test
	public void viewAvailableQuests_playerHasEnoughXP_includesQuest()
	{
		Player player = new Player("Nate", new Warrior("Conan", 10, 5));
		Quest tutorial = new NormalQuest("Tutorial", 30, 0);
		Quest killRats = new NormalQuest("Kill rats", 20, 1);
		player.addAvailableQuest(tutorial);
		player.addAvailableQuest(killRats);

		player.playQuest(tutorial);
		List<Quest> playable = player.viewAvailableQuests();

		assertTrue(playable.contains(killRats));
	}

	@Test
	public void playQuest_notEnoughXP_doesNotAddXP()
	{
		Player player = new Player("Nate", new Warrior("Conan", 10, 5));
		Quest quest = new NormalQuest("Defeat the dragon", 50, 5);

		player.playQuest(quest);

		assertEquals(0, player.getTotalXP());
	}

	@Test
	public void playQuest_enoughXP_addsXPReward()
	{
		Player player = new Player("Nate", new Warrior("Conan", 10, 5));
		Quest quest = new NormalQuest("Tutorial", 15, 0);

		player.playQuest(quest);

		assertEquals(15, player.getTotalXP());
	}

	@Test
	public void playQuest_specialQuest_addsItemToInventory()
	{
		Player player = new Player("Nate", new Warrior("Conan", 10, 5));
		Item item = new Item("Ancient shield");
		Quest quest = new SpecialQuest("Defeat the dragon", 15, 0, item);

		player.playQuest(quest);

		assertTrue(player.getItems().contains(item));
	}

	@Test
	public void playQuest_normalQuest_doesNotAddItem()
	{
		Player player = new Player("Nate", new Warrior("Conan", 10, 5));
		Quest quest = new NormalQuest("Tutorial", 15, 0);

		player.playQuest(quest);

		assertTrue(player.getItems().isEmpty());
	}

	@Test
	public void playQuest_reachesTwoHundredXP_triggersLevelUp()
	{
		Player player = new Player("Nate", new Warrior("Conan", 10, 5));
		Quest quest = new NormalQuest("Grand quest", 250, 0);

		player.playQuest(quest);

		assertEquals(2, player.getLevel());
		assertEquals(50, player.getTotalXP());
	}

	@Test
	public void levelUp_belowThreshold_doesNotChangeLevel()
	{
		Player player = new Player("Nate", new Warrior("Conan", 10, 5));
		player.levelUp();
		assertEquals(1, player.getLevel());
	}

	@Test
	public void playQuest_exactlyEnoughXP_isAllowed()
	{
		Player player = new Player("Nate", new Warrior("Conan", 10, 5));
		Quest tutorial = new NormalQuest("Tutorial", 10, 0);
		Quest nextQuest = new NormalQuest("Kill rats", 20, 1);
		player.playQuest(tutorial);

		player.playQuest(nextQuest);

		assertEquals(30, player.getTotalXP());
	}
}