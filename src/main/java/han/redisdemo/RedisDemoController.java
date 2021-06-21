/**
 * @FileName: RedisDemoController.java
 * @creator zhaohanyang
 * @date Jun 21, 2021
 * @editor
 * @Description: 
 * @version V1.0
 */
package han.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: RedisDemoController
 * @Description: 
 * @author zhaohanyang
 * @date Jun 21, 2021
 * @version V1.0
 */
@RestController
@Slf4j
public class RedisDemoController {

	@Autowired
	RedisDemoDao redisDemoDao;
	
	@RequestMapping(value = "/han")
	@ResponseBody
	public String Demo(String user,String password) {
		redisDemoDao.setString("user", user);
		redisDemoDao.setString("password", password);
		redisDemoDao.setString("movie", "lalaland");

		log.info("name=" + user + " * " + "age=" + password);
		String retUser = redisDemoDao.getString("user");
		String retPassword= redisDemoDao.getString("password");

		log.error("retUser=" + retUser + " $ " + "retPassword=" + retPassword);
		return retUser + "$$$" + retPassword;
	}
}
