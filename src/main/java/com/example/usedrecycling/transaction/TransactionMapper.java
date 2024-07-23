package com.example.usedrecycling.transaction;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TransactionMapper {
    @Insert("insert into transactions (product_id, seller_id, cust_id, mail_location, number) VALUES(#{productId}, #{sellerId}, #{custId}, #{mailLocation}, #{number})")
    void insertTransaction(Transaction transaction);

    @Select("SELECT * FROM transactions WHERE seller_id = ${sellerId}")
    List<Transaction> getTransactionsBySellerId(Integer sellerId);

    @Select("SELECT * FROM transactions WHERE cust_id = ${custId}")
    List<Transaction> getTransactionsByCustId(Integer custId);

    @Select("SELECT * FROM transactions WHERE id = ${id}")
    Transaction getTransactionById(Integer id);

    @Update("UPDATE transactions SET status = 1 WHERE id = ${id}")
    void setTransactionStatusAsFinished(Integer id);
}
