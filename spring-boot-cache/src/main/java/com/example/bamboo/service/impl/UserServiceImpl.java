package com.example.bamboo.service.impl;

import com.example.bamboo.entity.User;
import com.example.bamboo.mapper.UserMapper;
import com.example.bamboo.service.UserService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author brotherming
 * @createTime 2024年08月04日 13:03:00
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedissonClient redisson;

    @Override
    public List<User> getUserList() {
        return userMapper.findAll();
    }

    //@Cacheable(cacheNames = "User", key = "#root.methodName")
    @Cacheable(
            keyGenerator = "myKeyGenerator",
            condition = "#id > 1",  // 根据条件确定是否缓存
            unless = "#result == null" // 缓存否决
    )
    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    /**
     * 分布式锁
     */
    public int reduceStore(Integer id) {
        int update = 0;
        RLock lock = redisson.getLock("reduceStore");
        try {
            lock.lock();
            // 业务
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
        return update;
    }
}
