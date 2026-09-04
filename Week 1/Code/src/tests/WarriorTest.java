package tests;

import com.nhlstenden.kingdomsandquests.characters.Mage;
import com.nhlstenden.kingdomsandquests.characters.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WarriorTest
{

	@Test
	public void useSpecialAbility_called_setsNextAttackBoostedTrue()
	{
		Warrior warrior = new Warrior("Conan", 10, 5);
		warrior.useSpecialAbility();
		assertTrue(warrior.isNextAttackBoosted());
	}

	@Test
	public void attack_withoutBoost_dealsBaseDamage()
	{
		Warrior warrior = new Warrior("Conan", 10, 5);
		Mage target = new Mage("Merlin", 5, 3);

		warrior.attack(target);

		assertEquals(7, warrior.getLastDamageDealt());
	}

	@Test
	public void attack_withBoost_dealsBoostedDamage()
	{
		Warrior warrior = new Warrior("Conan", 10, 5);
		Mage target = new Mage("Merlin", 5, 3);

		warrior.useSpecialAbility();
		warrior.attack(target);

		assertEquals(12, warrior.getLastDamageDealt());
	}

	@Test
	public void attack_withBoost_clearsBoostAfterUse()
	{
		Warrior warrior = new Warrior("Conan", 10, 5);
		Mage target = new Mage("Merlin", 5, 3);

		warrior.useSpecialAbility();
		warrior.attack(target);

		assertFalse(warrior.isNextAttackBoosted());
	}

	@Test
	public void attack_boostConsumedOnce_secondAttackUsesBaseDamage()
	{
		Warrior warrior = new Warrior("Conan", 10, 5);
		Mage target = new Mage("Merlin", 5, 3);

		warrior.useSpecialAbility();
		warrior.attack(target);
		warrior.attack(target);

		assertEquals(7, warrior.getLastDamageDealt());
	}

	@Test
	public void attack_targetDefending_halvesDamage()
	{
		Warrior warrior = new Warrior("Conan", 10, 5);
		Mage target = new Mage("Merlin", 5, 3);

		target.defend();
		warrior.attack(target);

		assertEquals(2, warrior.getLastDamageDealt());
	}

	@Test
	public void attack_targetDefending_clearsTargetDefendingFlag()
	{
		Warrior warrior = new Warrior("Conan", 10, 5);
		Mage target = new Mage("Merlin", 5, 3);

		target.defend();
		warrior.attack(target);

		assertFalse(target.isDefending());
	}
}