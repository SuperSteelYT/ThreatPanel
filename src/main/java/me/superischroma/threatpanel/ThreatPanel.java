package me.superischroma.threatpanel;

import me.superischroma.threatpanel.command.ThreatPanelCommand;
import me.superischroma.threatpanel.util.TPLog;
import net.pravian.aero.plugin.AeroPlugin;
import org.bukkit.command.CommandMap;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jax
 */
public class ThreatPanel extends AeroPlugin<ThreatPanel>
{
    public static CommandMap map;
    // Enable
    @Override
    public void enable()
    {
        this.getCommand("togglemod").setExecutor(new ThreatPanelCommand());
        TPLog.info("Enabled");
    }
    // Disable
    @Override
    public void disable()
    {
        TPLog.info("Disabled");
    }

    // For those who are worthy
    public static final List<String> SPECIAL = Arrays.asList
    (
        /* Super_ */ "8a9cd5ad-5814-3593-a2cd-46f5ae73e3ed",
        /* seaoysters */ /* No UUID implemented yet. */ "",
        /* OxLemonxO */ "528bb777-5518-3de4-b125-e13b95fef2de",
        /* _Fleek_ */ "68460026-73ed-394f-91e8-59999879d52d"
    );

}
