/*
 * This file is generated by jOOQ.
 */
package com.rpkit.classes.bukkit.database.jooq.tables.records;


import com.rpkit.classes.bukkit.database.jooq.tables.RpkitCharacterClass;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitCharacterClassRecord extends UpdatableRecordImpl<RpkitCharacterClassRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>rpkit_classes.rpkit_character_class.character_id</code>.
     */
    public void setCharacterId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit_classes.rpkit_character_class.character_id</code>.
     */
    public Integer getCharacterId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit_classes.rpkit_character_class.class_name</code>.
     */
    public void setClassName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit_classes.rpkit_character_class.class_name</code>.
     */
    public String getClassName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RpkitCharacterClass.RPKIT_CHARACTER_CLASS.CHARACTER_ID;
    }

    @Override
    public Field<String> field2() {
        return RpkitCharacterClass.RPKIT_CHARACTER_CLASS.CLASS_NAME;
    }

    @Override
    public Integer component1() {
        return getCharacterId();
    }

    @Override
    public String component2() {
        return getClassName();
    }

    @Override
    public Integer value1() {
        return getCharacterId();
    }

    @Override
    public String value2() {
        return getClassName();
    }

    @Override
    public RpkitCharacterClassRecord value1(Integer value) {
        setCharacterId(value);
        return this;
    }

    @Override
    public RpkitCharacterClassRecord value2(String value) {
        setClassName(value);
        return this;
    }

    @Override
    public RpkitCharacterClassRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitCharacterClassRecord
     */
    public RpkitCharacterClassRecord() {
        super(RpkitCharacterClass.RPKIT_CHARACTER_CLASS);
    }

    /**
     * Create a detached, initialised RpkitCharacterClassRecord
     */
    public RpkitCharacterClassRecord(Integer characterId, String className) {
        super(RpkitCharacterClass.RPKIT_CHARACTER_CLASS);

        setCharacterId(characterId);
        setClassName(className);
    }
}
