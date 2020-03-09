package com.passPhrasePolicy;

public class Response implements IResponse {
	private String responseCode;
	private String responseMessage;

	@Override
	public String getResponseCode() {
		return responseCode;
	}

	@Override
	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
