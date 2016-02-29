package com.abc;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class AccountTest {
	@Test(expected = IllegalArgumentException.class)
    public void testNegativeWithdraw() {
    	Account checkingAccount = new Account(Account.CHECKING);
        checkingAccount.withdraw(-1.0);
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void testNegativeDeposit() {
    	Account checkingAccount = new Account(Account.CHECKING);
        checkingAccount.deposit(-1.0);
    }
	
	@Test
	public void testInterestEarned() {
		Account savingsAccount = new Account(Account.SAVINGS);
		Account maxiSavingsAccount = new Account(Account.MAXI_SAVINGS);
		savingsAccount.deposit(800.0);
		maxiSavingsAccount.deposit(900.0);
		Assert.assertEquals(0.8, savingsAccount.interestEarned(), 0.00001);
		Assert.assertEquals(18, maxiSavingsAccount.interestEarned(), 0.00001);
	}
	
	@Test
	public void testInterestEarnedMaxi() {
		Account maxiSavingsAccount = new Account(Account.MAXI_SAVINGS);
		maxiSavingsAccount.deposit(1100.0);
		Assert.assertEquals(25, maxiSavingsAccount.interestEarned(), 0.00001);
	}
}
