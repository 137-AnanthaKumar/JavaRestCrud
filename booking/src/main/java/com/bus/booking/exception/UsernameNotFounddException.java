package com.bus.booking.exception;

public class UsernameNotFounddException extends RuntimeException {
	public class AlreadyHaveBus extends RuntimeException{

		public AlreadyHaveBus(String message) {
			super(message);
		}

		private static final long serialVersionUID = 1L;

	}

}
