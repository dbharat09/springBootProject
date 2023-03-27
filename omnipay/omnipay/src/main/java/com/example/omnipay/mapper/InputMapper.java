package com.example.omnipay.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.ExclusionStrategy;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

/*
 * the class is used to map the input string with the POJO class.
 */
@Service
public class InputMapper {

		static GsonBuilder builder;
		ExclusionStrategy strategy;
		Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

		public InputMapper() {
			if (builder == null) {
				builder = new GsonBuilder();
				builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
			}
		}

		public static InputMapper gson() {
			return new InputMapper();
		}

		public <T> T fromJson(String json, Class<T> classOfT)  {
			return builder.create().fromJson(json, classOfT);
		}

		public <T> T fromJson(JsonElement json, Class<T> classOfT)  {
			return builder.create().fromJson(json, classOfT);
		}

		
}
