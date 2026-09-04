package tests;

import com.nhlstenden.kingdomsandquests.characters.Mage;
import com.nhlstenden.kingdomsandquests.characters.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MageTest
{

	@Test
	public void useSpecialAbility_called_increasesDefenseByBoostAmount()
	{
		Mage mage = new Mage("Merlin", 5, 3);
		mage.useSpecialAbility();
		assertEquals(8, mage.getDefense());
	}

	@Test
	public void useSpecialAbility_calledTwice_stacksBoost()
	{
		Mage mage = new Mage("Merlin", 5, 3);
		mage.useSpecialAbility();
		mage.useSpecialAbility();
		assertEquals(13, mage.getDefense());
	}

	@Test
	public void attack_noSpecialAbilityUsed_dealsBaseDamage()
	{
		Mage mage = new Mage("Merlin", 5, 3);
		Warrior target = new Warrior("Conan", 10, 4);

		mage.attack(target);

		assertEquals(1, mage.getLastDamageDealt());
	}

	@Test
	public void attack_targetDefending_halvesDamage()
	{
		Mage mage = new Mage("Merlin", 5, 3);
		Warrior target = new Warrior("Conan", 10, 1);

		target.defend();
		mage.attack(target);

		assertEquals(1, mage.getLastDamageDealt());
	}
}
