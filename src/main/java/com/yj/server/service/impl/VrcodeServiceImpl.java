package com.yj.server.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.yj.server.redis.RedisClient;
import com.yj.server.redis.RedisKeyConstants;
import com.yj.server.service.VrcodeService;

/**
 * 
 * 
 * 功能描述： 验证码业务 创建人：Administrator 创建时间：2018年9月15日 下午1:51:31
 * 
 * @version
 *
 */
@Service
public class VrcodeServiceImpl implements VrcodeService {
	@Autowired
	private RedisClient redisClient;
	@Autowired
	private DefaultKaptcha defaultKaptcha;

	/**
	 * 创建验证码
	 */
	@Override
	public void createVrcode(String id, HttpServletResponse httpServletResponse) {
		byte[] captchaChallengeAsJpeg = null;
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		try {
			// 生产验证码字符串并保存到session中
			String createText = defaultKaptcha.createText();
			redisClient.set(RedisKeyConstants.KEY_NAME_VRCODE + id, createText);
			// 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
			BufferedImage challenge = defaultKaptcha.createImage(createText);
			ImageIO.write(challenge, "jpg", jpegOutputStream);
			// 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
			captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
			httpServletResponse.setHeader("Cache-Control", "no-store");
			httpServletResponse.setHeader("Pragma", "no-cache");
			httpServletResponse.setDateHeader("Expires", 0);
			httpServletResponse.setContentType("image/jpeg");
			ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
			responseOutputStream.write(captchaChallengeAsJpeg);
			responseOutputStream.flush();
			responseOutputStream.close();
		} catch (Exception e) {
		}
	}

	/**
	 * 校验验证码
	 */
	@Override
	public boolean checkVrcode(String id, String code) {
		if (null == id || null == code) {
			return false;
		}
		String redisCode = redisClient.get(RedisKeyConstants.KEY_NAME_VRCODE + id);
		return null != redisCode && code.equals(redisCode);
	}

}
