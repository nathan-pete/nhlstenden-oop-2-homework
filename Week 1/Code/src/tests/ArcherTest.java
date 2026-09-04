package tests;

import com.nhlstenden.kingdomsandquests.characters.Archer;
import com.nhlstenden.kingdomsandquests.characters.Mage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArcherTest
{

	@Test
	public void useSpecialAbility_called_setsNextAttackDoubledTrue()
	{
		Archer archer = new Archer("Legolas", 10, 4);
		archer.useSpecialAbility();
		assertTrue(archer.isNextAttackDoubled());
	}

	@Test
	public void attack_withoutDouble_dealsBaseDamage()
	{
		Archer archer = new Archer("Legolas", 10, 4);
		Mage target = new Mage("Merlin", 5, 3);

		archer.attack(target);

		assertEquals(7, archer.getLastDamageDealt());
	}

	@Test
	public void attack_withDouble_dealsDoubledDamage()
	{
		Archer archer = new Archer("Legolas", 10, 4);
		Mage target = new Mage("Merlin", 5, 3);

		archer.useSpecialAbility();
		archer.attack(target);

		assertEquals(17, archer.getLastDamageDealt());
	}

	@Test
	public void attack_withDouble_clearsDoubleAfterUse()
	{
		Archer archer = new Archer("Legolas", 10, 4);
		Mage target = new Mage("Merlin", 5, 3);

		archer.useSpecialAbility();
		archer.attack(target);

		assertFalse(archer.isNextAttackDoubled());
	}

	@Test
	public void attack_doubleConsumedOnce_secondAttackUsesBaseDamage()
	{
		Archer archer = new Archer("Legolas", 10, 4);
		Mage target = new Mage("Merlin", 5, 3);

		archer.useSpecialAbility();
		archer.attack(target);
		archer.attack(target);

		assertEquals(7, archer.getLastDamageDealt());
	}

	@Test
	public void attack_targetDefending_halvesDamage()
	{
		Archer archer = new Archer("Legolas", 10, 4);
		Mage target = new Mage("Merlin", 5, 3);

		target.defend();
		archer.attack(target);

		assertEquals(2, archer.getLastDamageDealt());
	}

	@Test
	public void attack_targetDefendingWithDouble_halvesDoubledDamage()
	{
		Archer archer = new Archer("Legolas", 10, 4);
		Mage target = new Mage("Merlin", 5, 3);

		target.defend();
		archer.useSpecialAbility();
		archer.attack(target);

		assertEquals(7, archer.getLastDamageDealt());
	}
}