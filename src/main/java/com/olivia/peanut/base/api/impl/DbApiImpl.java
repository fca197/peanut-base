package com.olivia.peanut.base.api.impl;

import cn.hutool.core.io.FileUtil;
import com.olivia.peanut.base.api.DbApi;
import com.olivia.peanut.base.api.entity.db.DbResetReq;
import com.olivia.peanut.base.api.entity.db.DbResetRes;
import com.olivia.sdk.ann.RedissonLockAnn;
import com.olivia.sdk.utils.DateUtils;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DbApiImpl implements DbApi {
  @Resource
  JdbcTemplate jdbcTemplate;
  @Resource
  StringRedisTemplate stringRedisTemplate;


  @Override
  @RedissonLockAnn(lockPrefix = "db:reset", afterDeleteKey = false, isWait = false, lockTimeOut = 12 * 60 * 60 * 1000)
  public DbResetRes dbReset(DbResetReq req) {

    String path = "/opt/app/db-init.sql";

//    path = "/Users/wangbao/Downloads/db-init.sql";

    String content = FileUtil.readUtf8String(path);
    if (StringUtils.isBlank(content)) {
      return new DbResetRes().setFileSize(0);
    }

    // 分割 SQL 语句
    List<String> sqlStatements = splitSqlStatements(content);
    // 执行 SQL 语句
    executeStatements(sqlStatements);
    return new DbResetRes().setFileSize(content.length());
  }

  @Override
  public DbResetRes dbResetLast(DbResetReq req) {
    Long expire = this.stringRedisTemplate.getExpire("db:reset:biz:all");
    return new DbResetRes().setRemainingTime(DateUtils.formatSeconds(expire)).setExpire(expire);
  }

  private String readSqlFile(String sqlFilePath) throws IOException {
    StringBuilder content = new StringBuilder();
    // 从类路径下获取 SQL 文件的输入流
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(sqlFilePath);
    if (inputStream == null) {
      throw new IOException("未找到 SQL 文件: " + sqlFilePath);
    }
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append("\n");
      }
    }
    return content.toString();
  }

  private List<String> splitSqlStatements(String sqlContent) {
    List<String> statements = new ArrayList<>();
    StringBuilder currentStatement = new StringBuilder();
    for (String line : sqlContent.split("\n")) {
      line = line.trim();
      if (line.isEmpty() || line.startsWith("--")) {
        continue;
      }
      currentStatement.append(line).append(" ");
      if (line.endsWith(";")) {
        statements.add(currentStatement.toString().trim());
        currentStatement.setLength(0);
      }
    }
    if (!currentStatement.isEmpty()) {
      statements.add(currentStatement.toString().trim());
    }
    return statements;
  }

  private void executeStatements(List<String> sqlStatements) {
    for (String sql : sqlStatements) {
      try {
        jdbcTemplate.execute(sql);
      } catch (Exception e) {
        System.err.println("执行 SQL 语句时出错: " + sql);
        e.printStackTrace();
      }
    }
  }
}
