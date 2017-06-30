package com.djrapitops.pluginbridge.plan.viaversion;

import com.djrapitops.pluginbridge.plan.vault.*;
import com.djrapitops.pluginbridge.plan.FakeOfflinePlayer;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.com.djrapitops.plan.Log;
import main.java.com.djrapitops.plan.Plan;
import main.java.com.djrapitops.plan.data.UserData;
import main.java.com.djrapitops.plan.data.additional.AnalysisType;
import main.java.com.djrapitops.plan.data.additional.PluginData;
import main.java.com.djrapitops.plan.utilities.FormatUtils;
import net.milkbowl.vault.economy.Economy;
import static org.bukkit.Bukkit.getOfflinePlayer;
import org.bukkit.OfflinePlayer;

/**
 * PluginData class for Vault-plugin.
 *
 * Registered to the plugin by VaultHook
 *
 * Gives Total Balance Double as value.
 *
 * @author Rsl1122
 * @since 3.1.0
 * @see VaultHook
 */
public class ViaVersionVersion extends PluginData {

    private final ProtocolTable table;

    /**
     * Class Constructor, sets the parameters of the PluginData object.
     *
     * @param table ProtocolTable where protocol versions are stored.
     */
    public ViaVersionVersion(ProtocolTable table) {
        super("ViaVersion", "version");
        this.table = table;
        super.setAnalysisOnly(false);
        super.setIcon("signal");
        super.setPrefix("Last Join Version: ");
    }

    @Override
    public String getHtmlReplaceValue(String modifierPrefix, UUID uuid) {
        try {
            int protocolVersion = table.getProtocolVersion(uuid);
            if (protocolVersion == -1) {
                parseContainer(modifierPrefix, "Not Yet Known");
            }
            return parseContainer(modifierPrefix, Protocol.getMCVersion(protocolVersion));
        } catch (SQLException ex) {
            Log.toLog(this.getClass().getName(), ex);
            return parseContainer(modifierPrefix, ex.toString());
        }        
    }

    @Override
    public Serializable getValue(UUID uuid) {
        return -1;
    }

}
