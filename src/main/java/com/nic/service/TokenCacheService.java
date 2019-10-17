package com.nic.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * TokenCacheBiz class
 *
 * @author : cyl
 * @date : 2018/10/12 下午3:27
 * @description :token缓存
 * @since : 1.0
 */
@Service
public class TokenCacheService {

    private final LoadingCache<String, String> tokenCaches = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(30, TimeUnit.DAYS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return null;
                }
            });

    public void addToken(String token) {
        if (StringUtils.isBlank(token)) {
            return;
        }
        tokenCaches.put(token, token);
    }

    public void deleteToken(String token) {
        if (StringUtils.isBlank(token)) {
            return;
        }
        tokenCaches.invalidate(token);
    }

    public String getToken(String key) {
        try {
            return tokenCaches.get(key);
        } catch (Exception e) {
            return null;
        }
    }
}
