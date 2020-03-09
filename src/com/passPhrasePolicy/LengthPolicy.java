package com.passPhrasePolicy;

import net.sf.json.JSONObject;

public class LengthPolicy implements IPassPhrasePolicy {
	private final String POLICY_CODE = "MIN_LENGTH";

	@Override
	public IResponse validatePolicy(String passPhrase, Object configuration) {
		// code for demo;
		JSONObject json = (JSONObject) configuration;
		int minLength = json.optInt("minLength");
		Response response = new Response();
		if (passPhrase.length() < minLength) {
			response.setResponseCode(IResponseCode.ERR_LENGTH_POLICY_FAIL);
			response.setResponseMessage("Minium required lenght is 8 characters");
		} else {
			response.setResponseCode(IResponseCode.SUCCESS);
			response.setResponseMessage("Minimum required length requirements met!");
		}
		return response;
	}

	public String getPolicyCode() {
		return POLICY_CODE;
	}
}
