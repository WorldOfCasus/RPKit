/*
 * Copyright 2020 Ren Binden
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * This file is generated by jOOQ.
 */
package com.rpkit.selection.bukkit.database.jooq;


import com.rpkit.selection.bukkit.database.jooq.tables.RpkitSelection;
import com.rpkit.selection.bukkit.database.jooq.tables.records.RpkitSelectionRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>rpkit_selection</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<RpkitSelectionRecord> KEY_RPKIT_SELECTION_PRIMARY = UniqueKeys0.KEY_RPKIT_SELECTION_PRIMARY;
    public static final UniqueKey<RpkitSelectionRecord> KEY_RPKIT_SELECTION_RPKIT_SELECTION_MINECRAFT_PROFILE_ID_UINDEX = UniqueKeys0.KEY_RPKIT_SELECTION_RPKIT_SELECTION_MINECRAFT_PROFILE_ID_UINDEX;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<RpkitSelectionRecord> KEY_RPKIT_SELECTION_PRIMARY = Internal.createUniqueKey(RpkitSelection.RPKIT_SELECTION_, "KEY_rpkit_selection_PRIMARY", new TableField[] { RpkitSelection.RPKIT_SELECTION_.MINECRAFT_PROFILE_ID }, true);
        public static final UniqueKey<RpkitSelectionRecord> KEY_RPKIT_SELECTION_RPKIT_SELECTION_MINECRAFT_PROFILE_ID_UINDEX = Internal.createUniqueKey(RpkitSelection.RPKIT_SELECTION_, "KEY_rpkit_selection_rpkit_selection_minecraft_profile_id_uindex", new TableField[] { RpkitSelection.RPKIT_SELECTION_.MINECRAFT_PROFILE_ID }, true);
    }
}
