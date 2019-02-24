/*
 * This file is generated by jOOQ.
 */
package com.rpkit.stores.bukkit.database.jooq.rpkit.tables.records;


import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitPurchase;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitPurchaseRecord extends UpdatableRecordImpl<RpkitPurchaseRecord> implements Record4<Integer, Integer, Integer, Timestamp> {

    private static final long serialVersionUID = -1333891435;

    /**
     * Setter for <code>rpkit.rpkit_purchase.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_purchase.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit.rpkit_purchase.store_item_id</code>.
     */
    public void setStoreItemId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_purchase.store_item_id</code>.
     */
    public Integer getStoreItemId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rpkit.rpkit_purchase.profile_id</code>.
     */
    public void setProfileId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_purchase.profile_id</code>.
     */
    public Integer getProfileId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>rpkit.rpkit_purchase.purchase_date</code>.
     */
    public void setPurchaseDate(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_purchase.purchase_date</code>.
     */
    public Timestamp getPurchaseDate() {
        return (Timestamp) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, Timestamp> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, Timestamp> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return RpkitPurchase.RPKIT_PURCHASE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return RpkitPurchase.RPKIT_PURCHASE.STORE_ITEM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return RpkitPurchase.RPKIT_PURCHASE.PROFILE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return RpkitPurchase.RPKIT_PURCHASE.PURCHASE_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getStoreItemId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getProfileId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getPurchaseDate();
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
        return getStoreItemId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getProfileId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getPurchaseDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitPurchaseRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitPurchaseRecord value2(Integer value) {
        setStoreItemId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitPurchaseRecord value3(Integer value) {
        setProfileId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitPurchaseRecord value4(Timestamp value) {
        setPurchaseDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitPurchaseRecord values(Integer value1, Integer value2, Integer value3, Timestamp value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitPurchaseRecord
     */
    public RpkitPurchaseRecord() {
        super(RpkitPurchase.RPKIT_PURCHASE);
    }

    /**
     * Create a detached, initialised RpkitPurchaseRecord
     */
    public RpkitPurchaseRecord(Integer id, Integer storeItemId, Integer profileId, Timestamp purchaseDate) {
        super(RpkitPurchase.RPKIT_PURCHASE);

        set(0, id);
        set(1, storeItemId);
        set(2, profileId);
        set(3, purchaseDate);
    }
}