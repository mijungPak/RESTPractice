package com.example.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.app.domain.Weather;
import com.example.app.domain.ZipInfo;

@Controller
public class RestController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	@Qualifier("zipCodeSearchRestTemplate")
	private RestTemplate zipcodeRestTemplate;

	@GetMapping({"", "/rest"})
	public String getRestData(
			HttpSession session,
			@RequestParam(name = "zipcode", required = false) String zipcode,
			@RequestParam(name = "areaId", required = false) String areaId,
			Model model) {

		//郵便番号
		if(zipcode != null) {
			String url = "https://zipcloud.ibsnet.co.jp/api/search?zipcode=" + zipcode;

			ZipInfo info = zipcodeRestTemplate.getForObject(url, ZipInfo.class, zipcode);

			System.out.println(info.getResults());
			model.addAttribute("info", info);
		}

		//お天気
		if(areaId != null) {
			String url = "https://weather.tsukumijima.net/api/forecast/city/" + areaId;

			Weather weather = restTemplate.getForObject(url, Weather.class);

			System.out.println(weather);
			model.addAttribute("weather", weather);
		}

		return "rest";
	}
}
