package mekanism.common.item;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mekanism.api.EnumColor;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

/**
 * Item class for handling multiple transmitter IDs.
 * 0: Pressurized Tube
 * 1: Universal Cable
 * 2: Mechanical Pipe
 * 3: Logistical Transporter
 * 4: Restrictive Transporter
 * 5: Diversion Transporter
 * @author AidanBrady
 *
 */
public class ItemBlockTransmitter extends ItemBlock
{
	public Block metaBlock;
	
	public ItemBlockTransmitter(int id, Block block)
	{
		super(id);
		metaBlock = block;
		setHasSubtypes(true);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer entityplayer, List list, boolean flag)
	{
		if(!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
		{
			list.add("Hold " + EnumColor.AQUA + "shift" + EnumColor.GREY + " for details.");
		}
		else {
			if(itemstack.getItemDamage() == 0)
			{
				list.add(EnumColor.DARK_GREY + "Capable of transferring:");
				list.add("- " + EnumColor.PURPLE + "O " + EnumColor.GREY + "(Oxygen)");
				list.add("- " + EnumColor.PURPLE + "H " + EnumColor.GREY + "(Hydrogen)");
			}
			else if(itemstack.getItemDamage() == 1)
			{
				list.add(EnumColor.DARK_GREY + "Capable of transferring:");
				list.add("- " + EnumColor.PURPLE + "RF " + EnumColor.GREY + "(ThermalExpansion)");
				list.add("- " + EnumColor.PURPLE + "EU " + EnumColor.GREY +  "(IndustrialCraft)");
				list.add("- " + EnumColor.PURPLE + "MJ " + EnumColor.GREY +  "(BuildCraft)");
				list.add("- " + EnumColor.PURPLE + "Joules " + EnumColor.GREY +  "(Mekanism, UE)");
			}
			else if(itemstack.getItemDamage() == 2)
			{
				list.add(EnumColor.DARK_GREY + "Capable of transferring:");
				list.add("- " + EnumColor.PURPLE + "mB " + EnumColor.GREY + "(FluidRegistry)");
			}
			else if(itemstack.getItemDamage() == 3)
			{
				list.add(EnumColor.DARK_GREY + "Capable of transferring:");
				list.add("- " + EnumColor.PURPLE + "Items (universal)");
				list.add("- " + EnumColor.PURPLE + "Blocks (universal)");
			}
			else if(itemstack.getItemDamage() == 4)
			{
				list.add(EnumColor.DARK_GREY + "Capable of transferring:");
				list.add("- " + EnumColor.PURPLE + "Items (universal)");
				list.add("- " + EnumColor.PURPLE + "Blocks (universal)");
				list.add("- " + EnumColor.DARK_RED + "Only used if no other paths available");
			}
			else if(itemstack.getItemDamage() == 5)
			{
				list.add(EnumColor.DARK_GREY + "Capable of transferring:");
				list.add("- " + EnumColor.PURPLE + "Items (universal)");
				list.add("- " + EnumColor.PURPLE + "Blocks (universal)");
				list.add("- " + EnumColor.DARK_RED + "Controllable by redstone");
			}
		}
	}
	
	@Override
	public int getMetadata(int i)
	{
		return i;
	}
	
	@Override
	public Icon getIconFromDamage(int i)
	{
		return metaBlock.getIcon(2, i);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		String name = "";
		
		switch(itemstack.getItemDamage())
		{
			case 0:
				name = "PressurizedTube";
				break;
			case 1:
				name = "UniversalCable";
				break;
			case 2:
				name = "MechanicalPipe";
				break;
			case 3:
				name = "LogisticalTransporter";
				break;
			case 4:
				name = "RestrictiveTransporter";
				break;
			case 5:
				name = "DiversionTransporter";
				break;
			default:
				name = "Unknown";
				break;
		}
		
		return getUnlocalizedName() + "." + name;
	}
}