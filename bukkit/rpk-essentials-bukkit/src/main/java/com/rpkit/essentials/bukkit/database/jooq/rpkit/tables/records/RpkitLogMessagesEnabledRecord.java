/*
 * This file is generated by jOOQ.
*/
package com.rpkit.essentials.bukkit.database.jooq.rpkit.tables.records;


import com.rpkit.essentials.bukkit.database.jooq.rpkit.tables.RpkitLogMessagesEnabled;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitLogMessagesEnabledRecord extends UpdatableRecordImpl<RpkitLogMessagesEnabledRecord> implements Record3<Integer, Integer, Byte> {

    private static final long serialVersionUID = -1632204019;

    /**
     * Setter for <code>rpkit.rpkit_log_messages_enabled.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_log_messages_enabled.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit.rpkit_log_messages_enabled.minecraft_profile_id</code>.
     */
    public void setMinecraftProfileId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_log_messages_enabled.minecraft_profile_id</code>.
     */
    public Integer getMinecraftProfileId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rpkit.rpkit_log_messages_enabled.enabled</code>.
     */
    public void setEnabled(Byte value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_log_messages_enabled.enabled</code>.
     */
    public Byte getEnabled() {
        return (Byte) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Byte> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Byte> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return RpkitLogMessagesEnabled.RPKIT_LOG_MESSAGES_ENABLED.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return RpkitLogMessagesEnabled.RPKIT_LOG_MESSAGES_ENABLED.MINECRAFT_PROFILE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field3() {
        return RpkitLogMessagesEnabled.RPKIT_LOG_MESSAGES_ENABLED.ENABLED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getMinecraftProfileId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value3() {
        return getEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitLogMessagesEnabledRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitLogMessagesEnabledRecord value2(Integer value) {
        setMinecraftProfileId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitLogMessagesEnabledRecord value3(Byte value) {
        setEnabled(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitLogMessagesEnabledRecord values(Integer value1, Integer value2, Byte value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitLogMessagesEnabledRecord
     */
    public RpkitLogMessagesEnabledRecord() {
        super(RpkitLogMessagesEnabled.RPKIT_LOG_MESSAGES_ENABLED);
    }

    /**
     * Create a detached, initialised RpkitLogMessagesEnabledRecord
     */
    public RpkitLogMessagesEnabledRecord(Integer id, Integer minecraftProfileId, Byte enabled) {
        super(RpkitLogMessagesEnabled.RPKIT_LOG_MESSAGES_ENABLED);

        set(0, id);
        set(1, minecraftProfileId);
        set(2, enabled);
    }
}
