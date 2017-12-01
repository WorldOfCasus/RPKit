/*
 * This file is generated by jOOQ.
*/
package com.rpkit.characters.bukkit.database.jooq.rpkit.tables;


import com.rpkit.characters.bukkit.database.jooq.rpkit.Indexes;
import com.rpkit.characters.bukkit.database.jooq.rpkit.Keys;
import com.rpkit.characters.bukkit.database.jooq.rpkit.Rpkit;
import com.rpkit.characters.bukkit.database.jooq.rpkit.tables.records.RpkitNewCharacterCooldownRecord;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitNewCharacterCooldown extends TableImpl<RpkitNewCharacterCooldownRecord> {

    private static final long serialVersionUID = 688614246;

    /**
     * The reference instance of <code>rpkit.rpkit_new_character_cooldown</code>
     */
    public static final RpkitNewCharacterCooldown RPKIT_NEW_CHARACTER_COOLDOWN = new RpkitNewCharacterCooldown();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitNewCharacterCooldownRecord> getRecordType() {
        return RpkitNewCharacterCooldownRecord.class;
    }

    /**
     * The column <code>rpkit.rpkit_new_character_cooldown.id</code>.
     */
    public final TableField<RpkitNewCharacterCooldownRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit.rpkit_new_character_cooldown.profile_id</code>.
     */
    public final TableField<RpkitNewCharacterCooldownRecord, Integer> PROFILE_ID = createField("profile_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>rpkit.rpkit_new_character_cooldown.cooldown_timestamp</code>.
     */
    public final TableField<RpkitNewCharacterCooldownRecord, Date> COOLDOWN_TIMESTAMP = createField("cooldown_timestamp", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * Create a <code>rpkit.rpkit_new_character_cooldown</code> table reference
     */
    public RpkitNewCharacterCooldown() {
        this(DSL.name("rpkit_new_character_cooldown"), null);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_new_character_cooldown</code> table reference
     */
    public RpkitNewCharacterCooldown(String alias) {
        this(DSL.name(alias), RPKIT_NEW_CHARACTER_COOLDOWN);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_new_character_cooldown</code> table reference
     */
    public RpkitNewCharacterCooldown(Name alias) {
        this(alias, RPKIT_NEW_CHARACTER_COOLDOWN);
    }

    private RpkitNewCharacterCooldown(Name alias, Table<RpkitNewCharacterCooldownRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitNewCharacterCooldown(Name alias, Table<RpkitNewCharacterCooldownRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Rpkit.RPKIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.RPKIT_NEW_CHARACTER_COOLDOWN_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<RpkitNewCharacterCooldownRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RPKIT_NEW_CHARACTER_COOLDOWN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RpkitNewCharacterCooldownRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_NEW_CHARACTER_COOLDOWN_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RpkitNewCharacterCooldownRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitNewCharacterCooldownRecord>>asList(Keys.KEY_RPKIT_NEW_CHARACTER_COOLDOWN_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitNewCharacterCooldown as(String alias) {
        return new RpkitNewCharacterCooldown(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitNewCharacterCooldown as(Name alias) {
        return new RpkitNewCharacterCooldown(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitNewCharacterCooldown rename(String name) {
        return new RpkitNewCharacterCooldown(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitNewCharacterCooldown rename(Name name) {
        return new RpkitNewCharacterCooldown(name, null);
    }
}
