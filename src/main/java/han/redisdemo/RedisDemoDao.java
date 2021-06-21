/**
 * @FileName: RedisDemoDao.java
 * @creator zhaohanyang
 * @date Jun 21, 2021
 * @editor
 * @Description: 
 * @version V1.0
 */
package han.redisdemo;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: RedisDemoDao
 * @Description: 
 * @author zhaohanyang
 * @date Jun 21, 2021
 * @version V1.0
 */
@Repository
public class RedisDemoDao {
	
	@Autowired
	private StringRedisTemplate template;

	public void setString (String key,String value) {
		ValueOperations<String, String> ops = template.opsForValue();
		ops.set(key, value, 10, TimeUnit.SECONDS);
	}
	public String getString (String key) {
		ValueOperations<String, String> ops = template.opsForValue();
		return ops.get(key);
	}
}
