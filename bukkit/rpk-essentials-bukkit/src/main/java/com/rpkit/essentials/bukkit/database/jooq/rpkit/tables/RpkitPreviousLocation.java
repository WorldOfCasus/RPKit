/*
 * This file is generated by jOOQ.
*/
package com.rpkit.essentials.bukkit.database.jooq.rpkit.tables;


import com.rpkit.essentials.bukkit.database.jooq.rpkit.Indexes;
import com.rpkit.essentials.bukkit.database.jooq.rpkit.Keys;
import com.rpkit.essentials.bukkit.database.jooq.rpkit.Rpkit;
import com.rpkit.essentials.bukkit.database.jooq.rpkit.tables.records.RpkitPreviousLocationRecord;

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
public class RpkitPreviousLocation extends TableImpl<RpkitPreviousLocationRecord> {

    private static final long serialVersionUID = 1068151676;

    /**
     * The reference instance of <code>rpkit.rpkit_previous_location</code>
     */
    public static final RpkitPreviousLocation RPKIT_PREVIOUS_LOCATION = new RpkitPreviousLocation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitPreviousLocationRecord> getRecordType() {
        return RpkitPreviousLocationRecord.class;
    }

    /**
     * The column <code>rpkit.rpkit_previous_location.id</code>.
     */
    public final TableField<RpkitPreviousLocationRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit.rpkit_previous_location.minecraft_profile_id</code>.
     */
    public final TableField<RpkitPreviousLocationRecord, Integer> MINECRAFT_PROFILE_ID = createField("minecraft_profile_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>rpkit.rpkit_previous_location.world</code>.
     */
    public final TableField<RpkitPreviousLocationRecord, String> WORLD = createField("world", org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>rpkit.rpkit_previous_location.x</code>.
     */
    public final TableField<RpkitPreviousLocationRecord, Double> X = createField("x", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>rpkit.rpkit_previous_location.y</code>.
     */
    public final TableField<RpkitPreviousLocationRecord, Double> Y = createField("y", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>rpkit.rpkit_previous_location.z</code>.
     */
    public final TableField<RpkitPreviousLocationRecord, Double> Z = createField("z", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>rpkit.rpkit_previous_location.yaw</code>.
     */
    public final TableField<RpkitPreviousLocationRecord, Double> YAW = createField("yaw", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>rpkit.rpkit_previous_location.pitch</code>.
     */
    public final TableField<RpkitPreviousLocationRecord, Double> PITCH = createField("pitch", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * Create a <code>rpkit.rpkit_previous_location</code> table reference
     */
    public RpkitPreviousLocation() {
        this(DSL.name("rpkit_previous_location"), null);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_previous_location</code> table reference
     */
    public RpkitPreviousLocation(String alias) {
        this(DSL.name(alias), RPKIT_PREVIOUS_LOCATION);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_previous_location</code> table reference
     */
    public RpkitPreviousLocation(Name alias) {
        this(alias, RPKIT_PREVIOUS_LOCATION);
    }

    private RpkitPreviousLocation(Name alias, Table<RpkitPreviousLocationRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitPreviousLocation(Name alias, Table<RpkitPreviousLocationRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.RPKIT_PREVIOUS_LOCATION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<RpkitPreviousLocationRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RPKIT_PREVIOUS_LOCATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RpkitPreviousLocationRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_PREVIOUS_LOCATION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RpkitPreviousLocationRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitPreviousLocationRecord>>asList(Keys.KEY_RPKIT_PREVIOUS_LOCATION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitPreviousLocation as(String alias) {
        return new RpkitPreviousLocation(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitPreviousLocation as(Name alias) {
        return new RpkitPreviousLocation(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitPreviousLocation rename(String name) {
        return new RpkitPreviousLocation(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitPreviousLocation rename(Name name) {
        return new RpkitPreviousLocation(name, null);
    }
}
