package com.example.usedrecycling.product;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into products (description, price, seller_id) values(#{product.description}, #{product.price}, #{userId})")
    void insertProduct(@Param("product") ProductRegisterPostRequest productRegisterPostRequest, @Param("userId") Integer userId);

    @Select("SELECT * FROM products")
    List<Product> getAllProducts();

    @Select("SELECT * FROM products WHERE id = #{id}")
    Product getProductById(Integer id);

    @Delete("DELETE FROM products WHERE id = #{id}")
    void deleteProduct(Integer id);

    @Update("UPDATE products SET description = #{description}, price = #{price} WHERE id = #{id}")
    void updateProduct(Product product);
}
