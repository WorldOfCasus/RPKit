/*
 * This file is generated by jOOQ.
*/
package com.rpkit.travel.bukkit.database.jooq.rpkit;


import com.rpkit.travel.bukkit.database.jooq.rpkit.tables.RpkitWarp;
import com.rpkit.travel.bukkit.database.jooq.rpkit.tables.records.RpkitWarpRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>rpkit</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<RpkitWarpRecord, Integer> IDENTITY_RPKIT_WARP = Identities0.IDENTITY_RPKIT_WARP;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<RpkitWarpRecord> KEY_RPKIT_WARP_PRIMARY = UniqueKeys0.KEY_RPKIT_WARP_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<RpkitWarpRecord, Integer> IDENTITY_RPKIT_WARP = createIdentity(RpkitWarp.RPKIT_WARP, RpkitWarp.RPKIT_WARP.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<RpkitWarpRecord> KEY_RPKIT_WARP_PRIMARY = createUniqueKey(RpkitWarp.RPKIT_WARP, "KEY_rpkit_warp_PRIMARY", RpkitWarp.RPKIT_WARP.ID);
    }
}
