package com.example.springbbs.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.example.springbbs.Domain.Item;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Item> findAll() {
        String query = "SELECT * from item";
        List<Item> items = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Item.class));
        return items;
    }

    public Item save(Item item) {

        SqlParameterSource param = new BeanPropertySqlParameterSource(item);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("item")
                .usingGeneratedKeyColumns("id");

        Number key = insert.executeAndReturnKey(param);
        item.setId(key.longValue());
        System.out.println("Add:" + item);
        return item;

    }

}