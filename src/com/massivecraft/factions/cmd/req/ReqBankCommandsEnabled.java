package com.massivecraft.factions.cmd.req;

import org.bukkit.command.CommandSender;

import com.massivecraft.factions.entity.UConf;
import com.massivecraft.mcore.cmd.MCommand;
import com.massivecraft.mcore.cmd.req.ReqAbstract;
import com.massivecraft.mcore.util.Txt;

public class ReqBankCommandsEnabled extends ReqAbstract
{
	private static final long serialVersionUID = 1L;
	
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static ReqBankCommandsEnabled i = new ReqBankCommandsEnabled();
	public static ReqBankCommandsEnabled get() { return i; }
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public boolean apply(CommandSender sender, MCommand command)
	{
		return UConf.get(sender).econEnabled && UConf.get(sender).bankEnabled;
	}
	
	@Override
	public String createErrorMessage(CommandSender sender, MCommand command)
	{
		UConf uconf = UConf.get(sender);
		if (!uconf.bankEnabled)
		{
			return Txt.parse("<b>Faction banks are disabled in the <h>%s <b>universe.", uconf.getUniverse());
		}
		return Txt.parse("<b>Faction economy features are disabled in the <h>%s <b>universe.", uconf.getUniverse());
	}
	
}
