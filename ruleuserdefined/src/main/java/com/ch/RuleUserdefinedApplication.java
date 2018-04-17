package com.ch;

import com.ch.rule.UserDefinedReload;
import com.ch.rule.WeMedia;
import com.google.common.collect.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RuleUserdefinedApplication {

	public static void main(String[] args) {
		try {
			List<WeMedia> weMedias = Lists.newArrayList();
			WeMedia weMedia = new WeMedia();
			weMedia.setUploaderId(111l);
			weMedia.setVerifyFlag_r(1);
			weMedia.setVerified_r(1);
			weMedias.add(weMedia);

			UserDefinedReload userDefinedReload = new UserDefinedReload();
			userDefinedReload.reload(weMedias);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//SpringApplication.run(RuleUserdefinedApplication.class, args);
	}
}
