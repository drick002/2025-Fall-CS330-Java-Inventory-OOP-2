package edu.odu.cs.cs330.items;

import java.util.Scanner;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal"
})
public class Armour extends Equippable {
    /**
     * The amount of damage that can be negated.
     */
    protected int defense;

    /**
     * Default to a armour with a defense of zero.
     */
    public Armour()
    {
        super();

        this.defense = 0;
    }

    /**
     * Duplicate a piece of armour.
     *
     * @param src armour to duplicate
     */
    public Armour(Armour src)
    {
        super(src.name);

        this.durability = src.durability;
        // Copt the remaining fields (data members)
        this.material = src.getMaterial();
        this.modifier = src.getModifier();
        this.modifierLevel = src.modifierLevel;
        this.element = src.getElement();
        this.defense = src.defense;
        this.name = src.getName();
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense()
    {
        return this.defense;
    }

    /**
     * Update defense.
     *
     * @param def replacement defense
     */
    public void setDefense(int def)
    {
        this.defense = def;
    }

    @Override
    public boolean isStackable()
    {
        return false;
    }

    /**
     * Read Armour attributes.
     */
    @Override
    public void read(Scanner snr)
    {
        super.name = snr.next();

        // Use snr.next() and snr.nextInt() to read in values remaining fields
        super.material = snr.next();
        super.durability = snr.nextInt();
        defense = snr.nextInt();
        super.modifier = snr.next();
        super.modifierLevel = snr.nextInt();
        super.element = snr.next();
    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Item clone()
    {
        // Replace the return
        Armour copy = new Armour(this);
        return copy;
    }

    /**
     * Check for logical equivalence--based on name, material, modifier, and
     * element.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Armour)) {
            return false;
        }

        Armour rhsItem = (Armour) rhs;

        // Replace this return
        return this.name.equals(rhsItem.name)
            && this.material.equals(rhsItem.material)
            && this.modifier.equals(rhsItem.modifier)
            && this.element.equals(rhsItem.element);
    }

    /**
     * Generate a hash code by adding the name, material, modifier, and element
     * hash codes.
     */
    @Override
    public int hashCode()
    {
        // Replace this return
        return name.hashCode() + material.hashCode() + modifier.hashCode() + element.hashCode();
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {
        return String.join(
            System.lineSeparator(),
            String.format("  Nme: %s", super.getName()),
            String.format("  Dur: %d", super.getDurability()),
            String.format("  Def: %d", defense),
            String.format("  Mtl: %s", super.getMaterial()),
            String.format("  Mdr: %s (Lvl %d)", super.getModifier(), super.getModifierLevel()),
            String.format("  Emt: %s", super.getElement()),       
            ""
        );
    }
}




