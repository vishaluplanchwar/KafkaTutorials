/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.vishaluplanch.kafka.avro.schema;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class StockOrders extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5245077546711085376L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"StockOrders\",\"namespace\":\"com.vishaluplanch.kafka.avro.schema\",\"fields\":[{\"name\":\"stockId\",\"type\":\"long\",\"default\":-1},{\"name\":\"orderQuantity\",\"type\":\"long\",\"default\":-1},{\"name\":\"orderPrice\",\"type\":\"double\",\"default\":0.0},{\"name\":\"totalOrderAmount\",\"type\":\"double\",\"default\":0.0},{\"name\":\"stockName\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"orderType\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"exchange\",\"type\":[\"null\",\"string\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<StockOrders> ENCODER =
      new BinaryMessageEncoder<StockOrders>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<StockOrders> DECODER =
      new BinaryMessageDecoder<StockOrders>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<StockOrders> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<StockOrders> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<StockOrders>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this StockOrders to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a StockOrders from a ByteBuffer. */
  public static StockOrders fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public long stockId;
  @Deprecated public long orderQuantity;
  @Deprecated public double orderPrice;
  @Deprecated public double totalOrderAmount;
  @Deprecated public java.lang.CharSequence stockName;
  @Deprecated public java.lang.CharSequence orderType;
  @Deprecated public java.lang.CharSequence exchange;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public StockOrders() {}

  /**
   * All-args constructor.
   * @param stockId The new value for stockId
   * @param orderQuantity The new value for orderQuantity
   * @param orderPrice The new value for orderPrice
   * @param totalOrderAmount The new value for totalOrderAmount
   * @param stockName The new value for stockName
   * @param orderType The new value for orderType
   * @param exchange The new value for exchange
   */
  public StockOrders(java.lang.Long stockId, java.lang.Long orderQuantity, java.lang.Double orderPrice, java.lang.Double totalOrderAmount, java.lang.CharSequence stockName, java.lang.CharSequence orderType, java.lang.CharSequence exchange) {
    this.stockId = stockId;
    this.orderQuantity = orderQuantity;
    this.orderPrice = orderPrice;
    this.totalOrderAmount = totalOrderAmount;
    this.stockName = stockName;
    this.orderType = orderType;
    this.exchange = exchange;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return stockId;
    case 1: return orderQuantity;
    case 2: return orderPrice;
    case 3: return totalOrderAmount;
    case 4: return stockName;
    case 5: return orderType;
    case 6: return exchange;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: stockId = (java.lang.Long)value$; break;
    case 1: orderQuantity = (java.lang.Long)value$; break;
    case 2: orderPrice = (java.lang.Double)value$; break;
    case 3: totalOrderAmount = (java.lang.Double)value$; break;
    case 4: stockName = (java.lang.CharSequence)value$; break;
    case 5: orderType = (java.lang.CharSequence)value$; break;
    case 6: exchange = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'stockId' field.
   * @return The value of the 'stockId' field.
   */
  public java.lang.Long getStockId() {
    return stockId;
  }

  /**
   * Sets the value of the 'stockId' field.
   * @param value the value to set.
   */
  public void setStockId(java.lang.Long value) {
    this.stockId = value;
  }

  /**
   * Gets the value of the 'orderQuantity' field.
   * @return The value of the 'orderQuantity' field.
   */
  public java.lang.Long getOrderQuantity() {
    return orderQuantity;
  }

  /**
   * Sets the value of the 'orderQuantity' field.
   * @param value the value to set.
   */
  public void setOrderQuantity(java.lang.Long value) {
    this.orderQuantity = value;
  }

  /**
   * Gets the value of the 'orderPrice' field.
   * @return The value of the 'orderPrice' field.
   */
  public java.lang.Double getOrderPrice() {
    return orderPrice;
  }

  /**
   * Sets the value of the 'orderPrice' field.
   * @param value the value to set.
   */
  public void setOrderPrice(java.lang.Double value) {
    this.orderPrice = value;
  }

  /**
   * Gets the value of the 'totalOrderAmount' field.
   * @return The value of the 'totalOrderAmount' field.
   */
  public java.lang.Double getTotalOrderAmount() {
    return totalOrderAmount;
  }

  /**
   * Sets the value of the 'totalOrderAmount' field.
   * @param value the value to set.
   */
  public void setTotalOrderAmount(java.lang.Double value) {
    this.totalOrderAmount = value;
  }

  /**
   * Gets the value of the 'stockName' field.
   * @return The value of the 'stockName' field.
   */
  public java.lang.CharSequence getStockName() {
    return stockName;
  }

  /**
   * Sets the value of the 'stockName' field.
   * @param value the value to set.
   */
  public void setStockName(java.lang.CharSequence value) {
    this.stockName = value;
  }

  /**
   * Gets the value of the 'orderType' field.
   * @return The value of the 'orderType' field.
   */
  public java.lang.CharSequence getOrderType() {
    return orderType;
  }

  /**
   * Sets the value of the 'orderType' field.
   * @param value the value to set.
   */
  public void setOrderType(java.lang.CharSequence value) {
    this.orderType = value;
  }

  /**
   * Gets the value of the 'exchange' field.
   * @return The value of the 'exchange' field.
   */
  public java.lang.CharSequence getExchange() {
    return exchange;
  }

  /**
   * Sets the value of the 'exchange' field.
   * @param value the value to set.
   */
  public void setExchange(java.lang.CharSequence value) {
    this.exchange = value;
  }

  /**
   * Creates a new StockOrders RecordBuilder.
   * @return A new StockOrders RecordBuilder
   */
  public static com.vishaluplanch.kafka.avro.schema.StockOrders.Builder newBuilder() {
    return new com.vishaluplanch.kafka.avro.schema.StockOrders.Builder();
  }

  /**
   * Creates a new StockOrders RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new StockOrders RecordBuilder
   */
  public static com.vishaluplanch.kafka.avro.schema.StockOrders.Builder newBuilder(com.vishaluplanch.kafka.avro.schema.StockOrders.Builder other) {
    return new com.vishaluplanch.kafka.avro.schema.StockOrders.Builder(other);
  }

  /**
   * Creates a new StockOrders RecordBuilder by copying an existing StockOrders instance.
   * @param other The existing instance to copy.
   * @return A new StockOrders RecordBuilder
   */
  public static com.vishaluplanch.kafka.avro.schema.StockOrders.Builder newBuilder(com.vishaluplanch.kafka.avro.schema.StockOrders other) {
    return new com.vishaluplanch.kafka.avro.schema.StockOrders.Builder(other);
  }

  /**
   * RecordBuilder for StockOrders instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<StockOrders>
    implements org.apache.avro.data.RecordBuilder<StockOrders> {

    private long stockId;
    private long orderQuantity;
    private double orderPrice;
    private double totalOrderAmount;
    private java.lang.CharSequence stockName;
    private java.lang.CharSequence orderType;
    private java.lang.CharSequence exchange;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.vishaluplanch.kafka.avro.schema.StockOrders.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.stockId)) {
        this.stockId = data().deepCopy(fields()[0].schema(), other.stockId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.orderQuantity)) {
        this.orderQuantity = data().deepCopy(fields()[1].schema(), other.orderQuantity);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.orderPrice)) {
        this.orderPrice = data().deepCopy(fields()[2].schema(), other.orderPrice);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.totalOrderAmount)) {
        this.totalOrderAmount = data().deepCopy(fields()[3].schema(), other.totalOrderAmount);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.stockName)) {
        this.stockName = data().deepCopy(fields()[4].schema(), other.stockName);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.orderType)) {
        this.orderType = data().deepCopy(fields()[5].schema(), other.orderType);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.exchange)) {
        this.exchange = data().deepCopy(fields()[6].schema(), other.exchange);
        fieldSetFlags()[6] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing StockOrders instance
     * @param other The existing instance to copy.
     */
    private Builder(com.vishaluplanch.kafka.avro.schema.StockOrders other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.stockId)) {
        this.stockId = data().deepCopy(fields()[0].schema(), other.stockId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.orderQuantity)) {
        this.orderQuantity = data().deepCopy(fields()[1].schema(), other.orderQuantity);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.orderPrice)) {
        this.orderPrice = data().deepCopy(fields()[2].schema(), other.orderPrice);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.totalOrderAmount)) {
        this.totalOrderAmount = data().deepCopy(fields()[3].schema(), other.totalOrderAmount);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.stockName)) {
        this.stockName = data().deepCopy(fields()[4].schema(), other.stockName);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.orderType)) {
        this.orderType = data().deepCopy(fields()[5].schema(), other.orderType);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.exchange)) {
        this.exchange = data().deepCopy(fields()[6].schema(), other.exchange);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'stockId' field.
      * @return The value.
      */
    public java.lang.Long getStockId() {
      return stockId;
    }

    /**
      * Sets the value of the 'stockId' field.
      * @param value The value of 'stockId'.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.StockOrders.Builder setStockId(long value) {
      validate(fields()[0], value);
      this.stockId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'stockId' field has been set.
      * @return True if the 'stockId' field has been set, false otherwise.
      */
    public boolean hasStockId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'stockId' field.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.StockOrders.Builder clearStockId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'orderQuantity' field.
      * @return The value.
      */
    public java.lang.Long getOrderQuantity() {
      return orderQuantity;
    }

    /**
      * Sets the value of the 'orderQuantity' field.
      * @param value The value of 'orderQuantity'.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.StockOrders.Builder setOrderQuantity(long value) {
      validate(fields()[1], value);
      this.orderQuantity = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'orderQuantity' field has been set.
      * @return True if the 'orderQuantity' field has been set, false otherwise.
      */
    public boolean hasOrderQuantity() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'orderQuantity' field.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.StockOrders.Builder clearOrderQuantity() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'orderPrice' field.
      * @return The value.
      */
    public java.lang.Double getOrderPrice() {
      return orderPrice;
    }

    /**
      * Sets the value of the 'orderPrice' field.
      * @param value The value of 'orderPrice'.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.StockOrders.Builder setOrderPrice(double value) {
      validate(fields()[2], value);
      this.orderPrice = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'orderPrice' field has been set.
      * @return True if the 'orderPrice' field has been set, false otherwise.
      */
    public boolean hasOrderPrice() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'orderPrice' field.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.StockOrders.Builder clearOrderPrice() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'totalOrderAmount' field.
      * @return The value.
      */
    public java.lang.Double getTotalOrderAmount() {
      return totalOrderAmount;
    }

    /**
      * Sets the value of the 'totalOrderAmount' field.
      * @param value The value of 'totalOrderAmount'.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.StockOrders.Builder setTotalOrderAmount(double value) {
      validate(fields()[3], value);
      this.totalOrderAmount = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'totalOrderAmount' field has been set.
      * @return True if the 'totalOrderAmount' field has been set, false otherwise.
      */
    public boolean hasTotalOrderAmount() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'totalOrderAmount' field.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.StockOrders.Builder clearTotalOrderAmount() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'stockName' field.
      * @return The value.
      */
    public java.lang.CharSequence getStockName() {
      return stockName;
    }

    /**
      * Sets the value of the 'stockName' field.
      * @param value The value of 'stockName'.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.StockOrders.Builder setStockName(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.stockName = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'stockName' field has been set.
      * @return True if the 'stockName' field has been set, false otherwise.
      */
    public boolean hasStockName() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'stockName' field.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.StockOrders.Builder clearStockName() {
      stockName = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'orderType' field.
      * @return The value.
      */
    public java.lang.CharSequence getOrderType() {
      return orderType;
    }

    /**
      * Sets the value of the 'orderType' field.
      * @param value The value of 'orderType'.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.StockOrders.Builder setOrderType(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.orderType = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'orderType' field has been set.
      * @return True if the 'orderType' field has been set, false otherwise.
      */
    public boolean hasOrderType() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'orderType' field.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.StockOrders.Builder clearOrderType() {
      orderType = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'exchange' field.
      * @return The value.
      */
    public java.lang.CharSequence getExchange() {
      return exchange;
    }

    /**
      * Sets the value of the 'exchange' field.
      * @param value The value of 'exchange'.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.StockOrders.Builder setExchange(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.exchange = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'exchange' field has been set.
      * @return True if the 'exchange' field has been set, false otherwise.
      */
    public boolean hasExchange() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'exchange' field.
      * @return This builder.
      */
    public com.vishaluplanch.kafka.avro.schema.StockOrders.Builder clearExchange() {
      exchange = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public StockOrders build() {
      try {
        StockOrders record = new StockOrders();
        record.stockId = fieldSetFlags()[0] ? this.stockId : (java.lang.Long) defaultValue(fields()[0]);
        record.orderQuantity = fieldSetFlags()[1] ? this.orderQuantity : (java.lang.Long) defaultValue(fields()[1]);
        record.orderPrice = fieldSetFlags()[2] ? this.orderPrice : (java.lang.Double) defaultValue(fields()[2]);
        record.totalOrderAmount = fieldSetFlags()[3] ? this.totalOrderAmount : (java.lang.Double) defaultValue(fields()[3]);
        record.stockName = fieldSetFlags()[4] ? this.stockName : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.orderType = fieldSetFlags()[5] ? this.orderType : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.exchange = fieldSetFlags()[6] ? this.exchange : (java.lang.CharSequence) defaultValue(fields()[6]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<StockOrders>
    WRITER$ = (org.apache.avro.io.DatumWriter<StockOrders>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<StockOrders>
    READER$ = (org.apache.avro.io.DatumReader<StockOrders>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}