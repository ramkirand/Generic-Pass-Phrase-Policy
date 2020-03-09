package com.passPhrasePolicy;



public interface IPassPhrasePolicy {
	/**
	 * Validate the passPhrase against a given Policy
	 * @param passPhrase
	 * @return
	 */
	IResponse validatePolicy(String passPhrase, Object configuration);

	/**
	 * Get the policy code of the policy
	 * @return
	 */
	String getPolicyCode();
}
