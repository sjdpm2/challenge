package com.telusinternational.challenge.constants;

public final class Consts  {

	  /** Type for committeAvailableforUser function  **/
	  public static final Integer BY_COMMITTEE_ID = 1;
	  public static final Integer BY_CANDIDATE_ID = 2;
	  
	  /** Roles values **/
	  public static final Integer ROLE_USER = 1;
	  public static final Integer ROLE_ADMIN = 2;
	  
	  private Consts(){
		    throw new AssertionError();
		  }
}
