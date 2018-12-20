/**
 * Project Name:Eureka-Server
 * Package Name:com.eureka.server
 * File Name:SpringCloudEurekaApplication.java
 * Date:2018年12月11日 上午10:00:50
 * Copyright (c) 2018,TravelSky. All Rights Reserved.
 *
 */
package com.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * ClassName: SpringCloudEurekaApplication <br/>
 * Description: TODO <br/>
 * Date: 2018年12月11日 上午10:00:50 <br/>
 * @author liuqiqi <br/>
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaApplication.class, args);
	}
}
