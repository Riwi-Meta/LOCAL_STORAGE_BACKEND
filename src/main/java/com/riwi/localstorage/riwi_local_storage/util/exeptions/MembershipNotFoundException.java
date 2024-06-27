package com.riwi.localstorage.riwi_local_storage.util.exeptions;

public class MembershipNotFoundException extends RuntimeException {

  private static final String error_msg = "No memberships found with the id:";

  public MembershipNotFoundException(String message) {
    super(String.format(error_msg, message));
  }
}
