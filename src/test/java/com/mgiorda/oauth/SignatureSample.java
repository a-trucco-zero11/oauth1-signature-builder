package com.mgiorda.oauth;

import com.github.mgiorda.oauth.HttpMethod;
import com.github.mgiorda.oauth.OAuthConfig;
import com.github.mgiorda.oauth.OAuthConfigBuilder;
import com.github.mgiorda.oauth.OAuthSignature;

public class SignatureSample {

    public static void main(String[] args) {

		OAuthConfig oauthConfig = new OAuthConfigBuilder("myApiKey", "myApiSecret")
				.setTokenKeys("myAccessKey", "myAccessSecret")
				.build();

		OAuthSignature signature = oauthConfig.buildSignature(HttpMethod.GET, "http://serviceUrl")
				.addQueryParam("aParam", "aValue")
				.addFormUrlEncodedParam("myParam", "anotherValue")
				.create();

		System.out.println(signature.getAsHeader());
    }
}