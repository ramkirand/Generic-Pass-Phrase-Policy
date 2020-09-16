package com.passPhrasePolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ValidatePolicies implements IValidatePolicies {
	PassPhrasePolicyHelper helper = new PassPhrasePolicyHelper();

	// Validate passPhrase policy and capture if any errors
	public List<? extends IResponse> validatePassPhrasePolicies(String passPhrase,
			List<IPolicyConfiguration> policyConfigurations) throws Exception {
		List<IResponse> responses = new ArrayList<IResponse>();
		Map<String, String> policyMap = helper.getAvailablePolicies();
		for (String key : policyMap.keySet()) {
			for (IPolicyConfiguration configuration : policyConfigurations) {
				if (configuration.getPolicyCode().equals(key)) {
					IPassPhrasePolicy passPhrasePolicy = PassPhrasePolicyFactory.getInstance()
							.getPasswordPolicy(policyMap.get(key));
					if (passPhrasePolicy == null) {
						System.out.println("Policy instance could not be created for policy : " + key);
					} else {
						responses.add(passPhrasePolicy.validatePolicy(passPhrase, configuration.getConfiguration()));
					}
					break;
				}
			}
		}
		return responses;
	}
}
