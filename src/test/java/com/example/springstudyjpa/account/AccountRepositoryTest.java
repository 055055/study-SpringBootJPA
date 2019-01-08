package com.example.springstudyjpa.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() throws SQLException {
        Account account = new Account();
        account.setUsername("055055");
        account.setPassword("kkk");

        Account newAccount = accountRepository.save(account);

        assertThat(newAccount).isNotNull();
       Account existAccount = accountRepository.findByUsername(newAccount.getUsername());
         assertThat(existAccount).isNotNull();

         //일부로 없는 아이디 조회해서 null check
        Account nonexistAccount = accountRepository.findByUsername("exid");
        assertThat(nonexistAccount).isNull();
    }

}