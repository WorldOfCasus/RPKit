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
package com.rpkit.chat.bukkit.database.jooq.tables;


import com.rpkit.chat.bukkit.database.jooq.RpkitChat;
import com.rpkit.chat.bukkit.database.jooq.tables.records.RpkitChatGroupInviteRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitChatGroupInvite extends TableImpl<RpkitChatGroupInviteRecord> {

    private static final long serialVersionUID = 736668904;

    /**
     * The reference instance of <code>rpkit_chat.rpkit_chat_group_invite</code>
     */
    public static final RpkitChatGroupInvite RPKIT_CHAT_GROUP_INVITE = new RpkitChatGroupInvite();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitChatGroupInviteRecord> getRecordType() {
        return RpkitChatGroupInviteRecord.class;
    }

    /**
     * The column <code>rpkit_chat.rpkit_chat_group_invite.chat_group_id</code>.
     */
    public final TableField<RpkitChatGroupInviteRecord, Integer> CHAT_GROUP_ID = createField(DSL.name("chat_group_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit_chat.rpkit_chat_group_invite.minecraft_profile_id</code>.
     */
    public final TableField<RpkitChatGroupInviteRecord, Integer> MINECRAFT_PROFILE_ID = createField(DSL.name("minecraft_profile_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>rpkit_chat.rpkit_chat_group_invite</code> table reference
     */
    public RpkitChatGroupInvite() {
        this(DSL.name("rpkit_chat_group_invite"), null);
    }

    /**
     * Create an aliased <code>rpkit_chat.rpkit_chat_group_invite</code> table reference
     */
    public RpkitChatGroupInvite(String alias) {
        this(DSL.name(alias), RPKIT_CHAT_GROUP_INVITE);
    }

    /**
     * Create an aliased <code>rpkit_chat.rpkit_chat_group_invite</code> table reference
     */
    public RpkitChatGroupInvite(Name alias) {
        this(alias, RPKIT_CHAT_GROUP_INVITE);
    }

    private RpkitChatGroupInvite(Name alias, Table<RpkitChatGroupInviteRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitChatGroupInvite(Name alias, Table<RpkitChatGroupInviteRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> RpkitChatGroupInvite(Table<O> child, ForeignKey<O, RpkitChatGroupInviteRecord> key) {
        super(child, key, RPKIT_CHAT_GROUP_INVITE);
    }

    @Override
    public Schema getSchema() {
        return RpkitChat.RPKIT_CHAT;
    }

    @Override
    public RpkitChatGroupInvite as(String alias) {
        return new RpkitChatGroupInvite(DSL.name(alias), this);
    }

    @Override
    public RpkitChatGroupInvite as(Name alias) {
        return new RpkitChatGroupInvite(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitChatGroupInvite rename(String name) {
        return new RpkitChatGroupInvite(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitChatGroupInvite rename(Name name) {
        return new RpkitChatGroupInvite(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}