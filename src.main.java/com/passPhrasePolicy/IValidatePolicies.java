package com.passPhrasePolicy;

import java.util.List;

//
public interface IValidatePolicies {
	List<? extends IResponse> validatePassPhrasePolicies(String passPhrase,
			List<IPolicyConfiguration> policyConfigurations) throws Exception;
}
