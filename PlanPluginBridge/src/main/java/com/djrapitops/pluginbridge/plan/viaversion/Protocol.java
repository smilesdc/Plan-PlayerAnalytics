/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.djrapitops.pluginbridge.plan.viaversion;

/**
 * Contains static method for formatting protocol version into readable form.
 *
 * @author Rsl1122
 */
public class Protocol {

    /**
     * http://wiki.vg/Protocol_version_numbers
     *
     * @param protocolVersion ProtocolVersion
     * @return Minecraft Version (estimate)
     */
    public static String getMCVersion(int protocolVersion) {
        switch (protocolVersion) {
            case 335:
                return "1.12";
            case 316:
                return "1.11.2";
            case 315:
                return "1.11";
            case 210:
                return "1.10.2";
            case 110:
                return "1.9.4";
            case 109:
                return "1.9.2";
            case 107:
                return "1.9";
            case 47:
                return "1.8.9";
            case 5:
                return "1.7.10";
            case 4:
                return "1.7.5";
            default:
                return "Unknown ProtocolVersion: " + protocolVersion;
        }
    }
}
