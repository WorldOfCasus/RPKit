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
package com.rpkit.economy.bukkit.database.jooq.tables;


import com.rpkit.economy.bukkit.database.jooq.Keys;
import com.rpkit.economy.bukkit.database.jooq.RpkitEconomy;
import com.rpkit.economy.bukkit.database.jooq.tables.records.RpkitMoneyHiddenRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row1;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitMoneyHidden extends TableImpl<RpkitMoneyHiddenRecord> {

    private static final long serialVersionUID = 1673682434;

    /**
     * The reference instance of <code>rpkit_economy.rpkit_money_hidden</code>
     */
    public static final RpkitMoneyHidden RPKIT_MONEY_HIDDEN = new RpkitMoneyHidden();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitMoneyHiddenRecord> getRecordType() {
        return RpkitMoneyHiddenRecord.class;
    }

    /**
     * The column <code>rpkit_economy.rpkit_money_hidden.character_id</code>.
     */
    public final TableField<RpkitMoneyHiddenRecord, Integer> CHARACTER_ID = createField(DSL.name("character_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>rpkit_economy.rpkit_money_hidden</code> table reference
     */
    public RpkitMoneyHidden() {
        this(DSL.name("rpkit_money_hidden"), null);
    }

    /**
     * Create an aliased <code>rpkit_economy.rpkit_money_hidden</code> table reference
     */
    public RpkitMoneyHidden(String alias) {
        this(DSL.name(alias), RPKIT_MONEY_HIDDEN);
    }

    /**
     * Create an aliased <code>rpkit_economy.rpkit_money_hidden</code> table reference
     */
    public RpkitMoneyHidden(Name alias) {
        this(alias, RPKIT_MONEY_HIDDEN);
    }

    private RpkitMoneyHidden(Name alias, Table<RpkitMoneyHiddenRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitMoneyHidden(Name alias, Table<RpkitMoneyHiddenRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> RpkitMoneyHidden(Table<O> child, ForeignKey<O, RpkitMoneyHiddenRecord> key) {
        super(child, key, RPKIT_MONEY_HIDDEN);
    }

    @Override
    public Schema getSchema() {
        return RpkitEconomy.RPKIT_ECONOMY;
    }

    @Override
    public UniqueKey<RpkitMoneyHiddenRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_MONEY_HIDDEN_PRIMARY;
    }

    @Override
    public List<UniqueKey<RpkitMoneyHiddenRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitMoneyHiddenRecord>>asList(Keys.KEY_RPKIT_MONEY_HIDDEN_PRIMARY, Keys.KEY_RPKIT_MONEY_HIDDEN_RPKIT_MONEY_HIDDEN_CHARACTER_ID_UINDEX);
    }

    @Override
    public RpkitMoneyHidden as(String alias) {
        return new RpkitMoneyHidden(DSL.name(alias), this);
    }

    @Override
    public RpkitMoneyHidden as(Name alias) {
        return new RpkitMoneyHidden(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitMoneyHidden rename(String name) {
        return new RpkitMoneyHidden(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitMoneyHidden rename(Name name) {
        return new RpkitMoneyHidden(name, null);
    }

    // -------------------------------------------------------------------------
    // Row1 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row1<Integer> fieldsRow() {
        return (Row1) super.fieldsRow();
    }
}
