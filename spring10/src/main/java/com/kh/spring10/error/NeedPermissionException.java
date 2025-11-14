package com.kh.spring10.error;

public class NeedPermissionException extends RuntimeException {
	private static final long serialVersionUID = 1;

	public NeedPermissionException() {
		super();
	}

	public NeedPermissionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
