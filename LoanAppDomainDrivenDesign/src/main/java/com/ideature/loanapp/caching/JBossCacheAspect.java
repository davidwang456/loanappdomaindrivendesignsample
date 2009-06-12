/**
 * 
 */
package com.ideature.loanapp.caching;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.cache.Cache;
import org.jboss.cache.CacheFactory;
import org.jboss.cache.DefaultCacheFactory;
import org.jboss.cache.Fqn;

/**
 * @author Srini
 *
 */
@Aspect
public class JBossCacheAspect extends BaseCacheAspect {

    private static Log log = LogFactory.getLog(JBossCacheAspect.class);
    
    private CacheFactory factory;
    private Cache cache;

    private String props = null;
    private String cacheGroupName = "CacheGroup";
    private String key = "ProductRates";
    private String fqnName = "/cacheaop/cache/object";

    @Override
    public void init() {
    	log.debug("Initializing cache.");
    	if (factory == null) {
    		factory = new DefaultCacheFactory();
    	}
    	if (cache == null) {
    		cache = factory.createCache();
    	
    		// Have to create and start cache before using it
    		cache.create();
    		cache.start();
    	}
    }
    
    @Override
    public void cleanup() {
    	log.debug("Destroying cache.");
    	cache.stop();
    	cache.destroy();
    }
    
    @Override
    public void put(String cacheKey, Object cacheObj) {
    	log.debug("Adding object to cache.");
    	Fqn fqn = Fqn.fromString(fqnName);
    	cache.put(fqn, cacheKey, cacheObj);
    }
    
    @Override
    public Object get(String cacheKey) {
    	log.debug("Retrieving object from cache for key " + cacheKey);
    	Fqn fqn = Fqn.fromString(fqnName);
    	Object cachedObj = cache.get(fqn, cacheKey);
    	
    	return cachedObj;
    }
    
}
